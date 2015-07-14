package org.frenzy.gui.impl.components;

import org.frenzy.core.Manufacture;
import org.frenzy.gui.ManufactureDisplayer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLUE);

        for (int i = 0; i < manufacture.getDepartmentsCount(); i++) {
            drawDepartments(g2, i);
            drawLinks(g2, i);
        }
    }

    protected void drawDepartments(Graphics2D g2, int i) {
        ArrayList<Integer> coordinates = chooseDepartmentCoordinates(i);
        g2.fillOval(coordinates.get(0), coordinates.get(1), coordinates.get(2), coordinates.get(3));
    }

    protected void drawLinks(Graphics2D g2, int i) {
        if (i != (manufacture.getDepartmentsCount() - 1) )  {
            ArrayList<Integer> coordinates = chooseLinksCoordinates(i);
            g2.fillOval(coordinates.get(0), coordinates.get(1), coordinates.get(2), coordinates.get(3));
        }
    }

    protected ArrayList<Integer> chooseDepartmentCoordinates(int i) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        int startVer, startHor, width, heigth;

        startVer = getHeight()/2;
        width = (getWidth() - 20 - manufacture.getDepartmentsCount()*10)/manufacture.getDepartmentsCount();
        startHor = 10 + width*i + 10*i;
        heigth = (getHeight() - 20)/2;

        coordinates.add(startHor);
        coordinates.add(startVer);
        coordinates.add(width);
        coordinates.add(heigth);

        return coordinates;
    }

    protected ArrayList<Integer> chooseLinksCoordinates(int i) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        int startVer, startHor, width, heigth;

        heigth = (getHeight() - 20)/2;
        startVer = getHeight()/2 + heigth/2;
        width = (getWidth() - 20 - manufacture.getDepartmentsCount()*10)/manufacture.getDepartmentsCount();
        startHor = 10 + width*(i + 1) + 10*i;

        coordinates.add(startHor);
        coordinates.add(startVer);
        coordinates.add(10);
        coordinates.add(1);

        return coordinates;
    }
}
