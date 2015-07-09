package org.frenzy.gui.impl.listeners;


import org.frenzy.controllers.ManufactureController;
import org.frenzy.controllers.impl.ManufactureControllerImpl;
import org.frenzy.core.Department;
import org.frenzy.core.Manufacture;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AddDepartmentButtonListener implements ActionListener {

    private ManufactureController manufactureController;
    private Manufacture manufacture;

    public ManufactureController getManufactureController() {
        return manufactureController;
    }

    public void setManufactureController(ManufactureController manufactureController) {
        this.manufactureController = manufactureController;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public AddDepartmentButtonListener(Manufacture manufacture) {
        setManufacture(manufacture);
        manufactureController = new ManufactureControllerImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Department department = manufactureController.buildDefaultDepartment();
        manufactureController.addDepartment(manufacture, department);
        processPostEffect();
    }

    public abstract void processPostEffect();
}
