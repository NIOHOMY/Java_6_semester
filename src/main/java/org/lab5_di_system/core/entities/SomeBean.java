package org.lab5_di_system.core.entities;

import org.lab5_di_system.core.annotations.AutoInjectable;
import org.lab5_di_system.core.interfaces.SomeInterface;
import org.lab5_di_system.core.interfaces.SomeOtherInterface;

/**
 * A bean class that demonstrates the usage of automatic dependency injection using the {@code AutoInjectable} annotation.
 * This class has two fields annotated with {@code AutoInjectable}, which are automatically injected with dependencies
 * when an instance of this class is created by the dependency injection framework.
 * The {@code foo} method demonstrates how these injected dependencies can be used within the class.
 *
 * Example usage:
 * {@code
 * // Assuming proper configuration and setup of dependency injection framework
 * SomeBean bean = new SomeBean();
 * bean.foo(); // Executes the logic using injected dependencies
 * }
 */
public class SomeBean{
    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface field2;
    /**
     * Performs some logic using the injected dependencies.
     * Calls the {@code doSomething} method of {@code field1} and the {@code doSomeOther} method of {@code field2}.
     */
    public void foo(){
        field1.doSomething();
        field2.doSomeOther();
    }
}
