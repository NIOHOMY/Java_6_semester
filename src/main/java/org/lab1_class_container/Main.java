package org.lab1_class_container;

import org.lab1_class_container.core.entities.сontainers.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        int listSize = list.getSize();
        System.out.println("Размер списка " + listSize);

        int element = list.get(0);
        System.out.println("Элемент по индексу " + 0 + ": " + element);

        list.remove(0);
        element = list.get(0);
        System.out.println("Элемент по индексу " + 0 + ": " + element);

        listSize = list.getSize();
        System.out.println("Размер списка " + listSize);
    }
}