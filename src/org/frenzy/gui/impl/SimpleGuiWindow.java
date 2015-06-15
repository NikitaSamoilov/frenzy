package org.frenzy.gui.impl;

import org.frenzy.gui.GuiWindow;
import org.frenzy.gui.GuiWindowParams;
import org.frenzy.gui.ManufactureDisplayer;
import org.frenzy.gui.impl.components.ManufactureDrawPanel;

import javax.swing.*;

public class SimpleGuiWindow extends GuiWindow {

    private ManufactureDisplayer manufactureDisplayer;
    private JButton nextButton;

    public SimpleGuiWindow(GuiWindowParams params) {
        super(params);
    }

    @Override
    protected void buildAndAttachElements() {
        nextButton = buildNextButton();
        add(nextButton);

        manufactureDisplayer = buildManufactureDisplayer();
        add(manufactureDisplayer.getComponent());
        manufactureDisplayer.update();
    }

    protected JButton buildNextButton() {
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(10, 10, 80, 30);

        return nextButton;
    }

    protected ManufactureDisplayer buildManufactureDisplayer() {
        ManufactureDisplayer displayer = new ManufactureDrawPanel();
        displayer.setManufacture(manufacture);
        displayer.setBounds(10, 50, 200, 200);
        return displayer;
    }
}
