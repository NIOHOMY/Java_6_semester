package org.lab1_class_container;

import org.lab1_class_container.core.entities.сontainers.LinkedList;
import org.globalEntities.input.InputReader;


public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        InputReader inputReader = new InputReader();

        while (true) {
            System.out.println("Текущий список:");
            int currentListSize = list.getSize();
            for (int i = 0; i < currentListSize; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            System.out.println("1. Добавить элемент");
            System.out.println("2. Получить элемент по индексу");
            System.out.println("3. Удалить элемент по индексу");
            System.out.println("4. Вывести размер списка");
            System.out.println("5. Выйти из программы");
            System.out.print("Выберите действие: ");

            int choice = inputReader.readIntFromConsole();

            switch (choice) {
                case 1:
                    System.out.print("Введите элемент для добавления: ");
                    int data = inputReader.readIntFromConsole();
                    list.add(data);
                    System.out.println("Элемент добавлен в список.");
                    break;
                case 2:
                    System.out.print("Введите индекс элемента для получения: ");
                    int index = inputReader.readIntFromConsole();
                    try {
                        int element = list.get(index);
                        System.out.println("Элемент по индексу " + index + ": " + element);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Индекс вне границ списка.");
                    }
                    break;
                case 3:
                    System.out.print("Введите индекс элемента для удаления: ");
                    int removeIndex = inputReader.readIntFromConsole();
                    try {
                        list.remove(removeIndex);
                        System.out.println("Элемент удален из списка.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Индекс вне границ списка.");
                    }
                    break;
                case 4:
                    System.out.println("Размер списка: " + list.getSize());
                    break;
                case 5:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор, попробуйте еще раз.");
            }
        }


    }
}