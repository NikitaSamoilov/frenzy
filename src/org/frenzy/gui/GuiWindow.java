package org.frenzy.gui;

import org.frenzy.Manufacture;
import org.frenzy.gui.impl.SimpleGuiWindow;

import javax.swing.*;

public abstract class GuiWindow extends JFrame {

    protected Manufacture manufacture;

    protected GuiWindow(GuiWindowParams params) {
        manufacture = params.getManufacture();
        initMainWindow(params.getWidth(), params.getHeight());
        buildAndAttachElements();
    }

    public static GuiWindow buildWindow(GuiWindowType type, GuiWindowParams params) {
        switch (type) {
            case SIMPLE:
                return new SimpleGuiWindow(params);
            default:
                return null;
        }
    }

    protected void initMainWindow(int width, int height) {
        setSize(width, height);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected abstract void buildAndAttachElements();
}
