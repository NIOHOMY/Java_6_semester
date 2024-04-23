package org.lab4_csv_reader.core.entities;

import java.util.UUID;

/**
 * Data class.
 * Represents a department.
 */
public class Department {

    private final UUID id;
    private final String name;

    /**
     * Constructs a new Department object with the given name.
     *
     * @param name the name of the department
     */
    public Department(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    /**
     * Gets the name of the department.
     *
     * @return the name of the department
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the ID of the department.
     *
     * @return the ID of the department
     */
    public UUID getID() {
        return id;
    }
}

