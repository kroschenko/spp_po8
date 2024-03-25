import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Выдача перекрестных ссылок");
            System.out.println("2. Утилита head");
            System.out.println("3. Выход из программы");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    crossReferences(scanner);
                    break;
                case 2:
                    headUtility();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Выход из программы");
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }

        scanner.close();
    }

    private static void crossReferences(Scanner scanner) {
        String filePath = "document.txt";

        try {
            Map<String, Set<Integer>> wordOccurrences = new HashMap<>();

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    word = word.toLowerCase();

                    if (wordOccurrences.containsKey(word)) {
                        wordOccurrences.get(word).add(lineNumber);
                    } else {
                        Set<Integer> occurrences = new HashSet<>();
                        occurrences.add(lineNumber);
                        wordOccurrences.put(word, occurrences);
                    }
                }

                lineNumber++;
            }
            reader.close();

            for (Map.Entry<String, Set<Integer>> entry : wordOccurrences.entrySet()) {
                System.out.println("Слово: " + entry.getKey() + ", Строки: " + entry.getValue());
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static void headUtility() {
        String filePath = "document.txt";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк для вывода: ");
        int lineNumbers = scanner.nextInt();
        scanner.nextLine();

        head(lineNumbers, filePath);
    }

    private static void head(int lineNumbers, String filePath) {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            String line;
            for (int i = 0; i < lineNumbers; i++) {
                if ((line = file.readLine()) != null) {
                    System.out.println(line);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}