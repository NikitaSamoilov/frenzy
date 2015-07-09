package org.frenzy.controllers.impl;


import org.frenzy.controllers.ManufactureController;
import org.frenzy.core.Department;
import org.frenzy.core.Manufacture;

public class ManufactureControllerImpl implements ManufactureController {

    private final String NULL_DEPARTMENT_MESSAGE = "Department is null";

    @Override
    public void addDepartment(Manufacture manufacture, Department department) {
        if (department == null) {
            throw new IllegalArgumentException(NULL_DEPARTMENT_MESSAGE);
        }
        manufacture.addDepartment(department);
    }

    @Override
    public Department buildDefaultDepartment() {
        Department departmet = new Department("Default");
        return departmet;
    }
}
