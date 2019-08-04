import logs.ServerLogger;
import models.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args){
        startServerThread("html", 5000, 1);
        startServerThread("www", 80, 2);
    }
    private static void startServerThread(String rootDirectory, int port, int serverNumber) {
        new Thread(() -> {
            try {
                Server server = new Server(10, rootDirectory, new ServerSocket(port),serverNumber);
                while (server.getClientsConnected() <= server.getMaxConnections()) {
                    ServerLogger.infoDisplay("Server "+server.getServerNumber()+" listening...");
                    try {
                        Socket clientSocket = server.getSocket().accept();
                        new Connection(server, clientSocket).start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
