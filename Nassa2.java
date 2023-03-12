import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Nassa2 {

    public static void main(String[] args) throws IOException {

        String url = "https://api.nasa.gov/planetary/apod?api_key=qAc00mSFmryhM3QNpXB2NpZBrW14FjpSHH8SCYmc";
        String page = downloadWebPage(url);
        int begin = page.lastIndexOf("url");
        int end = page.lastIndexOf("}");
        String str = page.substring(begin + 6, end - 1);
        try (InputStream in = new URL(str).openStream()) {
            File file = new File("file");
            Files.copy(in, Paths.get("image3.jpg"));

        }
    }

    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;

        URLConnection urlConnection = new URL(url).openConnection();


        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        }

        return result.toString();

    }
}







