package org.lab2_expression_calculation;

import org.lab2_expression_calculation.core.entities.ExpressionCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpressionCalculator calculator = new ExpressionCalculator();

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить переменную и её значение");
            System.out.println("2. Вычислить значение выражения");
            System.out.println("3. Выйти");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя переменной: ");
                    String variableName = scanner.nextLine();
                    System.out.print("Введите значение переменной: ");
                    double value = scanner.nextDouble();
                    calculator.addVariable(variableName, value);
                    System.out.println("Переменная добавлена.");
                    break;
                case 2:
                    System.out.println("Введите выражение для вычисления: ");
                    System.out.println("Пример: sin(x) + x - y*x / sqrt(y)");
                    String expression = scanner.nextLine();
                    double result = calculator.evaluateExpression(expression);
                    System.out.println("Результат выражения '" + expression + "': " + result);
                    break;
                case 3:
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите существующий пункт меню.");
            }
        }
    }
}
