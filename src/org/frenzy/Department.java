package org.frenzy;

/**
 * Created by artem.grechishnikov on 02.06.2015.
 */
public abstract class Department {
    protected boolean isHappy;
    protected boolean isFree;
    protected int quantityOfTasksInProcess; //Number of tasks
    protected int quantityOfUnits;
    protected Department nextDep;

    protected String name = "Name";

    public void setHappiness (boolean isDepartmentHappy) {

        isHappy = isDepartmentHappy;
    }

    public boolean getHappiness () {

        return isHappy;
    }

    public String getName () {
        return name;
    }

    public void setBusyness (boolean isDepartmentFree) {

        isFree = isDepartmentFree;
    }

    public boolean getBusyness () {

        return isFree;
    }

    public void setTasksInProcess (int quantityOfTasks) {

        quantityOfTasksInProcess = quantityOfTasks;
    }

    public int getTasksInProcess () {

        return quantityOfTasksInProcess;
    }

    public void setUnits (int quantity) {

        quantityOfUnits = quantity;
    }

    public int getUnits () {

        return quantityOfUnits;
    }

    public abstract int countDaysToFinish ();
}
