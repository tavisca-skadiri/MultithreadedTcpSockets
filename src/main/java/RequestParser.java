import java.io.BufferedReader;
import java.io.IOException;
class RequestParser {
    private BufferedReader dataIn;
    RequestParser(BufferedReader dataIn) {
        this.dataIn = dataIn;
    }
    RequestHeaderData parseRequest() throws IOException {
        char[] buffer = new char[256];
        dataIn.read(buffer);
        return new RequestHeaderData(new String(buffer));
    }
}