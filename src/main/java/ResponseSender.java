import java.io.File;
import java.io.PrintWriter;
class ResponseSender {
    private final PrintWriter dataOut;
    private File file;
    ResponseSender(PrintWriter dataOut, String filename) {
        this.dataOut = dataOut;
        this.file = new File(filename);
    }
    void sendResponse() {
        ResponseGenerator responseGenerator = new ResponseGenerator();
        String fileContent;
        if (file.exists())
            fileContent = responseGenerator.fileResponse(file);
        else
            fileContent = responseGenerator.method404(new File(file.getParent()+"/error.html"));
        dataOut.print(fileContent);
        dataOut.flush();
        dataOut.close();
    }
}