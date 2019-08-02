import java.io.*;
import java.net.Socket;
class ServerController {
    void startServer(Server server) throws IOException {
        while (server.getClientsConnected() <= server.getMaxConnections()) {
            System.out.println("Server "+server.getServerNumber()+" listening...");
            Socket clientSocket = null;
            try {
                clientSocket = server.getSocket().accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Connection connection = new Connection(server, clientSocket);
            connection.start();
        }
    }
}