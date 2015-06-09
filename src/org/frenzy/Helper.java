package org.frenzy;

import java.lang.Integer;import java.lang.String;import java.lang.System;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.deploy.util.StringUtils;
import org.frenzy.impl.Analytics;
import org.frenzy.impl.Business;
import org.frenzy.impl.Dev;
import org.frenzy.impl.Qa;

/**
 * Created by artem.grechishnikov on 03.06.2015.
 */
public class Helper {

    public static Department business;
    public static Department analytics;
    public static Department dev;
    public static Department qa;

    public static int quantityOfIncomingTasks;
    public static int quantityOfIterations;

    private static ArrayList<Department> arrayOfDepartments = new ArrayList<Department>();

    public static void createObjects (char[] newChArray) {
        for (int i = 0; i < newChArray.length; i++) {
            switch (newChArray[i]) {
                case ('a'):
                    analytics = new Analytics();
                    arrayOfDepartments.add(analytics);
                    break;
                case ('b'):
                    business = new Business();
                    arrayOfDepartments.add(business);
                    break;
                case ('d'):
                    dev = new Dev();
                    arrayOfDepartments.add(dev);
                    break;
                case ('q'):
                    qa = new Qa();
                    arrayOfDepartments.add(qa);
                    break;
                default:
                    break;
            }
        }
    }

    public static void createObjects () {
        business = new Business();
        arrayOfDepartments.add(business);
        analytics = new Analytics();
        arrayOfDepartments.add(analytics);
        dev = new Dev();
        arrayOfDepartments.add(dev);
        qa = new Qa();
        arrayOfDepartments.add(qa);
    }

    public static void initialisation (String deprt) {
        char[] newChArray = changeInputString(deprt);
        createObjects(newChArray);

        setHappinessAllFalse(arrayOfDepartments);
        setFreedomAllTrue(arrayOfDepartments);
    }

    public static void initialisation () {

        createObjects();
        Scanner scanner = new Scanner(System.in);
        String input = null;
        Integer quan = null;

        setHappinessAllFalse();
        setFreedomAllTrue();

        /*System.out.println("Set quantity of business-users");
        quan = Integer.parseInt(scanner.next());
        business.setUnits(quan);

        System.out.println("Set quantity of analysts");
        quan = Integer.parseInt(scanner.next());
        analytics.setUnits(quan);

        System.out.println("Set quantity of developers");
        quan = Integer.parseInt(scanner.next());
        dev.setUnits(quan);

        System.out.println("Set quantity of qa engineers");
        quan = Integer.parseInt(scanner.next());
        qa.setUnits(quan);*/
    }

    private static char[] changeInputString (String deprt) {
        deprt = deprt.trim();
        deprt = deprt.toLowerCase();
        int length = 0;
        char[] chArray = deprt.toCharArray();

        for (int i = 0; i < chArray.length; i++ ) {
            if ( (!(chArray[i] == 'a')) || (!(chArray[i] == 'b')) || (!(chArray[i] == 'd')) || (!(chArray[i] == 'q')));
                length++;
        }

        char[] newChArray = new char[length];

        for (int i = 0; i < chArray.length; i++ ) {
            if ( (!(chArray[i] == 'a')) || (!(chArray[i] == 'b')) || (!(chArray[i] == 'd')) || (!(chArray[i] == 'q')));
                newChArray[i] = chArray[i];
        }

        return newChArray;
    }

    private static void setHappinessAllFalse (ArrayList<Department> arrayOfDepartments) {
        for (int i = 0; i < arrayOfDepartments.size(); i++) {
            arrayOfDepartments.get(i).setHappiness(false);
        }
    }

    private static void setFreedomAllTrue (ArrayList<Department> arrayOfDepartments) {
        for (int i = 0; i < arrayOfDepartments.size(); i++) {
            arrayOfDepartments.get(i).setBusyness(true);
        }
    }

    private static void setHappinessAllFalse () {
        business.setHappiness(false);
        analytics.setHappiness(false);
        dev.setHappiness(false);
        qa.setHappiness(false);
    }

    private static void setFreedomAllTrue () {
        business.setBusyness(true);
        analytics.setBusyness(true);
        dev.setBusyness(true);
        qa.setBusyness(true);
    }

    private static int getTasksFinished () {
        int tasks  = (int)(Math.random()*4+1);
        return tasks;
    }

