import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class Connection extends Thread {
    private Server server;
    private Socket clientSocket;
    Connection(Server server,Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
        this.server.incrementConnectedClientsCount();
    }
    @Override
    public void run() {
        try {
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            RequestParser requestParser = new RequestParser(dataIn);
            RequestHeaderData requestHeader = requestParser.parseRequest();

            String resourceName = requestHeader.getResourceName();

            PrintWriter dataOut = new PrintWriter(clientSocket.getOutputStream());
            ResponseSender responseSender = new ResponseSender(dataOut,server.getRootDirectory()+resourceName);
            responseSender.sendResponse();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}