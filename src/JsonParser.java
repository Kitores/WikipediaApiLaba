import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JsonParser {
    public static int[] parse(String jsonData) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);

        var SearchResults = jsonObject.getAsJsonObject("query").getAsJsonArray("search");

        int k = 0;
        int[] pageIdArray;
        pageIdArray = new int[100];

        for (var result : SearchResults) {
            String title = result.getAsJsonObject().get("title").getAsString();
            int pageId = result.getAsJsonObject().get("pageid").getAsInt();

            pageIdArray[k] = pageId;
            k++;

            String ResponseUrl = WikipediaRequestApi.RESP_URL + pageId;

            System.out.println("Title: " + title + " " + k);
            System.out.println("Response URL: " + ResponseUrl);
        }
        return pageIdArray;
    }
}
