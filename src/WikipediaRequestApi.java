import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.BufferedReader;
import java.net.URLEncoder;
import java.io.IOException;
import java.net.HttpURLConnection;

import com.google.gson.*;

import java.util.List;

class Translation {
    String translatedText;
}

class Data {
    List<Translation> translations;
}

class ApiResponse {
    Data data;
}

public class WikipediaRequestApi {
//    private static final String API_URL = "https://ru.wikipedia.org/w/api.php";
    private static final String RESP_URL = "https://ru.wikipedia.org/w/index.php?curid=";
    private static final String API_URL = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=";
    public static void main(String[] args) {
        try{
            String search = ReadConsole();
            String response = SendGetRequest(search);
            parse(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void Print(String arr) {
        System.out.println(arr);
    }
    // Read from console
    private static String ReadConsole() throws IOException{
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(API_URL);
        String userInput = scanner.nextLine();
        stringBuilder.append(userInput);
        scanner.close();
        return String.valueOf(stringBuilder);
    }
    // Send Request
    private static String SendGetRequest(String searchQuery) throws Exception
    {
//        String encodedTitle = URLEncoder.encode(searchQuery, "UTF-8");
        String urlString = API_URL + searchQuery;
        System.out.println(urlString);
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        try {
            return getResponse(connection);
        } finally {
            connection.disconnect();
        }
    }
    private static String getResponse(HttpURLConnection connection) throws Exception{
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseContent = new StringBuilder();
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                responseContent.append(inputLine);
            }
            reader.close();
            return responseContent.toString();
        } else {
        throw new RuntimeException("Ошибка: " + responseCode);
        }
    }

    public static void parse(String jsonData) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);

        var SearchResults = jsonObject.getAsJsonObject("query").getAsJsonArray("search");

        for (var result : SearchResults) {
            String title = result.getAsJsonObject().get("title").getAsString();
            int pageId = result.getAsJsonObject().get("pageid").getAsInt();
            String ResponseUrl = RESP_URL + pageId;

            System.out.println("Title: " + title);
            System.out.println("Response URL: " + ResponseUrl);
        }
    }
}