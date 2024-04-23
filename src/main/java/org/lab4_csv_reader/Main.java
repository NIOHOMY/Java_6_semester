package org.lab4_csv_reader;

import org.lab4_csv_reader.core.entities.CSVFileReader;
import java.util.List;
import org.lab4_csv_reader.core.entities.Person;


public class Main {
    public static void main(String[] args) {
        CSVFileReader csvReader = new CSVFileReader();
        List<Person> people = csvReader.readPeopleFromCSV("res/foreign_names.csv", ';');

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
