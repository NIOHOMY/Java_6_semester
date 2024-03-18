package org.lab1_class_container.core.entities.сontainers;

import org.lab1_class_container.core.entities.сontainers.nodes.LinkedListNode;

public class LinkedList {
    private LinkedListNode head;
    private LinkedListNode tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(int data) {
        LinkedListNode newNode = new LinkedListNode(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public int get(int index) {
        LinkedListNode current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }

        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public void remove(int index) {
        if(index >= 0 && index <size)
        {
            if (index == 0) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
            } else {
                LinkedListNode current = head;
                int count = 0;

                while (current != null) {
                    if (count == index - 1) {
                        if (current.next == tail) {
                            tail = current;
                        }
                        current.next = current.next.next;
                        break;
                    }

                    count++;
                    current = current.next;
                }
            }

            size--;
        }
        else{
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public int getSize() {
        return size;
    }
}
