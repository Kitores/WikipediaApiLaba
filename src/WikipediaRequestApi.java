
public class WikipediaRequestApi {
    public static final String RESP_URL = "https://ru.wikipedia.org/w/index.php?curid=";
    public static final String API_URL = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=";

    static String search;
    static String response;
    static int[] pageIdArr;

    public static void main(String[] args) {
        try{
            System.out.println("Введите слово для поиска");
            search = ConsoleReader.ReadConsole();
            response = RequestSender.SendGetRequest(search);
            pageIdArr = JsonParser.parse(response);
            Browser.Browse(pageIdArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}