import java.io.*;

public class Tail {
    public static void main(String[] args) {
        

        int lines = 10;
        String filename;

        if (args.length == 2) {
            lines = Integer.parseInt(args[0]);
            filename = args[1];
        } else {
            filename = args[0];
        }

        try (RandomAccessFile file = new RandomAccessFile(filename, "r")) {
            long length = file.length();
            int readLines = 0;
            StringBuilder sb = new StringBuilder();

            for(long seek = length - 1; seek >= 0; seek--){
                file.seek(seek);
                int c = file.read();
                if(c == '\n'){
                    readLines++;
                    if(readLines == lines)
                        break;
                }
                sb.append((char)c);
            }

            System.out.println(sb.reverse().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
