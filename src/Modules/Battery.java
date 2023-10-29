package Modules;
import java.util.Scanner;

public class Battery {
    Scanner scnr = new Scanner(System.in);
    private boolean continueUsing = false;
    private int useInstance = 0;
    private int batteryLimit = 10; // set battery limit

    public boolean continueUse() {
        String continueInput;
        System.out.println("");
        System.out.println("Continue using calculator? (y/n)");
        continueInput = scnr.next();

        if (continueInput.equals("y")) {
            continueUsing = true;
        }

        else if (continueInput.equals("n")) {
            System.out.println("");
            System.out.println("Thank you for using this program.");
            continueUsing = false;
        }

        return continueUsing;
    }

    public int increaseInstance() {
        useInstance += 1;
        return useInstance;
    }

    public int getBatteryLimit() {
        return batteryLimit;
    }

    public int getInstance() {
        if (useInstance == batteryLimit) {
            System.out.println("");
            System.out.println("BATTERY IS DEAD");
        }
        return useInstance;
    }
}