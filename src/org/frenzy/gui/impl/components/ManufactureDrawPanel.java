package org.frenzy.gui.impl.components;

import org.frenzy.Manufacture;
import org.frenzy.gui.ManufactureDisplayer;

import javax.swing.*;
import java.awt.*;

public class ManufactureDrawPanel extends JPanel implements ManufactureDisplayer {

    private Manufacture manufacture;

    @Override
    public Manufacture getManufacture() {
        return manufacture;
    }

    @Override
    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public Component getComponent() {
        return this;
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //TODO: draw code
    }
}
