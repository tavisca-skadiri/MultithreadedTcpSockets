package response;

import logs.ServerLogger;
import models.Server;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResponseGenerator {
    public String fileResponse(File resourceFile) throws IOException {
        return "HTTP/1.1 200 OK\r\n" + getCommonResponse(resourceFile);
    }
    public String method404(File resourceFile) throws IOException {
        return "HTTP/1.1 404\r\n" + getCommonResponse(resourceFile);
    }
    public String getCommonResponse(File fileToSend) throws IOException {
        Pattern pattern = Pattern.compile("(.*).jpeg|(.*).png|(.*).jpg|(.*).jfif", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(fileToSend.getName());
        String response = "Server: My Java HTTP Server: 1.0\r\n";
        response += "Date: " + (new Date()).toString() + "\r\n";
        if(matcher.find()){
            BufferedImage bImage = ImageIO.read(new File(fileToSend.getAbsolutePath()));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpeg", bos );
            byte [] data = bos.toByteArray();
            String encodedfile = new String(Base64.getEncoder().encode(data));
            String htmlResponse = "<img src=\"data:image/jpeg;base64," + encodedfile + "\" alt=\"" + fileToSend.getName()+"\">";
            response += "Content-Type: text/html\r\n";
            response += "Content-length: " +htmlResponse.length() +"\r\n";
            response += "\r\n";
            response += htmlResponse;
        }
        else {
            response += "Content-Type: text/html\r\n";
            response += "Content-length: " + String.join("", Files.readAllLines(fileToSend.toPath())).length() + "\r\n";
            response += "\r\n";
            response += String.join("", Files.readAllLines(fileToSend.toPath()));
        }
        return response;
    }
}