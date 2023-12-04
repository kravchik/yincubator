package yk.jcommon.net.anio;

import yk.jcommon.utils.BadException;
import yk.ycollections.YList;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.function.BiConsumer;

import static yk.ycollections.YArrayList.al;

/**
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 12/12/13
 * Time: 10:10 PM
 */
public class AConnection {//TODO merge back with ASocket?
    private static final int BUFFER_SIZE = 1000000;
    public OnData onData;
    public OnDisconnect onDisconnect;
    public BiConsumer<Object, Integer> onStats;
    boolean closed;
    private final ASerializer serializer;
    private final YList<byte[]> outBytes = al();
    private ByteBuffer outBuffer = ByteBuffer.allocate(BUFFER_SIZE);
    {
        outBuffer.flip();
    }
    private List<Object> inCommands = al();
    private int nextInSize = -1;
    private ByteBuffer inBuffer = ByteBuffer.allocate(BUFFER_SIZE);
    private final byte[] bytes = new byte[BUFFER_SIZE];

    AConnection(ASerializer serializer) {
        this.serializer = serializer;
    }

    static void write(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        AConnection channel = (AConnection) key.attachment();

        while (true) {
            if (!channel.outBuffer.hasRemaining()) {
                channel.outBuffer.flip();
                channel.workWrite();
                channel.outBuffer.flip();
            }
            if (!channel.outBuffer.hasRemaining()) break;

            int numWrite = socketChannel.write(channel.outBuffer);
            if (channel.outBuffer.hasRemaining() || channel.outBytes.isEmpty()) break;
        }
    }

    static void read(SelectionKey key) {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        AConnection ticket = (AConnection) key.attachment();
        try {
            int numRead = socketChannel.read(ticket.inBuffer);//TODO read just as much as needed! Will be faster, don't need move data by .compact()
            ticket.inBuffer.flip();
            ticket.workRead();
            ticket.inBuffer.compact();
            if (numRead == -1) closeChannel(key, ticket);
        } catch (Exception e) {//error in deserialialization, or with net, either way - cannot continue use this socket
            closeChannel(key, ticket);
        }
    }

    private static void closeChannel(SelectionKey key, AConnection ticket) {
        ticket.closed = true;
        if (ticket.onDisconnect != null) ticket.onDisconnect.call();
        try {
            key.channel().close();
        } catch (IOException e1) {
            e1.printStackTrace();
            BadException.die("error while closing key.channel " + e1);
        }
        key.cancel();
    }

    public void send(Object data) {
        byte[] bytes = serializer.serialize(data);
        if (onStats != null) onStats.accept(data, bytes.length);
        synchronized (outBytes) {
            outBytes.add(bytes);
        }
    }

    //TODO test
    public void sendRaw(byte[] bytes) {
        synchronized (outBytes) {
            outBytes.add(bytes);
        }
    }

    //TODO test
    public boolean canSend(int size) {
        return outBuffer.remaining() >= size + 4;//4 - is for int size
    }

    void workWrite() {
        outBuffer.clear();
        if (outBytes.isEmpty()) return;
        byte[] bytes;
        synchronized (outBytes) {
            //TODO use better structure
            bytes = outBytes.remove(0);
        }
        //TODO var len length (1-byte, 2-bytes, 3-bytes, etc)
        //TODO fix if outBytes has no place
        outBuffer.putInt(bytes.length);
        outBuffer.put(bytes);
    }

    void workRead() {
        while (true) {
            if (nextInSize == -1) if (inBuffer.remaining() >= 4) nextInSize = inBuffer.getInt();
            if (nextInSize > BUFFER_SIZE) throw new RuntimeException("in buffer size (" + BUFFER_SIZE + ") too low for data of size " + nextInSize);
            if (nextInSize != -1) {
                if (inBuffer.remaining() >= nextInSize) {
                    inBuffer.get(bytes, 0, nextInSize);
                    nextInSize = -1;
                    inCommands.add(serializer.deserialize(bytes));
                    continue;
                }
            }
            break;
        }

        for (Object o : inCommands) onData.call(o);
        inCommands.clear();
    }
}


