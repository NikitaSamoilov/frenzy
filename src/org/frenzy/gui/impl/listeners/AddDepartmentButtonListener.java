package org.frenzy.gui.impl.listeners;


import org.frenzy.controllers.ManufactureController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDepartmentButtonListener implements ActionListener {

    private ManufactureController manufactureController;

    public ManufactureController getManufactureController() {
        return manufactureController;
    }

    public void setManufactureController(ManufactureController manufactureController) {
        this.manufactureController = manufactureController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: realize
    }
}
