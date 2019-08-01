import java.io.BufferedReader;
import java.io.IOException;
class RequestHandler {
    private BufferedReader dataIn;
    RequestHandler(BufferedReader dataIn) {
        this.dataIn = dataIn;
    }
    String getResourceRequest() throws IOException {
        String filename = null;
        char[] buffer = new char[256];
        dataIn.read(buffer);
        String request = new String(buffer);
        System.out.println(request);
        if(!request.isEmpty()){
            String requestMethod = request.split(" ")[0];
            if(requestMethod.equals("GET"))
                filename = request.split(" ")[1];
        }
        return filename;
    }
}