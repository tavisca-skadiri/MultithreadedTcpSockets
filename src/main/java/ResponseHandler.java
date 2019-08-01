import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
public class ResponseHandler{
    private final PrintWriter dataOut;
    private File file;
    ResponseHandler(PrintWriter dataOut, String filename) {
        this.dataOut = dataOut;
        this.file = new File(filename);
    }
    void sendResponse() {
        try(dataOut) {
            String fileContent = FileUtils.readFile(file);
            dataOut.print(fileContent);
            dataOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}