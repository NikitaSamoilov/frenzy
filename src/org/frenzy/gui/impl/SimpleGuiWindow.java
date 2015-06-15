package org.frenzy.gui.impl;

import org.frenzy.gui.GuiWindow;
import org.frenzy.gui.GuiWindowParams;
import org.frenzy.gui.ManufactureDisplayer;
import org.frenzy.gui.impl.components.ManufactureDrawPanel;
import org.frenzy.gui.impl.listeners.NextButtonListener;

import javax.swing.*;

public class SimpleGuiWindow extends GuiWindow {

    private ManufactureDisplayer manufactureDisplayer;
    private JButton nextButton;

    public SimpleGuiWindow(GuiWindowParams params) {
        super(params);
    }

    @Override
    protected void buildAndAttachElements() {
        manufactureDisplayer = buildManufactureDisplayer();
        add(manufactureDisplayer.getComponent());
        manufactureDisplayer.update();

        nextButton = buildNextButton();
        add(nextButton);
        nextButton.addActionListener(new NextButtonListener(manufactureDisplayer));
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
