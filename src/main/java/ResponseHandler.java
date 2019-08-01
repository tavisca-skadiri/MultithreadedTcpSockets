
import java.io.*;

public class ResponseHandler extends Thread {
    private final PrintWriter dataOut;
    private File file;
    ResponseHandler(PrintWriter dataOut, String filename) {
        this.dataOut = dataOut;
        this.file = new File(filename);
    }
    @Override
    public void run() {
        try(dataOut) {
            String fileContent = FileUtils.readFile(file);
            dataOut.print(fileContent);
            dataOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}