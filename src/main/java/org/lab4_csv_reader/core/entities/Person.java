package org.lab4_csv_reader.core.entities;

/**
 * Data class.
 * Represents a person.
 */
public class Person {

    private final int id;
    private final String name;
    private final String gender;
    private final Department department;
    private final double salary;
    private final String birthDate;

    /**
     * Constructs a new Person object with the given attributes.
     *
     * @param id         the unique identifier of the person
     * @param name       the name of the person
     * @param gender     the gender of the person
     * @param department the department the person belongs to
     * @param salary     the salary of the person
     * @param birthDate  the birth date of the person
     */
    public Person(int id, String name, String gender, Department department, double salary, String birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    /**
     * Returns a string representation of the person.
     *
     * @return a string representation of the person
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department.getName() + '\'' +
                ", salary=" + salary +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    /**
     * Gets the ID of the person.
     *
     * @return the ID of the person
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the gender of the person.
     *
     * @return the gender of the person
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets the department of the person.
     *
     * @return the department of the person
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Gets the salary of the person.
     *
     * @return the salary of the person
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Gets the birth date of the person.
     *
     * @return the birth date of the person
     */
    public String getBirthDate() {
        return birthDate;
    }
}
