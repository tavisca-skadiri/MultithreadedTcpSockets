import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
class ResponseSender {
    private final PrintWriter dataOut;
    private File file;
    ResponseSender(PrintWriter dataOut, String filename) {
        this.dataOut = dataOut;
        this.file = new File(filename);
    }
    void sendResponse() throws IOException {
        String fileContent = getResourceContent();
        dataOut.print(fileContent);
        dataOut.flush();
        dataOut.close();
    }
    String getResourceContent() throws IOException {
        ResponseGenerator responseGenerator = new ResponseGenerator();
        String resourceContent;
        if(file.isDirectory())
            resourceContent = responseGenerator.fileResponse(new File(file.getName()+"/index.html"));
        else if (file.exists())
            resourceContent = responseGenerator.fileResponse(file);
        else
            resourceContent = responseGenerator.method404(new File(file.getParent()+"/error.html"));
        return resourceContent;
    }
}