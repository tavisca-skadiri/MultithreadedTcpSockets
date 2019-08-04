import models.RequestHeaderData;
import models.Server;
import request.RequestParser;
import response.ResponseSender;
import logs.ServerLogger;

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
            RequestHeaderData requestHeader = RequestParser.parseRequest(dataIn);

            String resourceName = server.getRootDirectory() + requestHeader.getResourceName();
            ServerLogger.infoDisplay("ResourceName: "+resourceName);

            PrintWriter dataOut = new PrintWriter(clientSocket.getOutputStream());
            new ResponseSender(dataOut,resourceName).sendResponse();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}