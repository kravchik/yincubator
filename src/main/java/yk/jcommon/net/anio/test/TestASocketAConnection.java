package yk.jcommon.net.anio.test;

import org.junit.Before;
import org.junit.Test;
import yk.jcommon.collections.YList;
import yk.jcommon.net.anio.AConnection;
import yk.jcommon.net.anio.ASocket;
import yk.jcommon.net.anio.OnConnection;
import yk.jcommon.net.anio.OnData;

import static org.junit.Assert.assertEquals;
import static yk.jcommon.collections.YArrayList.al;

/**
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 12/12/13
 * Time: 10:10 PM
 */
public class TestASocketAConnection {

    private static YList<String> logs;

    private static void log(String s) {
        logs.add(s);
        System.out.println(s);
    }

    @Before
    public void setUp() {
        logs = al();

    }

    private static void tickAll(ASocket... sockets) {
        for (int i = 0; i < 10; i++) {
            for (ASocket socket : sockets) {
                for (int j = 0; j < 10; j++) socket.tick();
            }
        }
    }

    @Test
    public void testtt() {
        ASocket client = ASocket.newClient("google.com", 80, new OnConnection() {
            @Override
            public void call(AConnection connection) {
                System.out.println("conencted");
                connection.onData = data -> System.out.println(data);
            }
        });

        while(true) {
            client.tick();
        }
    }

    @Test
    public void test1() {

        ASocket server = ASocket.newServer(8000, conn -> {
            conn.send("server sends hello to a client");
            conn.onData = data -> {
                log("server | received: " + data);
                conn.send("server sends answer to '" + data + "'");
            };
        });

        ASocket client1 = ASocket.newClient("localhost", 8000, conn -> {
            conn.send("client1 sends hello to server from client1");
            log("client1| connected");
            conn.onData = data -> log("client1| received: " + data);
        });

        tickAll(server, client1);
        ASocket client2 = ASocket.newClient("localhost", 8000, conn -> {
            conn.send("client2 sends hello to server from client2");
            log("client2| connected");
            conn.onData = data -> log("client2| received: " + data);
        });
        tickAll(server, client1, client2);


        client1.send("hello 1 from client 1");
        tickAll(server, client1, client2);
        client2.send("hello 1 from client 2");
        client2.send("hello 2 from client 2");
        client2.send("hello 3 from client 2");
        client2.send("hello 4 from client 2");
        client2.send("hello 5 from client 2");
        client2.send("hello 6 from client 2");

        tickAll(server, client1, client2);
        server.close();
        client1.close();
        client2.close();

        assertEquals(
                "client1| connected\n" +
                        "client1| received: server sends hello to a client\n" +
                        "server | received: client1 sends hello to server from client1\n" +
                        "client1| received: server sends answer to 'client1 sends hello to server from client1'\n" +
                        "client2| connected\n" +
                        "client2| received: server sends hello to a client\n" +
                        "server | received: client2 sends hello to server from client2\n" +
                        "client2| received: server sends answer to 'client2 sends hello to server from client2'\n" +
                        "server | received: hello 1 from client 1\n" +
                        "client1| received: server sends answer to 'hello 1 from client 1'\n" +
                        "server | received: hello 1 from client 2\n" +
                        "server | received: hello 2 from client 2\n" +
                        "server | received: hello 3 from client 2\n" +
                        "server | received: hello 4 from client 2\n" +
                        "server | received: hello 5 from client 2\n" +
                        "server | received: hello 6 from client 2\n" +
                        "client2| received: server sends answer to 'hello 1 from client 2'\n" +
                        "client2| received: server sends answer to 'hello 2 from client 2'\n" +
                        "client2| received: server sends answer to 'hello 3 from client 2'\n" +
                        "client2| received: server sends answer to 'hello 4 from client 2'\n" +
                        "client2| received: server sends answer to 'hello 5 from client 2'\n" +
                        "client2| received: server sends answer to 'hello 6 from client 2'"
                , logs.toString("\n"));
    }


    @Test
    public void testDisconnect() {

        ASocket server = ASocket.newServer(8000, socket -> {
            socket.send("server accepted connection");
            socket.onData = data -> {
                log("server received: " + data);
            };
            socket.onDisconnect = () -> log("disconnected from server");
        });

        ASocket client1 = ASocket.newClient("localhost", 8000, socket -> {
            socket.send("hello to server from client1");
            log("client1 connected");
            socket.onData = data -> {
                log("client1 received: " + data);
            };
        });

        tickAll(server, client1);
        client1.send("hello1");
        tickAll(server, client1);
        client1.close();
        tickAll(server, client1);

        ASocket client2 = ASocket.newClient("localhost", 8000, socket -> {
            socket.send("hello to server from client2");
            log("client2 connected");
            socket.onData = data -> {
                log("client2 received: " + data);
            };
        });

        tickAll(server, client1, client2);
        client2.send("hello2");
        tickAll(server, client1, client2);

        server.close();
        client1.close();
        client2.close();
        tickAll(server, client1, client2);

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

        ).toString("\n"), logs.toString("\n"));


    }


}
