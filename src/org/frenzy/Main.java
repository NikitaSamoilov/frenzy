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
        Helper.initialisation();

        System.out.println("Choose volume of new task");
        input = scan.next();
        volume = Integer.parseInt(input);

        System.out.println("Choose department for new task by small first letter");
        input = scan.next();

        switch (input) {
            case "a": Helper.analytics.setTasksInProcess(volume);
                break;
            case "b": Helper.business.setTasksInProcess(volume);
                break;
            case "d": Helper.dev.setTasksInProcess(volume);
                break;
            case "q": Helper.qa.setTasksInProcess(volume);
                break;
            default: System.out.println("Wrong letter");
                break;
        }
    }
}
