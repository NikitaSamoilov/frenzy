package org.frenzy.impl;

import org.frenzy.Department;

/**
 * Created by artem.grechishnikov on 02.06.2015.
 */

public class Qa extends Department {

    public String name = "Testers";

    @Override
    public int countDaysToFinish () {
        int days = quantityOfTasksInProcess/quantityOfUnits;
        return days;
    }
}
