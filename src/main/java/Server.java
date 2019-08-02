import java.net.ServerSocket;
class Server {
    private int maxConnections;
    private String rootDirectory;
    private ServerSocket socket;
    private int clientsConnected;
    private int serverNumber;
    Server(int maxConnections, String rootDirectory, ServerSocket socket, int serverNumber) {
        this.maxConnections = maxConnections;
        this.rootDirectory = rootDirectory;
        this.socket = socket;
        this.clientsConnected = 0;
        this.serverNumber=serverNumber;
    }
    int getMaxConnections() {
        return maxConnections;
    }
    String getRootDirectory() {
        return rootDirectory;
    }
    ServerSocket getSocket() {
        return socket;
    }
    int getClientsConnected() {
        return clientsConnected;
    }
    void incrementConnectedClientsCount() {
        System.out.println("Client No." + ++clientsConnected + " connected...\n");
    }
    public int getServerNumber() {
        return serverNumber;
    }
}