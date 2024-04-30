package org.lab5_di_system.tests.unit;

import org.junit.jupiter.api.Test;
import org.lab5_di_system.core.entities.SODoer;
import org.lab5_di_system.core.interfaces.SomeOtherInterface;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SODoerTest {
    @Test
    void testDoSomething() {
        SomeOtherInterface someImpl = new SODoer();
        String output = getConsoleOutput(someImpl::doSomeOther);
        assertEquals("C\r\n", output);

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
