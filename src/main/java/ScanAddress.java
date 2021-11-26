import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScanAddress {
    private static final String csv = "CSV";
    private static final String xml = "XML";

    public boolean isFile(String entryStr) {
        Path filePath = Paths.get(entryStr);

        if (Files.exists(filePath)) {
            System.out.println("Найден файл: " + filePath.getFileName());
            return true;
        } else {
            System.out.println("Файл не найден");
        }
        return false;
    }

    public boolean isCSV(String entryStr) {
        Path filePath = Paths.get(entryStr);
        File file = new File(filePath.toString());
        if (csv.equalsIgnoreCase(getFileExtension(file))) {
            System.out.println("Расширение файла: " + getFileExtension(file));
            return true;
        }
        return false;
    }

    public boolean isXML(String entryStr) {
        Path filePath = Paths.get(entryStr);
        File file = new File(filePath.toString());
        if (xml.equalsIgnoreCase(getFileExtension(file))) {
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
