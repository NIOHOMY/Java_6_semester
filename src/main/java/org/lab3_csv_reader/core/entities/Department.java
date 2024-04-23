package org.lab3_csv_reader.core.entities;

import java.util.UUID;

public class Department {
    private UUID id;
    private final String name;


    public Department(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public UUID getID() {
        return id;
    }
}
