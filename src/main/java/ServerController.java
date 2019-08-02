import java.io.*;
import java.net.Socket;
class ServerController {
    void startServer(Server server){
        while (server.getClientsConnected() <= server.getMaxConnections()) {
            ServerLogger.infoLog("Server "+server.getServerNumber()+" listening...");
            Socket clientSocket = null;
            try {
                clientSocket = server.getSocket().accept();
            } catch (IOException e) {
                ServerLogger.warningLog("Client Connection error");
                e.printStackTrace();
            }
            Connection connection = new Connection(server, clientSocket);
            connection.start();
        }
    }
}