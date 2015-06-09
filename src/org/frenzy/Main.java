package org.frenzy;

import java.util.Scanner;

public class Main {

    public static int volume;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);
        String input = null;


        System.out.println("Would you like to choose departments?");
        input = scan.next();

        switch (input) {
            case "n":
                Helper.initialisation();
                break;
            case "y":
                System.out.println("Which departments would you choose? (By small first letter)");
                input = scanString.nextLine();
                Helper.initialisation(input);
                break;
            default:
                System.out.println("Wrong letter");
                break;
        }

        Helper.setTasksForDepartment();
        Helper.start();

        System.out.println("Would you like to see common flow? (y/n)");
        input = scan.next();

        switch (input) {
            case "y":
                System.out.println(Helper.getFlow());
                break;
            default:
                break;
        }

    }
}
