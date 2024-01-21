import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите выражение (например, 2+3): ");
        String input = scanner.nextLine();

        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Неправильный формат выражения");
        }

        int a;
        int b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неподходящие числа");
        }
        if (a > 10 || b > 10 || a < 1 || b < 1)
            throw new IllegalArgumentException("Неподходящие числа");

        String operator = parts[1];
        int result;

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }

        System.out.println("Результат: " + result);
    }
}