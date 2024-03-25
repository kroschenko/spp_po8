import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Поиск моды последовательности чисел");
            System.out.println("2. Сдвиг элементов массива вправо");
            System.out.println("3. Проверка на панграмму");
            System.out.println("4. Выход из программы");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    findModeSequence(scanner);
                    break;
                case 2:
                    shiftArrayRight(scanner);
                    break;
                case 3:
                    checkPangram(scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Выход из программы");
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }

        scanner.close();
    }

    public static void findModeSequence(Scanner scanner) {
        System.out.println("Введите последовательность чисел через пробел:");
        String[] input = scanner.nextLine().split(" ");
        int[] sequence = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            sequence[i] = Integer.parseInt(input[i]);
        }

        List<Integer> modes = findMode(sequence);

        if (modes.isEmpty()) {
            System.out.println("Последовательность не имеет моды");
        } else {
            System.out.print("Мода(ы) последовательности: ");
            for (int mode : modes) {
                System.out.print(mode + " ");
            }
            System.out.println();
        }
    }

    public static List<Integer> findMode(int[] sequence) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : sequence) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> modes = new ArrayList<>();
        int maxFrequency = 0;

        for (int frequency : frequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }

        return modes;
    }

    public static void shiftArrayRight(Scanner scanner) {
        System.out.println("Введите элементы массива через пробел:");
        String[] input = scanner.nextLine().split(" ");
        double[] array = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Double.parseDouble(input[i]);
        }

        System.out.print("Введите количество позиций сдвига вправо: ");
        int shift = scanner.nextInt();
        scanner.nextLine();

        shiftRight(array, shift);

        System.out.println("Массив после сдвига на " + shift + " позиций вправо:");
        printArray(array);
    }

    public static void shiftRight(double[] array, int shift) {
        int n = array.length;
        shift %= n;

        double[] temp = new double[n];
        for (int i = 0; i < n; i++) {
            temp[(i + shift) % n] = array[i];
        }

        System.arraycopy(temp, 0, array, 0, n);
    }

    public static void printArray(double[] array) {
        for (double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void checkPangram(Scanner scanner) {
        System.out.println("Введите строку для проверки на панграмму:");
        String str = scanner.nextLine();
        boolean isPangram = pangramEng(str);

        if (isPangram) {
            System.out.println("Данная строка является панграммой.");
        } else {
            System.out.println("Данная строка не является панграммой.");
        }
    }

    public static boolean pangramEng(String str) {
        str = str.toLowerCase();
        boolean[] seen = new boolean[26];

        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                seen[c - 'a'] = true;
            }
        }

        for (boolean letter : seen) {
            if (!letter) {
                return false;
            }
        }

        return true;
    }
}