package org.lab4_csv_reader.tests.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lab4_csv_reader.core.entities.Department;
import org.lab4_csv_reader.core.entities.Person;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for the {@link Person} class.
 */
public class PersonTests {

    private Department departmentMock;

    /**
     * setUp - сreating a mock object for the Department class
     */
    @BeforeEach
    public void setUp() {
        departmentMock = createMock(Department.class);
    }
    /**
     * Tests the constructor of the Person class.
     * Define the expected behavior for the mock object.
     */
    @Test
    public void testConstructor() {
        expect(departmentMock.getName()).andReturn("IT Department");
        replay(departmentMock);

        int id = 1;
        String name = "John Doe";
        String gender = "Male";
        double salary = 50000.0;
        String birthDate = "1990-01-01";
        Person person = new Person(id, name, gender, departmentMock, salary, birthDate);

        assertNotNull(person);

        assertEquals(id, person.getId());
        assertEquals(name, person.getName());
        assertEquals(gender, person.getGender());
        assertEquals("IT Department", person.getDepartment().getName());
        assertEquals(salary, person.getSalary(), 0.0001);
        assertEquals(birthDate, person.getBirthDate());

        verify(departmentMock);
    }

    /**
     * Tests the {@link Person#toString()} method.
     * Define the expected behavior for the mock object.
     */
    @Test
    public void testToString() {

        expect(departmentMock.getName()).andReturn("IT Department");
        replay(departmentMock);

        int id = 2;
        String name = "Jane Smith";
        String gender = "Female";
        double salary = 60000.0;
        String birthDate = "1995-05-15";
        Person person = new Person(id, name, gender, departmentMock, salary, birthDate);


        String expectedToString = "Person{id=" + id + ", name='" + name + "', gender='" + gender + "', department='" + "IT Department" + "', salary=" + salary + ", birthDate='" + birthDate + "'}";

        assertEquals(expectedToString, person.toString());
        verify(departmentMock);
    }
}


