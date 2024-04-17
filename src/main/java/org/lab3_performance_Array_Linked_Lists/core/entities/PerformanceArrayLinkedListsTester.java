package org.lab3_performance_Array_Linked_Lists.core.entities;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class for testing the performance of ArrayList and LinkedList in Java.
 */
public class PerformanceArrayLinkedListsTester {
    // Field to store ArrayList, LinkedList and Maximum number of operations
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private final int MAX_OPERATIONS = 16000;

    /**
     * Method to run performance testing.
     */
    public final void testPerformance() {
        for (int i=1000; i<=MAX_OPERATIONS; i*=2){
            testAdd(i);
            testGet(i);
            testContains(i);
            testDelete(i);
            testClear(i);
        }
    }

    /**
     * Method to test deletion of elements from the lists.
     * @param NUM_OPERATIONS number of delete operations
     */
    private  void testDelete(int NUM_OPERATIONS) {

        long arrayListDeleteTime = measureTime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++) {
                    arrayList.remove(0);
            }
        }, NUM_OPERATIONS);

        long linkedListDeleteTime = measureTime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++) {
                    linkedList.removeFirst();
                }
        }, NUM_OPERATIONS);

        printResult("Delete  ", arrayListDeleteTime, linkedListDeleteTime, NUM_OPERATIONS);
    }

    /**
     * Method to test clearing of the lists.
     * @param NUM_OPERATIONS number of clear operations
     */
    private  void testClear(int NUM_OPERATIONS) {

        for (int i = 0; i < NUM_OPERATIONS; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long arrayListClearTime = measureTime(() -> {
                arrayList.clear();
        }, NUM_OPERATIONS);

        long linkedListClearTime = measureTime(() -> {
                linkedList.clear();
        }, NUM_OPERATIONS);

        printResult("Clear   ", arrayListClearTime, linkedListClearTime, NUM_OPERATIONS);
    }

    /**
     * Method to test addition of elements to the lists.
     * @param NUM_OPERATIONS number of add operations
     */
    private  void testAdd(int NUM_OPERATIONS) {
        long arrayListAddTime = measureTime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++) {
                    arrayList.add(i);
            }
        }, NUM_OPERATIONS);

        long linkedListAddTime = measureTime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++) {
                    linkedList.add(i);
            }
        }, NUM_OPERATIONS);

        printResult("Add     ", arrayListAddTime, linkedListAddTime, NUM_OPERATIONS);
    }


    /**
     * Method to test getting elements from the lists.
     * @param NUM_OPERATIONS number of get operations
     */
    private  void testGet(int NUM_OPERATIONS) {

        long arrayListGetTime = measureTime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++) {
                    arrayList.get(i);
                }
        }, NUM_OPERATIONS);

        long linkedListGetTime = measureTime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++) {
                    linkedList.get(i);
                }
        }, NUM_OPERATIONS);

        printResult("Get     ", arrayListGetTime, linkedListGetTime, NUM_OPERATIONS);
    }

    /**
     * Method to test checking for element existence in the lists.
     * @param NUM_OPERATIONS number of contains operations
     */
    private  void testContains(int NUM_OPERATIONS) {

        long arrayListContainsTime = measureTime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++) {
                arrayList.contains(i);
            }
        }, NUM_OPERATIONS);

        long linkedListContainsTime = measureTime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++) {
                linkedList.contains(i);
            }
        }, NUM_OPERATIONS);

        printResult("Contains", arrayListContainsTime, linkedListContainsTime, NUM_OPERATIONS);
    }


    /**
     * Method to measure the execution time of a task.
     * @param task the task whose execution time needs to be measured
     * @param NUM_OPERATIONS number of operations
     * @return the execution time of the task per operation
     */
    private  long measureTime(Runnable task, int NUM_OPERATIONS) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        return (endTime - startTime) / NUM_OPERATIONS;
    }

    /**
     * Method to print the test results to the screen.
     * @param operation the name of the operation
     * @param arrayListTime the time taken for the operation with ArrayList
     * @param linkedListTime the time taken for the operation with LinkedList
     * @param NUM_OPERATIONS number of operations
     */
    private  void printResult(String operation, long arrayListTime, long linkedListTime, int NUM_OPERATIONS) {
        System.out.println("Operation\tCount\tArrayList Time (ns)\tLinkedList Time (ns)");
        System.out.println(operation + "\t" + NUM_OPERATIONS + "\t\t\t" + arrayListTime + "\t\t\t" + linkedListTime);
        System.out.println(" ");
    }

}
