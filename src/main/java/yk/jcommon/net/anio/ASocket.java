package yk.jcommon.net.anio;

import yk.jcommon.utils.BadException;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * TCP client/server
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 12/12/13
 * Time: 11:18 PM
 */
public class ASocket {
    public OnConnection onConnection;
    private final Selector selector;
    private final ASerializer serializer;
    private AConnection aConnection;
    private ServerSocketChannel serverChannel;
    private SocketChannel clientSocketChannel;

    public static ASocket newServer(int port, OnConnection onConnection) {
        return new ASocket(port, new AJavaSerializer(), onConnection);
    }

    public void close() {
        try {
            if (serverChannel != null) serverChannel.close();
            if (clientSocketChannel != null) clientSocketChannel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ASocket(int port, ASerializer serializer, OnConnection onConnection) {
        this.serializer = serializer;
        this.onConnection = onConnection;
        try {
            serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.socket().bind(new InetSocketAddress(port));
            selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static ASocket newClient(String address, int port, OnConnection onConnection) {
        return new ASocket(address, port, new AJavaSerializer(), onConnection);
    }

    public ASocket(String address, int port, ASerializer serializer, OnConnection onConnection) {
        this.serializer = serializer;
        this.onConnection = onConnection;
        aConnection = new AConnection(serializer);
        try {
            clientSocketChannel = SocketChannel.open();
            clientSocketChannel.configureBlocking(false);
            clientSocketChannel.connect(new InetSocketAddress(address, port));
            selector = Selector.open();
            clientSocketChannel.register(selector, SelectionKey.OP_CONNECT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void tick() {
        try {
            if (selector.selectNow() == 0) return;

            for (Iterator<SelectionKey> keys = selector.selectedKeys().iterator(); keys.hasNext(); ) {
                SelectionKey key = keys.next();
                keys.remove();

                if (!key.isValid()) BadException.shouldNeverReachHere("not valid key");
                if (key.isValid() && key.isConnectable()) connect(key);
                if (key.isValid() && key.isAcceptable()) accept(key);
                if (key.isValid() && key.isReadable()) AConnection.read(key);
                if (key.isValid() && key.isWritable()) AConnection.write(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connect(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        try {//TODO handle right
            socketChannel.finishConnect();
        } catch (IOException e) {
            e.printStackTrace();
            key.cancel();
            return;
        }
        // Register an interest in writing on this channel
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, aConnection);
        onConnection.call(aConnection);
    }

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);

        AConnection aclient = new AConnection(serializer);
        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, aclient);
        onConnection.call(aclient);
    }

    public void send(Object o) {
        if (aConnection == null) {
            throw new RuntimeException("Server cannot just send. It can only answer in onConnection");
        }
        aConnection.send(o);
    }
}
