package org.frenzy.controllers;


import org.frenzy.core.Department;
import org.frenzy.core.Manufacture;

public interface ManufactureController {
    void addDepartment(Manufacture manufacture, Department department);
    Department buildDefaultDepartment();
}
