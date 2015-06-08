package org.frenzy.impl;

import org.frenzy.Department;

/**
 * Created by artem.grechishnikov on 02.06.2015.
 */

public class Analytics extends Department {

    public String name = "Analytics";

    @Override
    public int countDaysToFinish () {
        int days = (quantityOfTasksInProcess/quantityOfUnits)/4;
        return days;
    }
}
