package org.lab5_di_system.core.entities;

import org.lab5_di_system.core.interfaces.SomeOtherInterface;

/**
 * An implementation of the {@code SomeOtherInterface} interface that performs a specific action when the {@code doSomeOther} method is called.
 * This implementation prints "A" to the standard output.
 *
 * Example usage:
 * {@code
 * SomeOtherInterface instance = new SODoer();
 * instance.doSomeOther(); // Output: C
 * }
 *
 */
public class SODoer implements SomeOtherInterface {
    @Override
    public void doSomeOther() {
        System.out.println("C");
    }
}
