import java.net.HttpURLConnection;
import java.net.URL;

public class RequestSender {
    // Send Request
    public static String SendGetRequest(String searchQuery) throws Exception
    {
//        String encodedTitle = URLEncoder.encode(searchQuery, "UTF-8");
        String urlString = WikipediaRequestApi.API_URL + searchQuery;
        System.out.println(urlString);
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        try {
            return ResponseGetter.getResponse(connection);
        } finally {
            connection.disconnect();
        }
    }
}
