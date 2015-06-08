package org.frenzy;

import java.util.Scanner;

public class Main {

    public int daysGone = 0;

    public static void main(String[] args) {
        System.out.println("TEST RUN");
        Scanner scan = new Scanner(System.in);
        String input = null;
        int volume;

        Helper.createObjects();
        //Helper.initialisation();

        System.out.println("Choose quantity of new tasks");
        input = scan.next();
        volume = Integer.parseInt(input);

        System.out.println("Choose department for new task by small first letter");
        input = scan.next();

        switch (input) {
            case "a":
                Helper.analytics.setTasksInProcess(volume);
                Helper.analytics.setBusyness(false);
                break;
            case "b":
                Helper.business.setTasksInProcess(volume);
                Helper.business.setBusyness(false);
                break;
            case "d":
                Helper.dev.setTasksInProcess(volume);
                Helper.dev.setBusyness(false);
                break;
            case "q":
                Helper.qa.setTasksInProcess(volume);
                Helper.qa.setBusyness(false);
                break;
            default:
                System.out.println("Wrong letter");
                break;
        }

        Helper.start();
    }
}
