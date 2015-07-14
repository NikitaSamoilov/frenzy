package org.frenzy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.frenzy.core.Context;
import org.frenzy.core.Department;
import org.frenzy.core.Manufacture;
import org.frenzy.gui.GuiWindow;
import org.frenzy.gui.GuiWindowParams;
import org.frenzy.gui.GuiWindowType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 400;

    private static ApplicationContext applicationContext;
    private static Context context;

    public static void main(String[] args) {
        initApplicationContext();
        context = new Context();
        context.add(ApplicationContext.class, applicationContext);

        Manufacture manufacture = new Manufacture();
        manufacture.addDepartment(new Department("Test Department"));
        GuiWindowParams params = new GuiWindowParams(WINDOW_WIDTH, WINDOW_HEIGHT, manufacture);
        GuiWindow guiWindow = GuiWindow.buildWindow(GuiWindowType.SIMPLE, params);
        guiWindow.setVisible(true);
    }

    private static void initApplicationContext() {
        try {
            applicationContext = new ClassPathXmlApplicationContext("FrenzyBeans.xml");
            LOGGER.info("Spring context start successfully");
        }
        catch (Exception ex) {
            LOGGER.error(ex.getStackTrace(), ex);
        }
    }
}
