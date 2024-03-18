import java.util.Scanner;
import java.util.StringJoiner;

public class task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String input = scanner.nextLine();

        String abbreviation = abbreviate(input);
        System.out.println("Abbreviation: " + abbreviation);
    }
    public static String abbreviate(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String[] words = str.split(" ");
        StringJoiner abbrev = new StringJoiner("");

        for (String word : words) {
            if (!word.isEmpty()) {
                char firstChar = Character.toUpperCase(word.charAt(0));
                abbrev.add(String.valueOf(firstChar));
            }
        }
        return abbrev.toString();
    }
}

