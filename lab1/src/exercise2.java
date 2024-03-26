package lab1;
import java.util.Scanner;

public class exercise2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите элементы массива через пробел: ");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        double[] array = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = Double.parseDouble(numbers[i]);
        }

        System.out.print("Введите начальный индекс подмассива: ");
        int startIndex = scanner.nextInt();
        System.out.print("Введите конечный индекс подмассива: ");
        int endIndex = scanner.nextInt();

        double[] subarray = subarray(array, startIndex, endIndex);
        System.out.print("Подмассив: ");
        for (double num : subarray) {
            System.out.print(num + " ");
        }
    }
    public static double[] subarray(double[] array, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > array.length || startIndex >= endIndex) {
            throw new IllegalArgumentException("Некорректные индексы подмассива");
        }
        double[] subarray = new double[endIndex - startIndex];
        for (int i = startIndex; i < endIndex; i++) {
            subarray[i - startIndex] = array[i];
        }
        return subarray;
    }
}
