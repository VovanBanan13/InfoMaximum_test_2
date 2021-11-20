import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRun  = true;
        String entry_str = "";
        Scanner console = new Scanner(System.in);
        System.out.println("\n Начало работы парсера");

        while (isRun) {
            System.out.println("Чтобы выйти из приложения, введите 'exit'");
            System.out.println("Чтобы пропарсить файл, введите его путь");
            System.out.print("Ввод: ");
            entry_str = console.nextLine();

            if (entry_str.equals("exit")){
                isRun = false;
                System.out.println("\n Конец работы парсера");
            }
        }
    }
}
