import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerMessageReceiver extends Thread {
    private BufferedReader dataIn;
    public ServerMessageReceiver(BufferedReader dataIn) {
        this.dataIn = dataIn;
    }
    @Override
    public void run() {
        try {
            char[] buffer = new char[256];
            dataIn.read(buffer);
            String message = new String(buffer);
            System.out.println(message);
            String delims = " ";
            String requestType = message.split(" ")[0];
            String filename = message.split(" ")[1];
            if(requestType.equals("GET")){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}