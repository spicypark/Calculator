package backend;

public class Detector {
    private static Detector instance = null;

    public boolean detectPolynomial(String eq) {
        boolean detected = false;
        boolean continueDetecting = true;
        boolean hasDecimal = false;
        boolean hasExponent = false;
        if (eq.length() == 1) {
            if (eq.equals("x") || Character.isDigit(eq.charAt(0))) return true;
            else return false;
        }
        if (eq.equals("sinx") || eq.equals("cosx") || eq.equals("tanx")) return true;
        for (int i = 0; i < eq.length(); i++) {
            if (continueDetecting) {
                Character c = eq.charAt(i);
                Character next = '%';

                if (i < eq.length() - 1) next = eq.charAt(i + 1);
                
                if (!c.equals('x') && !c.equals('^') && !c.equals('+') && !c.equals('-') && !c.equals('.') && !Character.isDigit(c)) {
                    continueDetecting = false;
                    continue;
                }

                if (Character.isDigit(c)) {
                    if (!Character.isDigit(next) && !next.equals('x') && !next.equals('+') && !next.equals('-') && !next.equals('^') && !next.equals('.') && i != eq.length() - 1) continueDetecting = false;
                    if (next.equals('^')) continueDetecting = false;
                }
                else if (c.equals('x')) {
                    if (!next.equals('^') && !next.equals('+') && !next.equals('-') && i != eq.length() - 1) continueDetecting = false;
                    if (next.equals('x') || Character.isDigit(next)) continueDetecting = false;
                    if (hasExponent && eq.charAt(i - 1) != '^') continueDetecting = false;
                }
                else if (c.equals('+') || c.equals('-')) {
                    if (i == eq.length() - 1) continueDetecting = false;
                    else if (!Character.isDigit(next) && !next.equals('x')) continueDetecting = false;
                    hasDecimal = false;
                    hasExponent = false;
                }
                else if (c.equals('^')) {
                    if (i == eq.length() - 1) continueDetecting = false;
                    else if (!Character.isDigit(next) && !next.equals('-') && !next.equals('x')) continueDetecting = false;
                    if (hasExponent) continueDetecting = false;
                    hasDecimal = false;
                    hasExponent = true;
                }
                else if (c.equals('.')) {
                    if (hasDecimal) continueDetecting = false;
                    else hasDecimal = true;
                    if (!Character.isDigit(next)) continueDetecting = false;
                }
            }
            if ((i == eq.length() - 1) && continueDetecting) detected = true;
        }
        return detected;
    }

    public boolean detectArithmetic(String eq) {
        boolean detected = false;
        boolean continueDetecting = true;
        boolean hasDecimal = false;
        if (eq.length() <= 2) return false;
        for (int i = 0; i < eq.length(); i++) {
            if (continueDetecting) {
                Character c = eq.charAt(i);
                Character next = '%';
                Character afterNext = '%';
                Character afterAfterNext = '%';

                if (i < eq.length() - 1) next = eq.charAt(i + 1);
                if (i < eq.length() - 2) afterNext = eq.charAt(i + 2);
                if (i < eq.length() - 3) afterAfterNext = eq.charAt(i + 3);
                
                if (!c.equals('/') && !c.equals('*') && !c.equals('+') && !c.equals('-') && !Character.isDigit(c) && !c.equals('.') ) {
                    continueDetecting = false;
                    continue;
                }
                else if (!eq.contains("+") && !eq.contains("-") && !eq.contains("*") && !eq.contains("/")) {
                    continueDetecting = false;
                    continue;
                }
                else if (i == 0 && (c.equals('*') || c.equals('+') || c.equals('/'))) continueDetecting = false;
                else if (Character.isDigit(c)) {if (!Character.isDigit(next) && !next.equals('*') && !next.equals('+') && !next.equals('-') && !next.equals('/') && i != eq.length() - 1 && !next.equals('.')) continueDetecting = false;}
                else if (c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/')) {
                    if (c.equals('/') && ((next.equals('0') && Character.isDigit(afterNext)) || (next.equals('-') && afterNext.equals('0') && Character.isDigit(afterAfterNext)))) continueDetecting = true;
                    else if (c.equals('/') && (next.equals('0') || (next.equals('-') && afterNext.equals('0')))) continueDetecting = false;
                    else if ((c.equals('*') || c.equals('/')) && next.equals('-')) continueDetecting = true;
                    else if (c.equals('-') && i == 0 && Character.isDigit(next)) continueDetecting = true;  
                    else if (i == eq.length() - 1) continueDetecting = false;
                    else if (!Character.isDigit(next)) continueDetecting = false;
                    hasDecimal = false;
                }
                else if (c.equals('.')) {
                    if (next.equals('.')) continueDetecting = false;
                    else if (hasDecimal) continueDetecting = false;
                    else hasDecimal = true;
                }
            }
            if ((i == eq.length() - 1) && continueDetecting) detected = true;
        }
        return detected;
    }

    public boolean detectDouble(String num) {
        try {Double.parseDouble(num);}
        catch (NumberFormatException e) {return false;}
        return true;
    }

    public boolean detectPosInt(String num) {
        try {Integer.parseInt(num);}
        catch (NumberFormatException e) {return false;}
        if (Integer.parseInt(num) > 0) return true;
        return false;
    }

    public boolean detectConversion(String from, String to) {
        String[] units = {"units", "centimeters", "inches", "meters", "feet", "kilometers", "miles", "kilograms", "pounds", "grams", "ounces", "liters", "gallons"};

        if (from.equals(units[0]) || to.equals(units[0])) return false;
        if ((from.equals(units[1]) || from.equals(units[2]) || from.equals(units[3]) || from.equals(units[4]) || from.equals(units[5]) || from.equals(units[6])) && (!to.equals(units[1]) && !to.equals(units[2]) && !to.equals(units[3]) && !to.equals(units[4]) && !to.equals(units[5]) && !to.equals(units[6]))) return false;
        if ((from.equals(units[7]) || from.equals(units[8]) || from.equals(units[9]) || from.equals(units[10])) && (!to.equals(units[7]) && !to.equals(units[8]) && !to.equals(units[9]) && !to.equals(units[10]))) return false;
        if ((from.equals(units[11]) || from.equals(units[12])) && (!to.equals(units[11]) && !to.equals(units[12]))) return false;

        return true;
    }

    public static Detector getInstance() {
        if (instance == null) instance = new Detector();
        return instance;
    }
}