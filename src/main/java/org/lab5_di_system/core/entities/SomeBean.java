package org.lab5_di_system.core.entities;

import org.lab5_di_system.core.annotations.AutoInjectable;
import org.lab5_di_system.core.interfaces.SomeInterface;
import org.lab5_di_system.core.interfaces.SomeOtherInterface;

public class SomeBean{
    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface field2;
    public void foo(){
        field1.doSomething();
        field2.doSomeOther();
    }
}
