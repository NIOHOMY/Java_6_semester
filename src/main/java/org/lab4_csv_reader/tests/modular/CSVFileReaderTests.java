package org.lab4_csv_reader.tests.modular;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lab4_csv_reader.core.entities.CSVFileReader;
import org.lab4_csv_reader.core.entities.Person;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link CSVFileReader} class.
 */
public class CSVFileReaderTests {

    /**
     * Tests reading people from a CSV file.
     */
    @Test
    public void testReadPeopleFromCSV() {

        CSVFileReader csvFileReader = new CSVFileReader();

        String csvFilePath = "resTests/CSVFileReaderTest.csv";

        List<Person> people = csvFileReader.readPeopleFromCSV(csvFilePath, ',');

        Assertions.assertNotNull(people);

        assertEquals(1, people.size());

        Person firstPerson = people.get(0);
        assertEquals(28281, firstPerson.getId());
        assertEquals("Aahan", firstPerson.getName());
        assertEquals("Male", firstPerson.getGender());
        assertEquals("15.05.1970", firstPerson.getBirthDate());
        assertEquals("I", firstPerson.getDepartment().getName());
        assertEquals(4800.0, firstPerson.getSalary(), 0.01);
    }

    /**
     * Tests reading people from a CSV file with an invalid separator.
     */
    @Test
    public void testReadPeopleFromCSV_InvalidSeparator() {

        CSVFileReader csvFileReader = new CSVFileReader();

        String csvFilePath = "resTests/CSVFileReaderTest.csv";

        try {
            csvFileReader.readPeopleFromCSV(csvFilePath, ':');
        } catch (Exception e) {
            assertNotNull(e.getMessage());
            assertTrue(e.getMessage().contains("java.lang.NumberFormatException"));
            assertNotNull(e.getStackTrace());
            assertTrue(e.getStackTrace().length > 0);
        }
    }
}

