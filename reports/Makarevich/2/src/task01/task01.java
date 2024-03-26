package task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class task01 {

    public static void main(String[] args) throws IOException {

        StringBuilder text = new StringBuilder();
        FileReader reader = new FileReader("src/task01/example.txt");
        BufferedReader br = new BufferedReader(reader);
        String line;

        while ((line = br.readLine()) != null) {
            text.append(line);
        }
        br.close();

        Vector<String> vec = new Vector<>();
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                wordBuilder.append(c);
            } else {
                if (wordBuilder.length() > 0) {
                    vec.add(wordBuilder.toString().toLowerCase());
                    wordBuilder.setLength(0);
                }
            }
        }
        if (wordBuilder.length() > 0) {
            vec.add(wordBuilder.toString().toLowerCase());
        }

        Map<String, Vector<Integer>> wordMap = new HashMap<>();
        for (int i = 0; i < vec.size(); i++) {
            String word = vec.get(i);
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, new Vector<>());
            }
            wordMap.get(word).add(i + 1);
        }

        for (Map.Entry<String, Vector<Integer>> entry : wordMap.entrySet()) {
            System.out.print(entry.getKey() + " contains in ");
            Vector<Integer> lineNumbers = entry.getValue();
            for (int i = 0; i < lineNumbers.size(); i++) {
                System.out.print(lineNumbers.get(i));
                if (i < lineNumbers.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
