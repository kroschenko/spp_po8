import java.io.*;
import java.util.*;

public class Laba2_1 {
    public static void main(String[] args) {
        try {
            File file = new File("text.txt"); 
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            Set<String> words = new TreeSet<>();

            while ((st = br.readLine()) != null) {
                String[] lineWords = st.split("\\s+");
                words.addAll(Arrays.asList(lineWords));
            }

            for (String word : words) {
                System.out.println(word);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
