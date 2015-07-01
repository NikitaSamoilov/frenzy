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
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLUE);
        //g2.drawOval(20, 20, 100, 60);

        drawDepartments(g, g2);
    }

    protected void drawDepartments(Graphics g, Graphics2D g2) {
        int startVer, startHor, width, heigth;

        startVer = getHeight()/2;
        startHor = 10;
        width = (getWidth() - 20 - manufacture.getDepartmentsCount()*10)/manufacture.getDepartmentsCount();
        heigth = (getHeight() - 20)/2;

        g2.fillOval(startVer, startHor, width, heigth);
    }
}
