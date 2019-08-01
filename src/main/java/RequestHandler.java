
import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
class RequestHandler {
    private BufferedReader dataIn;
    RequestHandler(BufferedReader dataIn) {
        this.dataIn = dataIn;
    }
    String getResourceRequest() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(this::getFilename);
        return future.get();
    }
    private String getFilename() throws IOException {
        String filename = null;
        String request = readRequest();
        System.out.println(request);
        if(!request.isEmpty()){
            String requestMethod = request.split(" ")[0];
            if(requestMethod.equals("GET"))
                filename = request.split(" ")[1];
        }
        return filename;
    }
    private String readRequest() throws IOException {
        char[] buffer = new char[256];
        dataIn.read(buffer);
        return new String(buffer);
    }
}