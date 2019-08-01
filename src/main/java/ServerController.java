import java.io.*;
import java.net.Socket;
class ServerController {
    void startServer(Server server) throws IOException {
        while (server.getClientsConnected() <= server.getMaxConnections()) {
            System.out.println("Server listening...");
            Socket clientSocket = server.getSocket().accept();
            Connection connection = new Connection(server, clientSocket);
            connection.start();
        }
    }
}