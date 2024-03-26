import java.util.Scanner;

public class lab1_3 {
        public static void main(String[] args) {
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите строку: ");
            String input = scanner.nextLine();
            scanner.close();
            String result = capitalize(input);
            System.out.println("Результат капитализации: " + result);
        }
    public static String capitalize(String str) {
        if (str == null) {
            return null;
        }
        if (str.trim().isEmpty()) {
            return str;
        }
        String[] words = str.trim().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
            }
        }
        return String.join(" ", words);
    }}
