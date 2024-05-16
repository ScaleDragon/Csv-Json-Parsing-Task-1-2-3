import java.io.FileWriter;
import java.io.IOException;

import static com.sun.management.HotSpotDiagnosticMXBean.ThreadDumpFormat.JSON;

public class WriteString {
    public static void writeString(String fileJson, String nameSaves) {
        try (FileWriter file = new FileWriter(nameSaves + ".json")) {
            file.write(fileJson);
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
