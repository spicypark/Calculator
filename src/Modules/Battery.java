package Modules;
import java.util.Scanner;

public class Battery {
    Scanner scnr = new Scanner(System.in);
    private boolean continueUsing = false;
    private int useInstance = 0;
    private int batteryLimit = 10; // set battery limit

    public boolean continueUse() {
        String continueInput;
        System.out.println("\nContinue using calculator? (y/n)");
        continueInput = scnr.next();

        if (!continueInput.equals("y") && !continueInput.equals("n")) {
            System.out.println("Invalid option.");
            continueUse();
        }

        if (continueInput.equals("y")) {
            continueUsing = true;
        }

        else if (continueInput.equals("n")) {
            System.out.println("\nThank you for using this program.");
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
        if (useInstance == batteryLimit) {System.out.println("\nBATTERY IS DEAD");}
        return useInstance;
    }
}