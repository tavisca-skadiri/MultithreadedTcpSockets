import models.RequestHeaderData;
import org.junit.Test;
import request.RequestParser;

import java.io.*;
import static org.junit.Assert.assertEquals;
public class RequestTests {
    @Test
    public void methodNameOnARequest(){
        String request = "GET / /http/1.1";
        RequestHeaderData header = new RequestHeaderData(request);
        assertEquals("GET", header.getHttpMethod());
    }
    @Test
    public void httpVersionOnARequest(){
        String request = "GET / /http/1.1";
        RequestHeaderData header = new RequestHeaderData(request);
        assertEquals("/http/1.1", header.getHttpVersion());
    }
    @Test
    public void resourceNameOnARequest(){
        String request = "GET / /http/1.1";
        RequestHeaderData header = new RequestHeaderData(request);
        assertEquals("/", header.getResourceName());
    }
    @Test
    public void requestHeaderParser() throws IOException {
        String request = "GET /index.html /http/1.1 ";
        BufferedReader dataIn = new BufferedReader(new StringReader(request));
        RequestHeaderData requestHeaderData = RequestParser.parseRequest(dataIn);
        assertEquals(new RequestHeaderData(request).toString(), requestHeaderData.toString());
    }
}