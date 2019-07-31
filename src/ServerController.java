import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {
    public static void main(String[] args) {
        try {
            int count=1;
            ServerSocket connectionAccepter = new ServerSocket(80);
            while(true) {
                System.out.println("Server listening...");
                Socket server = connectionAccepter.accept();
                System.out.println("Client No." + count + " connected...");
                System.out.println();
                count += 1;
                PrintWriter dataOut = new PrintWriter(server.getOutputStream());
                BufferedReader dataIn = new BufferedReader(new InputStreamReader(server.getInputStream()));
                ServerMessageSender myServerMessageSender = new ServerMessageSender(dataOut);
                ServerMessageReceiver myServerMessageReceiver = new ServerMessageReceiver(dataIn);
                myServerMessageSender.start();
                myServerMessageReceiver.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}