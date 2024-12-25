import java.net.HttpURLConnection;
import java.net.URL;

public class RequestSender {
    static String urlString;
    static URL url;
    static HttpURLConnection connection;

    // Send Request
    public static String SendGetRequest(String searchQuery) throws Exception
    {
        urlString = WikipediaRequestApi.API_URL + searchQuery;
        System.out.println(urlString);
        url = new URL(urlString);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        try {
            return ResponseGetter.getResponse(connection);
        } finally {
            connection.disconnect();
        }
    }
}
