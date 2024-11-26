import java.io.IOException;
import java.util.Scanner;

public class ConsoleReader {
    // Read from console
    public static String ReadConsole() throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(WikipediaRequestApi.API_URL);
        String userInput = scanner.nextLine();
        stringBuilder.append(userInput);
        return String.valueOf(stringBuilder);
    }
}
