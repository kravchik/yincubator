package yk.jcommon.net.anio.test;

import org.junit.Before;
import org.junit.Test;
import yk.jcommon.collections.YList;
import yk.jcommon.net.anio.ASocket;

import static org.junit.Assert.assertEquals;
import static yk.jcommon.collections.YArrayList.al;

/**
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 12/12/13
 * Time: 10:10 PM
 */
public class Test1 {


    private static YList<String> logs;

    private static void log(String s) {
        logs.add(s);
        System.out.println(s);
    }

    @Before
    public void setUp() throws Exception {
        logs = al();

    }

    private static void tickAll(ASocket... sockets) {
        for (int i = 0; i < 100; i++) {
            for (ASocket socket : sockets) {
                for (int j = 0; j < 10; j++) socket.tick();
            }
        }
    }

    @Test
    public void test1() {

        ASocket server = new ASocket(8000, socket -> {
            socket.send("server accepted connection");
            socket.onData = data -> {
                log("server received: " + data);
            };
        });

        ASocket client1 = new ASocket("localhost", 8000, socket -> {
            socket.send("hello to server from client1");
            log("client1 connected");
            socket.onData = data -> {
                log("client1 received: " + data);
            };
        });

        ASocket client2 = new ASocket("localhost", 8000, socket -> {
            socket.send("hello to server from client2");
            log("client2 connected");
            socket.onData = data -> {
                log("client2 received: " + data);
            };
        });

        tickAll(server, client1, client2);

        client1.clientSocket.send("hello1");
        client2.clientSocket.send("hello2");
        client2.clientSocket.send("hello3");
        client2.clientSocket.send("hello4");
        client2.clientSocket.send("hello5");
        client2.clientSocket.send("hello6");
        client2.clientSocket.send("hello7");

        tickAll(server, client1, client2);
        server.close();
        client1.close();
        client2.close();

        assertEquals(al(
                "client1 connected",
                "client1 received: server accepted connection",
                "client2 connected",
                "client2 received: server accepted connection",
                "server received: hello to server from client2",
                "server received: hello to server from client1",
                "server received: hello2",
                "server received: hello3",
                "server received: hello4",
                "server received: hello5",
                "server received: hello6",
                "server received: hello7",
                "server received: hello1"), logs);
    }


    @Test
    public void testDisconnect() {

        ASocket server = new ASocket(8000, socket -> {
            socket.send("server accepted connection");
            socket.onData = data -> {
                log("server received: " + data);
            };
            socket.onDisconnect = () -> log("disconnected from server");
        });

        ASocket client1 = new ASocket("localhost", 8000, socket -> {
            socket.send("hello to server from client1");
            log("client1 connected");
            socket.onData = data -> {
                log("client1 received: " + data);
            };
        });

        tickAll(server, client1);
        client1.clientSocket.send("hello1");
        tickAll(server, client1);
        client1.close();
        tickAll(server, client1);

        ASocket client2 = new ASocket("localhost", 8000, socket -> {
            socket.send("hello to server from client2");
            log("client2 connected");
            socket.onData = data -> {
                log("client2 received: " + data);
            };
        });

        tickAll(server, client1, client2);
        client2.clientSocket.send("hello2");
        tickAll(server, client1, client2);
        client2.clientSocket.outBytes.add(new byte[]{1, 2, 3, 4, 5});
        tickAll(server, client1, client2);

        server.close();
        client1.close();
        client2.close();

        assertEquals(al(
                "client1 connected",
                "client1 received: server accepted connection",
                "server received: hello to server from client1",
                "server received: hello1",
                "disconnected from server",
                "client2 connected",
                "client2 received: server accepted connection",
                "server received: hello to server from client2",
                "server received: hello2",
                "disconnected from server"

        ), logs);


    }


}
