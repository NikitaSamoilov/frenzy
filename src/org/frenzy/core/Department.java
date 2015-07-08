package org.frenzy.core;


public class Department {
    private String name;
    private Strategy strategy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department() {
        //
    }

    public Department(String name) {
        this.name = name;
    }
}
