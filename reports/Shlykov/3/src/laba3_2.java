import java.util.*;

public class laba3_2 {
    public static void main(String[] args) {
        StackCalculator calculator = new StackCalculator();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            try {
                calculator.execute(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
