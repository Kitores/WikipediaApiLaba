import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class ResponseGetter {
    public static String getResponse(HttpURLConnection connection) throws Exception{
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
}
