package org.lab5_di_system.core.entities;

import org.lab5_di_system.core.interfaces.SomeInterface;

public class SomeImpl implements SomeInterface {
    @Override
    public void doSomething() {
        System.out.println("A");
    }
}
