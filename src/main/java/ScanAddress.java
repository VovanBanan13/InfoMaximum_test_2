import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScanAddress {
    public boolean isFile(String entry_str) {
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

    public boolean isCSV(String entry_str) {
        Path filePath = Paths.get(entry_str);
        File file = new File(String.valueOf(filePath));
        if (getFileExtension(file).equalsIgnoreCase("CSV")) {
            System.out.println("Расширение файла: " + getFileExtension(file));
            return true;
        }
        return false;
    }

    public boolean isXML(String entry_str) {
        Path filePath = Paths.get(entry_str);
        File file = new File(String.valueOf(filePath));
        if (getFileExtension(file).equalsIgnoreCase("XML")) {
            System.out.println("Расширение файла: " + getFileExtension(file));
            return true;
        }
        return false;
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
