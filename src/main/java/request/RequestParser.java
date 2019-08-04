package request;

import models.RequestHeaderData;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestParser {
    public static RequestHeaderData parseRequest(BufferedReader dataIn) throws IOException {
        char[] buffer = new char[256];
        dataIn.read(buffer);
        return new RequestHeaderData(new String(buffer));
    }
}