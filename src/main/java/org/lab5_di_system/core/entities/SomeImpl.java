package org.lab5_di_system.core.entities;

import org.lab5_di_system.core.interfaces.SomeInterface;

/**
 * An implementation of the {@code SomeInterface} interface that performs a specific action when the {@code doSomething} method is called.
 * This implementation prints "A" to the standard output.
 *
 * Example usage:
 * {@code
 * SomeInterface instance = new SomeImpl();
 * instance.doSomething(); // Output: A
 * }
 *
 */
public class SomeImpl implements SomeInterface {
    @Override
    public void doSomething() {
        System.out.println("A");
    }
}
