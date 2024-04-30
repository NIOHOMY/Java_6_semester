package org.lab5_di_system.tests.module;

import org.lab5_di_system.core.annotations.AutoInjectable;

// Define a test class with dependencies to be injected
public class TestClass {
    @AutoInjectable
    private Service service;

    public Service getService() {
        return service;
    }
}
