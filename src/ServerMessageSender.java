import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.file.Files;

public class ServerMessageSender extends Thread {
    private PrintWriter dataOut;
    File file;
    public ServerMessageSender(PrintWriter dataOut, String filename) {
        this.dataOut = dataOut;
        if(filename.isEmpty()){
            file = new File("error.html");
        }
        else {
            file = new File(filename);
        }
        if(!file.exists()){
            file = new File("error.html");
        }
    }
    @Override
    public void run() {
        try {
            InputStream inputStreamReader = new FileInputStream(file.getName());
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