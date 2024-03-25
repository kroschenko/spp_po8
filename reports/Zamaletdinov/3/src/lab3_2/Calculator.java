import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Calculator {
    private Stack<Double> stack;
    private Map<String, Double> defineParams;

    public Calculator() {
        stack = new Stack<>();
        defineParams = new HashMap<>();
    }
    public void performCommand(String command) {
        String[] params = command.split("\\s+");
        String operation = params[0];
        try {
            switch (operation) {
                case "PRINT":
                    if (stack.isEmpty()) {
                        throw new OperationException("Стек пуст!");
                    }
                    System.out.println(stack.peek());
                    break;
                case "#":
                    break;
                case "PUSH":
                    try {
                        stack.push(Double.parseDouble(params[1]));
                    }
                    catch (Exception e) {
                        throw new OperationException("Не удалось добавить элемент!");
                    }
                    break;
                case "POP":
                    if (stack.isEmpty()) {
                        throw new OperationException("Стек пуст!");
                    }
                    stack.pop();
                    break;
                case "+":
                    if (stack.size() < 2) {
                        throw new OperationException("Недостаточно операндов в стеке!");
                    }
                    double a = stack.pop();
                    double b = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    if (stack.size() < 2) {
                        throw new OperationException("Недостаточно операндов в стеке!");
                    }
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    if (stack.size() < 2) {
                        throw new OperationException("Недостаточно операндов в стеке!");
                    }
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    if (stack.size() < 2) {
                        throw new OperationException("Недостаточно операндов в стеке!");
                    }
                    a = stack.pop();
                    b = stack.pop();

                    if (b == 0) {
                        stack.push(b);
                        stack.push(a);
                        throw new OperationException("Деление на 0!");
                    }
                    stack.push(a / b);
                    break;
                case "SQRT":
                    if (stack.isEmpty()) {
                        throw new OperationException("Стек пуст!");
                    }
                    a = stack.pop();

                    if (a < 0) {
                        stack.push(a);
                        throw new OperationException("Извлечение корня из отрицательного числа!");
                    }
                    stack.push(Math.sqrt(a));
                    break;
                case "DEFINE":
                    defineParams.put(params[1], Double.parseDouble(params[2]));
                    break;
                default:
                    throw new CommandException("Неизвестная операция:" + operation + "!");
            }
        } catch (CalculatorException e) {
            System.out.println("Ошибка:" + e);
        }
    }
}
