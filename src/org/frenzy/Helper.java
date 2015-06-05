package org.frenzy;

import java.lang.Integer;import java.lang.String;import java.lang.System;import java.util.Scanner;
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

        System.out.println("Set quantity of business-users");
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
        qa.setUnits(quan);
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
}
