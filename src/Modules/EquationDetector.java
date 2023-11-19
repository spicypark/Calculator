//THIS CLASS IS NOT IMPLEMENTED WITHIN 2.3.1 AND IS INTENDED FOR FUTURE USES

package Modules;
import java.util.Scanner;

public class EquationDetector {
    public static void main(String[] args) { //test method
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please input an equation:");
        String test = scnr.next();
        if (detectEquation(test)) System.out.println("An equation has been detected.");
        else System.out.println("Invalid equation.");
    }

    public static boolean detectEquation(String eq) {
        boolean detected = false;
        boolean continueDetecting = true;
        if (eq.length() == 1) {
            if (eq.equals("x")) return true;
            else return false;
        }
        for (int i = 0; i < eq.length(); i++) {
            if (continueDetecting) {
                Character c = eq.charAt(i);
                Character next = '%';

                if (i < eq.length() - 1) {
                    next = eq.charAt(i + 1);
                }
                
                if (!c.equals('x') && !c.equals('^') && !c.equals('+') && !c.equals('-') && !Character.isDigit(c)) {
                    continueDetecting = false;
                    continue;
                }

                if (Character.isDigit(c))  {
                    if (!Character.isDigit(next) && !next.equals('x') && !next.equals('+') && !next.equals('-') && !next.equals('^') && i != eq.length() - 1) {
                        continueDetecting = false;
                    }
                }
                else if (c.equals('x')) {
                    if (!next.equals('^') && !next.equals('+') && !next.equals('-') && i != eq.length() - 1) {
                        continueDetecting = false;
                    }
                }
                else if (c.equals('+') || c.equals('-')) {
                    if (i == eq.length() - 1) continueDetecting = false;
                    else if (!Character.isDigit(next) && !next.equals('x')) {
                        continueDetecting = false;
                    }
                }
                else if (c.equals('^')) {
                    if (i == eq.length() - 1) {
                        continueDetecting = false;
                    }
                    else if (!Character.isDigit(next)) {
                        continueDetecting = false;
                    }
                }
            }
            if ((i == eq.length() - 1) && continueDetecting) detected = true;
        }
        return detected;
    }
}