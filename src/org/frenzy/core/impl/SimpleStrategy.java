package org.frenzy.core.impl;

import org.frenzy.core.Department;
import org.frenzy.core.Strategy;

/**
 * Created by artem.grechishnikov on 09.07.2015.
 */
public class SimpleStrategy extends Strategy {

    @Override
    public void performTasksInProcess(Department dep){
        int quantityOfIncomingTasks = dep.getQuantityOfTasksInProcess();
        int quantityOfTasksForNextDepartment = dep.getQuantityOfTasksForNextDepartment();
        int finishedTasks = getFinishedTasks(quantityOfIncomingTasks);

        quantityOfIncomingTasks -= finishedTasks;
        quantityOfTasksForNextDepartment += finishedTasks;

        dep.setQuantityOfTasksInProcess(quantityOfIncomingTasks);
        dep.setQuantityOfTasksForNextDepartment(quantityOfTasksForNextDepartment);
    }

    private int getFinishedTasks(int quantityOfIncomingTasks) {
        int quantityOfFinishedTasks = (int)(Math.random()*5);

        if (quantityOfFinishedTasks > quantityOfIncomingTasks)
            quantityOfFinishedTasks = quantityOfIncomingTasks;
        return quantityOfFinishedTasks;
    }

}
