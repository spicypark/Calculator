//THIS CLASS IS NOT IMPLEMENTED WITHIN 2.3.1 AND IS INTENDED FOR FUTURE USES

package BackEnd;

public class EquationDetector {

    public static void main(String[] args) {//TODO test class
    }

    public boolean detectPolynomial(String eq) {
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

    public boolean detectArithmetic(String eq) {
        boolean detected = false;
        boolean continueDetecting = true;
        if (eq.length() <= 2) {
            return false;
        }
        for (int i = 0; i < eq.length(); i++) {
            if (continueDetecting) {
                Character c = eq.charAt(i);
                Character next = '%';
                Character afterNext = '%';

                if (i < eq.length() - 1) {
                    next = eq.charAt(i + 1);
                }

                if (i < eq.length() - 2) {
                    afterNext = eq.charAt(i + 2);
                }
                
                if (!c.equals('/') && !c.equals('*') && !c.equals('+') && !c.equals('-') && !Character.isDigit(c) && !c.equals('.') ) {
                    continueDetecting = false;
                    continue;
                }
                else if (!eq.contains("+") && !eq.contains("-") && !eq.contains("*") && !eq.contains("/")) {
                    continueDetecting = false;
                    continue;
                }
                else if (Character.isDigit(c))  {
                    if (!Character.isDigit(next) && !next.equals('*') && !next.equals('+') && !next.equals('-') && !next.equals('/') && i != eq.length() - 1 && !next.equals('.')) {
                        continueDetecting = false;
                    }
                }
                else if (c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/')) {
                    if (c.equals('/') && (next.equals('0') || (next.equals('-') && afterNext.equals('0')))) continueDetecting = false;
                    else if ((c.equals('*') || c.equals('/')) && next.equals('-')) continueDetecting = true;
                    else if (c.equals('-') && i == 0 && Character.isDigit(next)) continueDetecting = true;
                    else if (i == eq.length() - 1) continueDetecting = false;
                    else if (!Character.isDigit(next)) {
                        continueDetecting = false;
                    }
                }
                else if (!c.equals('.')) {
                    if (!Character.isDigit(next)) continueDetecting = false;
                }
            }
            if ((i == eq.length() - 1) && continueDetecting) detected = true;
        }
        return detected;
    }
}