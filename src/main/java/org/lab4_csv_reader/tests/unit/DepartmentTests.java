package org.lab4_csv_reader.tests.unit;

import org.junit.jupiter.api.Test;
import org.lab4_csv_reader.core.entities.Department;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link Department} class.
 */
public class DepartmentTests {

    /**
     * Tests the constructor of the Department class.
     */
    @Test
    public void testConstructor() {
        String name = "IT Department";
        Department department = new Department(name);

        assertNotNull(department);

        assertEquals(name, department.getName());

        assertNotNull(department.getID());
    }

    /**
     * Tests the {@link Department#getName()} method.
     */
    @Test
    public void testGetName() {
        String name = "HR Department";
        Department department = new Department(name);

        assertEquals(name, department.getName());
    }

    /**
     * Tests the {@link Department#getID()} method.
     */
    @Test
    public void testGetID() {
        Department department = new Department("Finance Department");

        UUID id = department.getID();

        assertNotNull(id);
    }
}

