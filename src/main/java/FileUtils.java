import java.io.*;

class FileUtils {
    static String readFile(File file) throws IOException {
        if(!file.exists())
            file = new File(file.getParent()+"/error.html");
        else if(!file.getName().endsWith(".html"))
            file = new File(file.getName()+"/index.html");
        System.out.println(file.getAbsolutePath());
        InputStream inputStreamReader = new FileInputStream(file.getAbsolutePath());
        byte[] b = inputStreamReader.readAllBytes();
        return new String(b);
    }
}
