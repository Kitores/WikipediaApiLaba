import java.awt.*;
import java.net.URI;
import java.util.Scanner;

public class Browser {
    static int NumOfPageId;
    static URI uri;
    static Desktop desktop;

    public static void Browse(int[] pageIdArr) {
        try (Scanner scanner = new Scanner(System.in)) {
            NumOfPageId = scanner.nextInt();
            uri = new URI(WikipediaRequestApi.RESP_URL + pageIdArr[NumOfPageId - 1]);
            desktop = Desktop.getDesktop();
            desktop.browse(uri);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
