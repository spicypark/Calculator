//THIS CLASS IS NOT IMPLEMENTED WITHIN 2.3.1 AND IS INTENDED FOR FUTURE USES

package Modules;

public class EquationDetector {

    public static boolean detectPolynomial(String eq) {
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

    public static boolean detectArithmetic(String eq) {
        boolean detected = false;
        boolean continueDetecting = true;
        if (eq.length() <= 2) {
            return false;
        }
        for (int i = 0; i < eq.length(); i++) {
            if (continueDetecting) {
                Character c = eq.charAt(i);
                Character next = '%';

                if (i < eq.length() - 1) {
                    next = eq.charAt(i + 1);
                }
                
                if (!c.equals('/') && !c.equals('*') && !c.equals('+') && !c.equals('-') && !Character.isDigit(c)) {
                    continueDetecting = false;
                    continue;
                }

                if (Character.isDigit(c))  {
                    if (!Character.isDigit(next) && !next.equals('*') && !next.equals('+') && !next.equals('-') && !next.equals('/') && i != eq.length() - 1) {
                        continueDetecting = false;
                    }
                }
                else if (c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/')) {
                    if (c.equals('-') && i == 0 && Character.isDigit(next)) continueDetecting = true;
                    else if (i == eq.length() - 1) continueDetecting = false;
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