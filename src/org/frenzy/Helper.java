package org.frenzy;

import java.lang.Integer;import java.lang.String;import java.lang.System;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by artem.grechishnikov on 03.06.2015.
 */
@Deprecated
public class Helper {


    public static int quantityOfIncomingTasks;
    public static int quantityOfIterations;
    private static int volume;

    private static ArrayList<Department> arrayOfDepartments = new ArrayList<Department>();

    public static int getVolume () {
        return volume;
    }

    public static void setVolume (int vol) {
        volume = vol;
    }

    public static void createObjects (char[] newChArray) {
//        for (int i = 0; i < newChArray.length; i++) {
//            switch (newChArray[i]) {
//                case ('a'):
//                    analytics = new Analytics();
//                    arrayOfDepartments.add(analytics);
//                    break;
//                case ('b'):
//                    business = new Business();
//                    arrayOfDepartments.add(business);
//                    break;
//                case ('d'):
//                    dev = new Dev();
//                    arrayOfDepartments.add(dev);
//                    break;
//                case ('q'):
//                    qa = new Qa();
//                    arrayOfDepartments.add(qa);
//                    break;
//                default:
//                    break;
//            }
//        }
    }

    public static void createObjects () {
//        business = new Business();
//        arrayOfDepartments.add(business);
//        analytics = new Analytics();
//        arrayOfDepartments.add(analytics);
//        dev = new Dev();
//        arrayOfDepartments.add(dev);
//        qa = new Qa();
//        arrayOfDepartments.add(qa);
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
            arrayOfDepartments.get(i).setBusiness(true);
        }
    }

    private static void setHappinessAllFalse () {
//        business.setHappiness(false);
//        analytics.setHappiness(false);
//        dev.setHappiness(false);
//        qa.setHappiness(false);
    }

    private static void setFreedomAllTrue () {
//        business.setBusiness(true);
//        analytics.setBusiness(true);
//        dev.setBusiness(true);
//        qa.setBusiness(true);
    }

    private static int getTasksFinished () {
        int tasks  = (int)(Math.random()*4+1);
        return tasks;
    }

    private static void processWithDep (Department dep, int tasks) {
//        int tasksOld = dep.getTasksInProcess();
//        if (tasksOld < tasks)
//            tasks = tasksOld;
//        dep.setTasksInProcess(tasksOld - tasks);
//        if ((tasksOld-tasks) == 0)
//            dep.setBusiness(true);
//        if ((dep == business) && (arrayOfDepartments.contains(analytics)))  //Некрасиво...
//            processWithNextDep(analytics, tasks);
//        if ((dep == analytics) && (arrayOfDepartments.contains(dev)))
//            processWithNextDep(dev, tasks);
//        if ((dep == dev) && (arrayOfDepartments.contains(qa)))
//            processWithNextDep(qa, tasks);

    }

    private static void processWithNextDep (Department dep, int tasks) {
        int tasksOld = dep.getTasksInProcess();
        dep.setTasksInProcess(tasksOld + tasks);
        dep.setBusiness(false);
    }

    private static void output () {
        for (int i = 0; i < arrayOfDepartments.size(); i++) {
            Department dep = arrayOfDepartments.get(i);
            System.out.println(dep.name + " has " + dep.getTasksInProcess() + " tasks");
        }

        System.out.println("Quantity of iterations " + quantityOfIterations);
    }

    private static ArrayList<Department>  setVolumeOfArray (ArrayList<Department> arrayOfDepartments) {
        ArrayList<Department> array = new ArrayList<Department>();
        for (int i = 0; i < arrayOfDepartments.size(); i++) {
            if (!(arrayOfDepartments.get(i).getBusiness()))
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
            if (!(arrayOfDepartments.get(i).getBusiness()))
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
            if (!(business.getBusiness())) {
                processWithDep(business, tasks);
                processWithNextDep(analytics, tasks);
            }

            tasks = getTasksFinished();
            if (!(analytics.getBusiness())) {
                processWithDep(analytics, tasks);
                processWithNextDep(dev, tasks);
            }

            tasks = getTasksFinished();
            if (!(dev.getBusiness())) {
                processWithDep(dev, tasks);
                processWithNextDep(qa, tasks);
            }

            tasks = getTasksFinished();
            if (!(qa.getBusiness())) {
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
        setVolume(Integer.parseInt(input));
        quantityOfIncomingTasks = getVolume();

        System.out.println("Choose department for new task by small first letter");
        input = scan.next();

        Department dep = getDepartmentForTasks(input);
        initDepInWork(dep);

    }

    private static Department getDepartmentForTasks (String input) {
//        switch (input) {
//            case "a":
//                return analytics;
//            case "b":
//                return business;
//            case "d":
//                return dev;
//            case "q":
//                return qa;
//            default:
//                System.out.print("Wrong letter");
//                return null;
//        }
        return null;
    }

    private static void initDepInWork (Department dep) {
        if (arrayOfDepartments.contains(dep)) {
            dep.setTasksInProcess(getVolume());
            dep.setBusiness(false);
        } else System.out.println("You cannot choose " + dep.name);
    }
}
