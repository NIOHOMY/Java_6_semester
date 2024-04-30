package org.lab5_di_system.core.entities;

import org.lab5_di_system.core.interfaces.SomeOtherInterface;

public class SODoer implements SomeOtherInterface {
    @Override
    public void doSomeOther() {
        System.out.println("C");
    }
}
