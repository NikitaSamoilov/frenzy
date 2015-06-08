package org.frenzy;

import java.lang.Integer;import java.lang.String;import java.lang.System;
import java.util.ArrayList;
import java.util.Scanner;
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

    public static void createObjects () {
        business = new Business();
        analytics = new Analytics();
        dev = new Dev();
        qa = new Qa();
    }

    public static void initialisation () {
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
        if (dep == business)                        //Некрасиво, но что поделать...
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
        System.out.println("Business has " + business.getTasksInProcess() + " tasks");
        System.out.println("Analytics has " + analytics.getTasksInProcess() + " tasks");
        System.out.println("Developers has " + dev.getTasksInProcess() + " tasks");
        System.out.println("Testers has " + qa.getTasksInProcess() + " tasks");
    }

    private static ArrayList<Department>  setVolumeOfArray (Department business, Department analytics, Department dev, Department qa) {
        ArrayList<Department> array = new ArrayList<Department>();
        if (!(business.getBusyness()))
            array.add(business);
        if (!(analytics.getBusyness()))
            array.add(analytics);
        if (!(dev.getBusyness()))
            array.add(dev);
        if (!(qa.getBusyness()))
            array.add(qa);
        return array;
    }

    public static void start() {
        ArrayList<Department> array;

        while (!(business.getBusyness()) || !(analytics.getBusyness()) || !(dev.getBusyness()) || !(qa.getBusyness())) {
            output();
            array = null;
            int tasks;

            array = setVolumeOfArray(business, analytics, dev, qa);

            for (int i = 0; i < array.size(); i++) {
                tasks = getTasksFinished();
                //System.out.println(array.get(i).getName() + " has " + array.get(i).getTasksInProcess() + " tasks");
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
}
