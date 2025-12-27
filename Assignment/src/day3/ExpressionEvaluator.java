package day3;
import java.util.*;
public class ExpressionEvaluator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        try {
            int result = evaluate(input);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Invalid expression format.");
            System.exit(0);
        }

        sc.close();
    }

    public static int evaluate(String expr) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    sb.append(expr.charAt(i++));
                }
                values.push(Integer.parseInt(sb.toString()));
                i--;
            } 
            else if (isOp(ch)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    values.push(apply(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(ch);
            } 
            else {
                System.out.println("Error: Invalid character " + ch);
                System.exit(0);
            }
        }

        while (!operators.isEmpty()) {
            values.push(apply(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    public static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return -1;
    }

    public static int apply(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if (b == 0) {
                    System.out.println("Error: Division by zero");
                    System.exit(0);
                }
                return a / b;
        }
        return 0;
    }

    public static boolean isOp(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}