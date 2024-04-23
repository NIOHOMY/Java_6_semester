package org.lab4_csv_reader.core.entities;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for reading people data from a CSV file.
 */
public class CSVFileReader {
    /**
     * Reads a list of Person objects from a CSV file.
     *
     * @param csvFilePath the path to the CSV file
     * @param separator   the character used as separator in the CSV file
     * @return a list of Person objects read from the CSV file
     */
    public List<Person> readPeopleFromCSV(String csvFilePath, char separator) {
        List<Person> people = new ArrayList<>();

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath);
             CSVReader reader = in == null ? null : new CSVReader(new InputStreamReader(in), separator)) {
            if (reader == null) {
                throw new Exception("File not found: " + csvFilePath);
            }
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                String gender = nextLine[2];
                String birthDate = nextLine[3];
                String departmentName = nextLine[4];
                double salary = Double.parseDouble(nextLine[5]);

                Person person = new Person(id, name, gender, new Department(departmentName), salary, birthDate);
                people.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return people;
    }

}

