package org.frenzy.gui;

import org.frenzy.Manufacture;

public class GuiWindowParams {
    private int width;
    private int height;
    private Manufacture manufacture;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public GuiWindowParams() {
        width = 400;
        height = 300;
    }

    public GuiWindowParams(int width, int height) {
        setHeight(height);
        setHeight(width);
    }

    public  GuiWindowParams(int width, int height, Manufacture manufacture) {
        setHeight(height);
        setWidth(width);
        setManufacture(manufacture);
    }

}
