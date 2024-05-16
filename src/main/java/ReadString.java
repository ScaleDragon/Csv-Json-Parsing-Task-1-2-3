import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadString {
    private static JsonElement JsonArray;

    public static String readString(String fileJson) {
        String file;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileJson))) {
            while ((file = reader.readLine()) != null) {
                return file;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
