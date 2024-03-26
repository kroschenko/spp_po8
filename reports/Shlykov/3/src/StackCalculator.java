import java.util.*;
public class StackCalculator {
    private final Deque<Double> stack = new ArrayDeque<>();
    private final Map<String, Double> variables = new HashMap<>();

    public void execute(String command) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "PUSH":
                stack.push(Double.parseDouble(parts[1]));
                break;
            case "POP":
                if (stack.isEmpty()) {
                    throw new RuntimeException("Stack is empty");
                }
                stack.pop();
                break;
            case "+":
                checkStackSize(2);
                stack.push(stack.pop() + stack.pop());
                break;
            case "-":
                checkStackSize(2);
                stack.push(-stack.pop() + stack.pop());
                break;
            case "*":
                checkStackSize(2);
                stack.push(stack.pop() * stack.pop());
                break;
            case "/":
                checkStackSize(2);
                double divisor = stack.pop();
                if (divisor == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                stack.push(stack.pop() / divisor);
                break;
            case "SQRT":
                checkStackSize(1);
                stack.push(Math.sqrt(stack.pop()));
                break;
            case "PRINT":
                if (stack.isEmpty()) {
                    throw new RuntimeException("Stack is empty");
                }
                System.out.println(stack.peek());
                break;
            case "DEFINE":
                variables.put(parts[1], Double.parseDouble(parts[2]));
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + parts[0]);
        }
    }

    private void checkStackSize(int size) {
        if (stack.size() < size) {
            throw new RuntimeException("Stack contains less than " + size + " elements");
        }
    }
}
