package org.frenzy.impl;


import org.frenzy.Department;

/**
 * Created by artem.grechishnikov on 02.06.2015.
 */

public class Dev extends Department {

    public Dev() {
        name = "Developers";
    }

    @Override
    public int countDaysToFinish () {
        int days = (quantityOfTasksInProcess/quantityOfUnits)/2;
        return days;
    }
}