    private static void processWithDep (Department dep, int tasks) {
        int tasksOld = dep.getTasksInProcess();
        if (tasksOld < tasks)
            tasks = tasksOld;
        dep.setTasksInProcess(tasksOld - tasks);
        if ((tasksOld-tasks) == 0)
            dep.setBusyness(true);
        //TODO: fix it
        if (dep == business)                        //Эта дрянь ломает все, если отделом меньше, чем 4
            processWithNextDep(analytics, tasks);
        if (dep == analytics)
            processWithNextDep(dev, tasks);
        if (dep == dev)
            processWithNextDep(qa, tasks);

    }

    private static void processWithNextDep (Department dep, int tasks) {
        int tasksOld = dep.getTasksInProcess();
        dep.setTasksInProcess(tasksOld + tasks);
        dep.setBusyness(false);
    }

    private static void output () {
        for (int i = 0; i < arrayOfDepartments.size(); i++) {
            System.out.println(arrayOfDepartments.get(i).name + " has " + arrayOfDepartments.get(i).getTasksInProcess() + " tasks");
        }

        System.out.println("Quantity of iterations " + quantityOfIterations);
    }

    private static ArrayList<Department>  setVolumeOfArray (ArrayList<Department> arrayOfDepartments) {
        ArrayList<Department> array = new ArrayList<Department>();
        for (int i = 0; i < arrayOfDepartments.size(); i++) {
            if (!(arrayOfDepartments.get(i).getBusyness()))
                array.add(arrayOfDepartments.get(i));
        }

        return array;
    }

    public static float getFlow() {
        float flow = (float) quantityOfIncomingTasks/quantityOfIterations;
        return flow;
    }

    public static boolean checkBusyness () {
        boolean busyness = true;
        for (int i = 0; i < arrayOfDepartments.size(); i++) {
            if (!(arrayOfDepartments.get(i).getBusyness()))
                busyness = false;
        }
        return busyness;
    }

    public static void start() {
        ArrayList<Department> array;
        quantityOfIterations = 0;

        while (!(checkBusyness())) {

            quantityOfIterations++;

            output();
            array = null;
            int tasks;

            array = setVolumeOfArray(arrayOfDepartments);

            for (int i = 0; i < array.size(); i++) {
                tasks = getTasksFinished();
                processWithDep(array.get(i), tasks);
            }

            /*tasks = getTasksFinished();
            if (!(business.getBusyness())) {
                processWithDep(business, tasks);
                processWithNextDep(analytics, tasks);
            }

            tasks = getTasksFinished();
            if (!(analytics.getBusyness())) {
                processWithDep(analytics, tasks);
                processWithNextDep(dev, tasks);
            }

            tasks = getTasksFinished();
            if (!(dev.getBusyness())) {
                processWithDep(dev, tasks);
                processWithNextDep(qa, tasks);
            }

            tasks = getTasksFinished();
            if (!(qa.getBusyness())) {
                processWithDep(qa, tasks);
            }
*/
        }
    }

    public static void setTasksForDepartment () {
        Scanner scan = new Scanner(System.in);
        String input = null;

        System.out.println("Choose quantity of new tasks");
        input = scan.next();
        Main.volume = Integer.parseInt(input);
        quantityOfIncomingTasks = Main.volume;

        System.out.println("Choose department for new task by small first letter");
        input = scan.next();

        switch (input) {
            case "a":
                if (arrayOfDepartments.contains(analytics)) {
                    analytics.setTasksInProcess(Main.volume);
                    analytics.setBusyness(false);
                } else System.out.println("You cannot choose analytics");
                break;
            case "b":
                if (arrayOfDepartments.contains(business)) {
                    business.setTasksInProcess(Main.volume);
                    business.setBusyness(false);
                } else System.out.println("You cannot choose business");
                break;
            case "d":
                if (arrayOfDepartments.contains(dev)) {
                    dev.setTasksInProcess(Main.volume);
                    dev.setBusyness(false);
                } else System.out.println("You cannot choose developers");
                break;
            case "q":
                if (arrayOfDepartments.contains(qa)) {
                    qa.setTasksInProcess(Main.volume);
                    qa.setBusyness(false);
                } else System.out.println("You cannot choose qa");
                break;
            default:
                System.out.println("Wrong letter");
                break;
        }
    }
}
