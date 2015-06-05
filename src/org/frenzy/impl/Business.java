package org.frenzy.impl;

import org.frenzy.Department;

/**
 * Created by artem.grechishnikov on 03.06.2015.
 */
public class Business extends Department{

    @Override
    public int countDaysToFinish () {
        int days = (quantityOfTasksInProcess/quantityOfUnits)/8;
        return days;
    }
}
