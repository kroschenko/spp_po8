import java.util.Scanner;
import java.io.File;
import java.util.Set;
import java.util.TreeSet;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) {
        try {

            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            Set<String> wordsSet = new TreeSet<>();

            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^a-zA-Z]", "").toLowerCase();
                wordsSet.add(word);
            }

            for (String word : wordsSet) {
                System.out.println(word);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
