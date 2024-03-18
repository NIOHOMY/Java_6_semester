package org.lab1_class_container.tests.unit_tests;

import org.lab1_class_container.core.entities.сontainers.LinkedList;
import org.testng.annotations.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the LinkedList class.
 */
public class LinkedListTest {
    /**
     * Tests the add method of the LinkedList class.
     */
    @Test
    public void testAdd() {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);

        assertEquals(2, list.getSize());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }
    /**
     * Tests the get method of the LinkedList class.
     */
    @Test
    public void testGet() {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }


    /**
     * Tests the remove method of the LinkedList class.
     */
    @Test
    public void testRemove() {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.remove(0);

        assertEquals(1, list.getSize());
        assertEquals(20, list.get(0));
    }

    /**
     * Tests the getSize method of the LinkedList class.
     */
    @Test
    public void testGetSize() {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);

        assertEquals(2, list.getSize());
    }
    /**
     * Tests the remove method of the LinkedList class with an invalid index.
     */
    @Test
    public void testRemoveMethodWithInvalidIndex() {
        LinkedList list = new LinkedList();
        list.add(10);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(1);
        });
    }
    /**
     * Tests the get method of the LinkedList class with an invalid index.
     */
    @Test
    public void testGetMethodWithInvalidIndex() {
        LinkedList list = new LinkedList();
        list.add(10);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(1);
        });
    }
}

