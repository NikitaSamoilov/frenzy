package org.frenzy;

import org.frenzy.core.Department;
import org.frenzy.core.Manufacture;
import org.frenzy.gui.GuiWindow;
import org.frenzy.gui.GuiWindowParams;
import org.frenzy.gui.GuiWindowType;

public class Main {

    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 400;

    public static void main(String[] args) {
        Manufacture manufacture = new Manufacture();
        manufacture.addDepartment(new Department("Test Department"));
        manufacture.addDepartment(new Department("Test Department2"));
        GuiWindowParams params = new GuiWindowParams(WINDOW_WIDTH, WINDOW_HEIGHT, manufacture);
        GuiWindow guiWindow = GuiWindow.buildWindow(GuiWindowType.SIMPLE, params);
        guiWindow.setVisible(true);
    }
}
