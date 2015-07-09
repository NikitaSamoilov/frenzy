package org.frenzy.core;


import org.frenzy.core.impl.SimpleStrategy;

public class Department {
    private String name;
    private Strategy strategy;
    private int countOfTasksInProcess;
    private int countOfTasksForNextDepartment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountOfTasksInProcess (int countOfTasks) {
        this.countOfTasksInProcess = countOfTasks;
    }

    public int getCountOfTasksInProcess () {
        return countOfTasksInProcess;
    }

    public void setCountOfTasksForNextDepartment (int countOftasks) {
        this.countOfTasksForNextDepartment = countOftasks;
    }

    public int getCountOfTasksForNextDepartment () {
        return countOfTasksForNextDepartment;
    }

    public Department() {
        //
    }

    public Department(String name) {
        this.name = name;
        Strategy strategy = new SimpleStrategy();
    }
}
