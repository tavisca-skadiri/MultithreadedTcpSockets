package models;

import java.net.ServerSocket;
public class Server {
    private int maxConnections;
    private String rootDirectory;
    private ServerSocket socket;
    private static int clientsConnected = 0;
    private int serverNumber;
    public Server(int maxConnections, String rootDirectory, ServerSocket socket, int serverNumber) {
        this.maxConnections = maxConnections;
        this.rootDirectory = rootDirectory;
        this.socket = socket;
        this.serverNumber=serverNumber;
    }
    public int getMaxConnections() {
        return maxConnections;
    }
    public String getRootDirectory() {
        return rootDirectory;
    }
    public ServerSocket getSocket() {
        return socket;
    }
    public int getClientsConnected() {
        return clientsConnected;
    }
    public int getServerNumber() {
        return serverNumber;
    }
    public void incrementConnectedClientsCount() {
        System.out.println("Client No." + ++clientsConnected + " connected...\n");
    }
}