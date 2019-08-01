import java.net.ServerSocket;
class Server {
    private int maxConnections;
    private String rootDirectory;
    private ServerSocket socket;
    private int clientsConnected;
    Server(int maxConnections, String rootDirectory, ServerSocket socket) {
        this.maxConnections = maxConnections;
        this.rootDirectory = rootDirectory;
        this.socket = socket;
        this.clientsConnected = 0;
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
}