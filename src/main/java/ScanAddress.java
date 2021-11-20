import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScanAddress {
    public boolean scanAddress(String entry_str) {
        try {
            Path filePath = Paths.get(entry_str);

            if (Files.exists(filePath)) {
                System.out.println("Найден файл: " + filePath.getFileName());
                return true;
            } else {
                System.out.println("Файл не найден");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
