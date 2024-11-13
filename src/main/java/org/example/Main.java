package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an expression (or type 'exit' to quit) (sin(x)/cos(x)/tan(x)/sqrt(x)): ");
            String expression = scanner.nextLine();

            if (expression.equalsIgnoreCase("exit")) {
                break; // Выход из программы
            }

            Map<Character, Double> variables = new HashMap<>();
            System.out.print("Enter the value for variable x: ");
            double value = scanner.nextDouble();
            variables.put('x', value);
            scanner.nextLine(); // Очистка буфера после ввода числа

            try {
                double result = ExpressionResolver.evaluateExpression(expression, variables);
                System.out.println("Result: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
