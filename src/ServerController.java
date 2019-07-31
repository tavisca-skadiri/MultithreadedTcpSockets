import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ServerController {
    public static void main(String[] args) {
        try {
            int count=1;
            ServerSocket connectionAccepter = new ServerSocket(80);
            ExecutorService service = Executors.newFixedThreadPool(2);
            while(true) {
                System.out.println("Server listening...");
                Socket server = connectionAccepter.accept();
                System.out.println("Client No." + count + " connected...");
                System.out.println();
                count += 1;
                PrintWriter dataOut = new PrintWriter(server.getOutputStream());
                BufferedReader dataIn = new BufferedReader(new InputStreamReader(server.getInputStream()));
                Future<String> f1 = service.submit(new ServerMessageReceiver(dataIn));
                ServerMessageSender myServerMessageSender = new ServerMessageSender(dataOut,f1.get());
                myServerMessageSender.start();
            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}