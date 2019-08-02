import java.io.IOException;
import java.net.ServerSocket;
public class Main {
    public static void main(String[] args){
        int count=1;
        startServerThread("html", 5000, count++);
        startServerThread("www", 80, count++);
    }
    private static void startServerThread(String rootDirectory, int port, int serverNumber) {
        ServerController serverController = new ServerController();
        new Thread(() -> {
            try {
                Server server = new Server(10, rootDirectory, new ServerSocket(port),serverNumber);
                serverController.startServer(server);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
