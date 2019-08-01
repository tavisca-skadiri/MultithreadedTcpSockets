import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;
class ServerController {
    void startServer() {
        try {
            Server server = new Server(10, "www", new ServerSocket(80));
            while (server.getClientsConnected() <= server.getMaxConnections()) {
                System.out.println("Server listening...");
                Socket clientSocket = server.getSocket().accept();
                Connection connection = new Connection(server, clientSocket);
                server.incrementConnectedClientsCount();
                connection.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}