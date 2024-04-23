package org.lab3_csv_reader.core.entities;

public class Person {
    private final int id;
    private final String name;
    private final String gender;
    private final Department department;
    private final double salary;
    private final String birthDate;

    public Person(int id, String name, String gender, Department department, double salary, String birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = new Department(department.getName());
        this.salary = salary;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", departmentName='" + department.getName() + '\'' +
                ", salary=" + salary +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
