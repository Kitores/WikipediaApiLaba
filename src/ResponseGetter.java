import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class ResponseGetter {
    static int responseCode;
    static BufferedReader reader;
    static StringBuilder responseContent;
    static String inputLine;

    public static String getResponse(HttpURLConnection connection) throws Exception{
            responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            responseContent = new StringBuilder();

            while ((inputLine = reader.readLine()) != null) {
                responseContent.append(inputLine);
            }
            reader.close();
            return responseContent.toString();
        } else {
            throw new RuntimeException("Ошибка: " + responseCode);
        }
    }
}
