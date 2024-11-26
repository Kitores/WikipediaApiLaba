
public class WikipediaRequestApi {
    public static final String RESP_URL = "https://ru.wikipedia.org/w/index.php?curid=";
    public static final String API_URL = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=";
    public static void main(String[] args) {
        try{
            String search = ConsoleReader.ReadConsole();
            String response = RequestSender.SendGetRequest(search);
            int[] pageIdArr = JsonParser.parse(response);
            Browser.Browse(pageIdArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}