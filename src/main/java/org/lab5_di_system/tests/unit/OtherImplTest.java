package org.lab5_di_system.tests.unit;

import org.junit.jupiter.api.Test;
import org.lab5_di_system.core.entities.OtherImpl;
import org.lab5_di_system.core.interfaces.SomeInterface;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OtherImplTest {
    @Test
    void testDoSomething() {
        SomeInterface someImpl = new OtherImpl();
        String output = getConsoleOutput(someImpl::doSomething);
        assertEquals("B\r\n", output);

    }

    private String getConsoleOutput(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream oldOut = System.out;
        System.setOut(printStream);

        try {
            runnable.run();
        } finally {
            System.setOut(oldOut);
        }

        return outputStream.toString();
    }
}
