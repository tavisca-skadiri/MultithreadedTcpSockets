import org.junit.Test;
import response.ResponseGenerator;
import response.ResponseSender;

import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertTrue;
public class ResponseGeneratorTests {
    @Test
    public void response200Test() throws IOException {
        ResponseGenerator responseGenerator = new ResponseGenerator();
        String response = responseGenerator.fileResponse(new File("www/hello.html"));
        String expectedResponse="HTTP/1.1 200 OK";
        assertTrue(response.contains(expectedResponse));
    }
    @Test
    public void response404Test() throws IOException {
        ResponseGenerator responseGenerator = new ResponseGenerator();
        String response = responseGenerator.method404(new File("www/error.html"));
        String expectedResponse="HTTP/1.1 404";
        assertTrue(response.contains(expectedResponse));
    }
    @Test
    public void resourceExistsTest() throws IOException {
        ResponseSender responseSender = new ResponseSender(null, "www/index.html");
        String response = responseSender.getResourceContent();
        String expectedResponse="HTTP/1.1 200 OK";
        assertTrue(response.contains(expectedResponse));
    }
    @Test
    public void resourceNotExistsTest() throws IOException {
        ResponseSender responseSender = new ResponseSender(null, "www/indo.html");
        String response = responseSender.getResourceContent();
        String expectedResponse="HTTP/1.1 404";
        assertTrue(response.contains(expectedResponse));
    }
    @Test
    public void rootResponseTest() throws IOException {
        ResponseSender responseSender = new ResponseSender(null, "www");
        String response = responseSender.getResourceContent();
        String expectedResponse="HTTP/1.1 200 OK";
        assertTrue(response.contains(expectedResponse));
    }
    @Test
    public void rootResponseTest2() throws IOException {
        ResponseSender responseSender = new ResponseSender(null, "www/");
        String response = responseSender.getResourceContent();
        String expectedResponse="HTTP/1.1 200 OK";
        assertTrue(response.contains(expectedResponse));
    }
}