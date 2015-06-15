package org.frenzy.gui;

import org.frenzy.Manufacture;

import java.awt.*;

public interface ManufactureDisplayer {
    Manufacture getManufacture();
    void setManufacture(Manufacture manufacture);
    void setBounds(int left, int top, int width, int height);
    Component getComponent();
    void update();
}
