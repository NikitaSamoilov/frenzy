package org.frenzy;

import org.frenzy.gui.GuiWindow;
import org.frenzy.gui.GuiWindowParams;
import org.frenzy.gui.GuiWindowType;

import java.util.Scanner;

public class Main {

    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 400;

    public static void main(String[] args) {
        GuiWindowParams params = new GuiWindowParams(WINDOW_WIDTH, WINDOW_HEIGHT, new Manufacture());
        GuiWindow guiWindow = GuiWindow.buildWindow(GuiWindowType.SIMPLE, params);
        guiWindow.setVisible(true);
    }
}
