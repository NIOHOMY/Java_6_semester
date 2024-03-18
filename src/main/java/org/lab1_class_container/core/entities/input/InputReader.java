package org.lab1_class_container.core.entities.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    private Scanner scanner;

    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public int readIntFromConsole() {
        int choice = 0;
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                choice = scanner.nextInt();
                isValidInput = true; // Если удалось считать число, устанавливаем флаг в true
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите целое число.");
                scanner.nextLine(); // очистка буфера сканера
            }
        }
        return choice;
    }

    public void closeScanner() {
        scanner.close();
    }
}
