import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScanAddress {
    public void scanAddress(String entry_str) {
        try {
            Path filePath = Paths.get(entry_str);

            System.out.println("File name: " + filePath.getFileName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
