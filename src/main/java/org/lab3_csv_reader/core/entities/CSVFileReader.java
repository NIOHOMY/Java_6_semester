package org.lab3_csv_reader.core.entities;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {
    public List<Person> readPeopleFromCSV(String csvFilePath) {
        List<Person> people = new ArrayList<>();

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath);
             CSVReader reader = in == null ? null : new CSVReader(new InputStreamReader(in), ';')) {
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

