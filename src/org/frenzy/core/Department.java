package org.frenzy.core;


import org.frenzy.core.impl.SimpleStrategy;

public class Department {
    private String name;
    private Strategy strategy;
    private int quantityOfTasksInProcess;
    private int quantityOfTasksForNextDepartment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantityOfTasksInProcess(int quantityOfTasks) {
        this.quantityOfTasksInProcess = quantityOfTasks;
    }

    public int getQuantityOfTasksInProcess() {
        return quantityOfTasksInProcess;
    }

    public void setQuantityOfTasksForNextDepartment(int quantityOfTasks) {
        this.quantityOfTasksForNextDepartment = quantityOfTasks;
    }

    public int getQuantityOfTasksForNextDepartment() {
        return quantityOfTasksForNextDepartment;
    }

    public Department() {
        //
    }

    public Department(String name) {
        this.name = name;
        this.strategy = new SimpleStrategy();
    }
}
