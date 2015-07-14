package org.frenzy.gui.impl.listeners;

import org.frenzy.gui.ManufactureDisplayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButtonListener implements ActionListener {

    protected ManufactureDisplayer manufactureDisplayer;


    public NextButtonListener(ManufactureDisplayer manufactureDisplayer) {
        this.manufactureDisplayer = manufactureDisplayer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: build next state of manufacture
        manufactureDisplayer.update();
    }
}
