package lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class exercise1 {
    public static void main(String[] args) {

        String filename = "D:\\Intellij IDEA\\IdeaProjects\\labs\\out\\production\\labs\\lab2\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            StringBuilder textBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                textBuilder.append(line).append("\n");
            }

            String text = textBuilder.toString();

            String result = removeDuplicateWords(text);

            System.out.println("Преобразованный текст:");
            System.out.println(result);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    private static String removeDuplicateWords(String text) {
        StringBuilder resultBuilder = new StringBuilder();
        Set<String> uniqueWords = new HashSet<>();

        String[] words = text.split("\\s+");
        for (String word : words) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
                resultBuilder.append(word).append(" ");
            }
        }

        return resultBuilder.toString();
    }
}
