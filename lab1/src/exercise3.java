package lab1;
import java.util.Scanner;

public class exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String str = scanner.nextLine();

        System.out.print("Введите количество позиций для сдвига вправо: ");
        int shift = scanner.nextInt();

        String shiftedString = shiftString(str, shift);
        if (shiftedString == null) {
            System.out.println("Ошибка: введена пустая строка.");
        } else {
            System.out.println("Результат сдвига: " + shiftedString);
        }

        scanner.close();
    }
    public static String shiftString(String str, int shift) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return null;
        }
        shift = shift % length;
        if (shift < 0) {
            shift = length + shift;
        }
        String shiftedString = str.substring(length - shift) + str.substring(0, length - shift);
        return shiftedString;
    }
}
