
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

class ServerController {
    private Server server;
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        ServerController serverController = new ServerController();
        serverController.startServer();
    }
    private void startServer() throws InterruptedException, ExecutionException, IOException {
        server = new Server(10,"www",new ServerSocket(80));
        while(server.getClientsConnected() <= server.getMaxConnections()) {
            Socket clientSocket = connectClient();
            String filename = getFilename(clientSocket);
            sendResponse(clientSocket, server.getRootDirectory()+filename);
        }
    }
    private Socket connectClient() throws IOException {
        System.out.println("Server listening...");
        Socket clientSocket = server.getSocket().accept();
        server.incrementConnectedClientsCount();
        return clientSocket;
    }
    private void sendResponse(Socket clientSocket, String filename) throws IOException {
        PrintWriter dataOut = new PrintWriter(clientSocket.getOutputStream());
        new ResponseHandler(dataOut,filename).start();
    }
    private String getFilename(Socket clientSocket) throws IOException, ExecutionException, InterruptedException {
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        RequestHandler requestHandler = new RequestHandler(dataIn);
        return requestHandler.getResourceRequest();
    }
    private void stopServer(){
        try {
            server.getSocket().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}