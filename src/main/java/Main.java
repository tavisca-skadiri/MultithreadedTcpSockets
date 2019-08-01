import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args){
        try {
            Server server = new Server(10, "www", new ServerSocket(80));
            ServerController serverController = new ServerController();
            serverController.startServer(server);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
