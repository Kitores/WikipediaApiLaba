import java.awt.*;
import java.net.URI;
import java.util.Scanner;

public class Browser {
    public static void Browse(int[] pageIdArr) {
        try (Scanner scanner = new Scanner(System.in)) {
            int NumOfPageId = scanner.nextInt();
            URI uri = new URI(WikipediaRequestApi.RESP_URL + pageIdArr[NumOfPageId - 1]);
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(uri);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
