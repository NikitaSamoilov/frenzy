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

    @Deprecated
    private static void OldProcessing() {
//        Scanner scan = new Scanner(System.in);
//        Scanner scanString = new Scanner(System.in);
//        String input = null;
//
//
//        System.out.println("Would you like to choose departments?");
//        input = scan.next();
//
//        switch (input) {
//            case "n":
//                Helper.initialisation();
//                break;
//            case "y":
//                System.out.println("Which departments would you choose? (By small first letter)");
//                input = scanString.nextLine();
//                Helper.initialisation(input);
//                break;
//            default:
//                System.out.println("Wrong letter");
//                break;
//        }
//
//        Helper.setTasksForDepartment();
//        Helper.start();
//
//        System.out.println("Would you like to see common flow? (y/n)");
//        input = scan.next();
//
//        switch (input) {
//            case "y":
//                System.out.println(Helper.getFlow());
//                break;
//            default:
//                break;
//        }
    }
}
