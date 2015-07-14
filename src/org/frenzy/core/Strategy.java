package org.frenzy.core;

/**
 * Created by artem.grechishnikov on 08.07.2015.
 */
public abstract class Strategy {

    public void performTasksInProcess (Department dep) {
        int quantityOfIncomingTasks = dep.getQuantityOfTasksInProcess();
        int quantityOfTasksForNextDepartment = dep.getQuantityOfTasksForNextDepartment();
        int finishedTasks = getFinishedTasks(quantityOfIncomingTasks);

        quantityOfIncomingTasks -= finishedTasks;
        quantityOfTasksForNextDepartment += finishedTasks;

        dep.setQuantityOfTasksInProcess(quantityOfIncomingTasks);
        dep.setQuantityOfTasksForNextDepartment(quantityOfTasksForNextDepartment);
    }

    protected abstract int getFinishedTasks(int quantityOfIncomingTasks);
}
