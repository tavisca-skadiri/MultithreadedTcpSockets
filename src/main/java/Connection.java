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
    }
    @Override
    public void run() {
        try {
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            RequestHandler requestHandler = new RequestHandler(dataIn);
            String request = requestHandler.getResourceRequest();
            PrintWriter dataOut = new PrintWriter(clientSocket.getOutputStream());

            ResponseHandler responseHandler = new ResponseHandler(dataOut,server.getRootDirectory()+request);
            responseHandler.sendResponse();
        }catch (Exception e) {
            System.out.println(e.getMessage()+"inConnection");
        }
    }
}