import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.file.Files;

public class ServerMessageSender extends Thread {
    private PrintWriter dataOut;
    public ServerMessageSender(PrintWriter dataOut) {
        this.dataOut = dataOut;
    }
    @Override
    public void run() {
        String filename="index.html";
        try {
            InputStream inputStreamReader = new FileInputStream(filename);
            byte[] b=new byte[inputStreamReader.available()];
            inputStreamReader.read(b);
            dataOut.print(new String(b));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataOut.flush();
        dataOut.close();
    }
}