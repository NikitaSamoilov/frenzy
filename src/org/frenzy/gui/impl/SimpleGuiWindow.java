package org.frenzy.gui.impl;

import org.frenzy.gui.GuiWindow;
import org.frenzy.gui.GuiWindowParams;
import org.frenzy.gui.ManufactureDisplayer;
import org.frenzy.gui.impl.components.ManufactureDrawPanel;
import org.frenzy.gui.impl.listeners.AddDepartmentButtonListener;
import org.frenzy.gui.impl.listeners.NextButtonListener;

import javax.swing.*;

public class SimpleGuiWindow extends GuiWindow {

    private ManufactureDisplayer manufactureDisplayer;
    private JButton nextButton;
    private JButton addDepartmentButton;

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

        addDepartmentButton = buildAddDepartmentButton();
        add(addDepartmentButton);
    }

    protected JButton buildNextButton() {
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(10, 10, 80, 30);
        nextButton.addActionListener(new NextButtonListener(manufactureDisplayer));

        return nextButton;
    }

    protected JButton buildAddDepartmentButton() {
        JButton addDepartmentButton = new JButton("Add department");
        addDepartmentButton.setBounds(100, 10, 160, 30);
        AddDepartmentButtonListener listener = new AddDepartmentButtonListener(manufacture) {
            @Override
            public void processPostEffect() {
                manufactureDisplayer.update();
            }
        };
        addDepartmentButton.addActionListener(listener);

        return addDepartmentButton;
    }

    protected ManufactureDisplayer buildManufactureDisplayer() {
        ManufactureDisplayer displayer = new ManufactureDrawPanel();
        displayer.setManufacture(manufacture);
        displayer.setBounds(10, 50, 200, 200);
        return displayer;
    }
}
