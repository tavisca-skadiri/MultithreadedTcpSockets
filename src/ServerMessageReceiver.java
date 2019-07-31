import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.Callable;

public class ServerMessageReceiver implements Callable<String> {
    private BufferedReader dataIn;
    public ServerMessageReceiver(BufferedReader dataIn) {
        this.dataIn = dataIn;
    }
    @Override
    public String call() {
        String filename = null;
        try {
            char[] buffer = new char[256];
            dataIn.read(buffer);
            String message = new String(buffer);
            System.out.println(message);
            String delims = " ";
            String requestType = message.split(" ")[0];
            if(requestType.equals("GET")){
                filename = message.split(" ")[1].substring(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }
}