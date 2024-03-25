import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int count = 10;  // по умолчанию выводим 10 строк
        String fileName;

        if (args.length == 4 && args[0].equals("tail") && args[1].equals("-n")) { // если ключ -n и количество строк указано через пробел
            try {
                count = Integer.parseInt(args[2]); // получаем количество строк
                fileName = args[3]; // получаем имя файла
            } catch (NumberFormatException e) {
                System.out.println("Invalid command");
                return;
            }
        } else if (args.length == 3 && args[0].equals("tail")) { // если только количество строк и имя файла указано
            try {
                count = Integer.parseInt(args[1]);
                fileName = args[2];
            } catch (NumberFormatException e) {
                System.out.println("Invalid command");
                return;
            }
        } else {
            System.out.println("Usage: tail [-n] <number of lines> file");
            return;
        }

        // читаем последние строки из файла
        try (RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
            long length = file.length(); // получаем длину файла
            long pos = length - 1;  // стартовая позиция - последний символ в файле
            int lines = 0; // количество строк
            Stack<String> tailLines = new Stack<>();

            StringBuilder builder = new StringBuilder();
            for (long pointer = pos; pointer >= 0; pointer--) {
                file.seek(pointer); // устанавливаем позицию указателя
                char c = (char) file.read(); // читаем символ
                builder.append(c); // добавляем символ в буфер

                if (c == '\n') {
                    builder = builder.reverse(); // переворачиваем буфер, чтобы получить строку
                    tailLines.push(builder.toString());
                    builder.setLength(0); // очищаем буфер
                    lines++; // увеличиваем счетчик строк
                    if (lines >= count) { // если достигли нужного количества строк, выходим из цикла
                        break;
                    }
                }
            }
            ListIterator<String> listIterator = tailLines.listIterator(tailLines.size());
            while (listIterator.hasPrevious()) {
                System.out.print(listIterator.previous());
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

    }

}
