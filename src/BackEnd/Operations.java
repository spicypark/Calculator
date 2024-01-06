package BackEnd;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class Operations {
    Random rand = new Random();
    NumberFormat decimal = new DecimalFormat("#0.00000");
    
    public static void main(String[] args) { //TODO test class
    }
    
    //ARITHMETIC OPERATIONS

    double fResult = 0.0;
    public double runFirstOrder(String eq) {
        
        //declare variables
        ArrayList<String> firstOperators = new ArrayList<>();
        ArrayList<Integer> firstOperatorIndexes = new ArrayList<>();
        ArrayList<Integer> negativeIndexes = new ArrayList<>();
        ArrayList<Double> fSplitArray = new ArrayList<>();
        int opIndex = 0;
        String[] splitArray = eq.split("[-\\+/\\*]");

        //add all multiplication or division signs and their order to an ArrayList
        for (int i = 0; i < eq.length(); i++) {
            Character c = eq.charAt(i);
            if (c.equals('+') || c.equals('-')) opIndex++;
            if (c.equals('*') || c.equals('/')) {
                firstOperators.add(c.toString());
                firstOperators.add("" + opIndex);
                opIndex++;
                firstOperatorIndexes.add(i);
            }
        }

        //scan the equation and record indexes of negative values
        for (int i = 0; i < eq.length(); i++) {
            Character c = 'd', before = 'd', after = 'd';
            c = eq.charAt(i);
            if (i > 0) before = eq.charAt(i - 1);
            if (i < eq.length() - 1) after = eq.charAt(i + 1);
            if (c.equals('-') && (before.equals('*') || before.equals('/')) && Character.isDigit(after)) negativeIndexes.add(i);
        }

        //take the split array without negative values and use negativeIndexes to make appropriate values negative
        for (int i = 0; i < splitArray.length; i++) {
            if (splitArray[i].equals("")) fSplitArray.add(-Double.parseDouble(splitArray[i + 1]));
            else if (i > 0 && !splitArray[i].equals("") && !splitArray[i - 1].equals("")) fSplitArray.add(Double.parseDouble(splitArray[i]));
            else if (i == 0) fSplitArray.add(Double.parseDouble(splitArray[i]));
        }

        //declare necessary variables for calculation
        double left = 0;
        double right = 0;
        double replacement = 0;
        String replacementS;

        //calculation
        if (firstOperators.size() > 0) {

            //get values to the left and to the right of operator
            if (eq.charAt(0) == '-') {
                left = fSplitArray.get(Integer.parseInt(firstOperators.get(1)) - 1);
                right = fSplitArray.get(Integer.parseInt(firstOperators.get(1)));
            }
            else {
                left = fSplitArray.get(Integer.parseInt(firstOperators.get(1)));
                right = fSplitArray.get(Integer.parseInt(firstOperators.get(1)) + 1);
            }

            //calculate the result of left and right according to the operator
            if (firstOperators.get(0).equals("*")) replacement = left * right;
            else if (firstOperators.get(0).equals("/")) replacement = left / right;
            replacementS = "" + replacement;

            //recursion to solve entire equation
            if (firstOperatorIndexes.size() > 1) eq = replacementS + eq.substring(firstOperatorIndexes.get(1));
            else {
                eq = replacementS;
                fResult = Double.parseDouble(replacementS);
                return Double.parseDouble(replacementS);
            }

            if (firstOperators.size() > 2) runFirstOrder(eq);
            else return fResult;
        }

        //return calculated result
        return fResult;
    }

    public double getFirstOrder(String eq) {return runFirstOrder(eq);}

    public ArrayList<String> splitFirstOrder(String eq) {

        //declare variables
        ArrayList<String> operands = new ArrayList<>();
        ArrayList<Integer> breaks = new ArrayList<>();
        char before;
        char current;
        boolean hasSecondOrder = false;

        //detect if equation has second order of operations
        for (int i = 0; i < eq.length(); i++) {
            if (i == 0) continue;
            else {
                before = eq.charAt(i - 1);
                current = eq.charAt(i);
            }
            if (current == '+' || (current == '-' && before != '*' && before != '/' && before != '^')) hasSecondOrder = true;
        }
        if (!hasSecondOrder) {
            operands.add(eq);
            return operands;
        }

        //add indexes of addition and subtraction
        for (int i = 0; i < eq.length(); i++) {
            if (i == 0) continue;
            else {
                before = eq.charAt(i - 1);
                current = eq.charAt(i);
            }
            if (current == '+' || (current == '-' && before != '*' && before != '/' && before != '^')) breaks.add(i);
        }

        //add individual operands based on break indexes
        for (int i = 0; i < breaks.size(); i++) {
            if (i == 0) operands.add(eq.substring(0, breaks.get(i)));
            else operands.add(eq.substring(breaks.get(i - 1), breaks.get(i)));
        }
        operands.add(eq.substring(breaks.get(breaks.size() - 1)));

        //remove add and subtract signs from the front of operands
        for (int i = 0; i < operands.size(); i++) if (operands.get(i).charAt(0) == '+' || operands.get(i).charAt(0) == '-' && i != 0) operands.set(i, operands.get(i).substring(1));

        //return properly split array
        return operands;
    }

    public double runSecondOrder(String eq) {

        //declare variables
        double result = 0;
        ArrayList<String> operands = this.splitFirstOrder(eq);
        ArrayList<Double> processedOperands = new ArrayList<>();
        ArrayList<Character> secondOperators = new ArrayList<>();

        //solve for any first order of operations terms
        if (operands.size() == 1) return this.getFirstOrder(operands.get(0));
        for (int i = 0; i < operands.size(); i++) {
            if (operands.get(i).contains("*") || operands.get(i).contains("/")) processedOperands.add(this.getFirstOrder(operands.get(i)));
            else processedOperands.add(Double.parseDouble(operands.get(i)));
        }
        
        //add second order operators in order to an ArrayList
        for (int i = 0; i < eq.length(); i++) {
            Character c = eq.charAt(i);
            Character before = '~';
            if (i == 0 && c == '-') continue;
            if (i > 0) before = eq.charAt(i - 1); 
            if (c == '+' || (c == '-' && before != '*' && before != '/')) secondOperators.add(c);
        }

        //solve for any second order of operations terms
        for (int i = 0; i < secondOperators.size(); i++) {
            double left = processedOperands.get(i);
            double right = processedOperands.get(i + 1);
            if (i == 0 && secondOperators.get(i) == '+') result = left + right;
            else if (i == 0 && secondOperators.get(i) == '-') result = left - right;
            else if (secondOperators.get(i) == '+') result += right;
            else if (secondOperators.get(i) == '-') result -= right;
        }

        //return final calculated result
        return result;
    }

    public double calculate(String eq) {return runSecondOrder(eq);}

    //GRAPHING OPERATIONS

    public void plotLine(Graphics g, String eq) {

        //trigonometric
        if (eq.equals("sinx") || eq.equals("cosx") || eq.equals("tanx")) {

            //declare variables
            int lastY = 0;

            //set color and graph y values for given x while filling any gaps and accounting for undefined areas
            g.setColor(Color.BLUE);
            lastY = this.convertY(this.calculateYTrig(-194, eq));
            for (int xVal = -194; xVal < 195; xVal++) {
                g.drawLine(this.convertX(xVal), this.convertY(this.calculateYTrig(xVal * Constants.Graphing.X_SCALE, eq)), this.convertX(xVal), lastY);
                lastY = this.convertY(this.calculateYTrig(xVal * Constants.Graphing.X_SCALE, eq));
            }
        }

        //polynomial
        else {

            //declare variables
            ArrayList<String> terms = this.splitFirstOrder(eq);
            ArrayList<Character> operators = new ArrayList<>();
            int lastY = 0;

            //add all operators to an ArrayList
            for (int i = 0; i < eq.length(); i++) {
                Character c = eq.charAt(i);
                Character before = '~';
                if (i == 0 && c == '-') continue;
                if (i > 0) before = eq.charAt(i - 1); 
                if (c == '+' || (c == '-' && before != '*' && before != '/' && before != '^')) operators.add(c);
            }

            //set color and graph y values for given x while filling any gaps and accounting for undefined areas
            g.setColor(Color.BLUE);
            for (int i = -194; i < 195; i++) {
                if (this.calculateY(i * Constants.Graphing.X_SCALE, terms, operators) != Integer.MIN_VALUE) {
                    lastY = this.convertY(this.calculateY(i * Constants.Graphing.X_SCALE, terms, operators));
                    break;
                }
                else continue;
            }
            for (int xVal = -194; xVal < 195; xVal++) {
                if (this.calculateY(xVal * Constants.Graphing.X_SCALE, terms, operators) != Integer.MIN_VALUE) {
                    g.drawLine(this.convertX(xVal), this.convertY(this.calculateY(xVal * Constants.Graphing.X_SCALE, terms, operators)), this.convertX(xVal), lastY);
                    lastY = this.convertY(this.calculateY(xVal * Constants.Graphing.X_SCALE, terms, operators));
                }
                else continue;
            }
        }
    }

    public int calculateY(double x, ArrayList<String> terms, ArrayList<Character> operators) {

        //declare variable
        double calculatedTerm = 0.0;

        //calculate
        for (int i = 0; i < terms.size(); i++) {

            //declare variables
            double gradual;
            double coeff;

            //detect if a term has certain elements and calculate accordingly
            if (terms.get(i).contains("x") && terms.get(i).indexOf("x") > 0 && terms.get(i).charAt(terms.get(i).indexOf("x") - 1) != '-') coeff = Double.parseDouble(terms.get(i).substring(0, terms.get(i).indexOf("x")));
            else if (terms.get(0).charAt(0) == '-') coeff = -1;
            else coeff = 1;
            if (terms.get(i).contains("^") && !terms.get(i).substring(terms.get(i).indexOf("^") + 1).contains("x")) gradual = Math.pow(x, Double.parseDouble(terms.get(i).substring(terms.get(i).indexOf("^") + 1)));
            else if (terms.get(i).contains("^") && terms.get(i).substring(terms.get(i).indexOf("^") + 1).contains("x")) gradual = Math.pow(x, x);
            else gradual = x;

            //add the calculated single term of the polynomial and add it to the overall result
            if (!terms.get(i).contains("x") && !terms.get(i).contains("^")) {
                if (i == 0) calculatedTerm = Double.parseDouble(terms.get(i));
                else if (operators.get(i - 1).equals('+')) calculatedTerm += Double.parseDouble(terms.get(i));
                else if (operators.get(i - 1).equals('-')) calculatedTerm -= Double.parseDouble(terms.get(i));
            }
            else {
                if (i == 0) calculatedTerm = coeff * gradual;
                else if (operators.get(i - 1).equals('+')) calculatedTerm += coeff * gradual;
                else if (operators.get(i - 1).equals('-')) calculatedTerm -= coeff * gradual;
            }
        }

        //return calculated and scaled y value for the given x value
        if (calculatedTerm != calculatedTerm) return Integer.MIN_VALUE;
        else return (int) ((calculatedTerm) * Constants.Graphing.Y_SCALE);
    }

    public int calculateYTrig(double x, String eq) {

        //declare variables
        double calculatedTerm = 0.0;

        //calculate based on trig function
        if (eq.equals("sinx")) calculatedTerm = Math.sin(x);
        else if (eq.equals("cosx")) calculatedTerm = Math.cos(x);
        //else if (eq.equals("tanx")) calculatedTerm = Math.tan(x);
        
        //return calculated and scaled y value for the given x value
        return (int) ((calculatedTerm) * Constants.Graphing.Y_SCALE);
    }

    //convert cartesian coordinates to coordinates that can be graphed on JPanel
    public int convertX(int x) {return x + Constants.Graphing.X_CENTER;}
    public int convertY(int y) {return -y + Constants.Graphing.Y_CENTER;}

    //draw the grid with axes
    public void drawPlane(Graphics g) {

        //declare variables for offsetting each gridline
        int xOffset = -190;
        int yOffset = -170;

        //set color and draw x and y lines to form grid
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 39; i++) {
            g.drawLine(Constants.Graphing.X_CENTER + xOffset, 0, Constants.Graphing.X_CENTER + xOffset, 410);
            xOffset += 10;
        }
        for (int i = 0; i < 35; i++) {
            g.drawLine(0, Constants.Graphing.Y_CENTER + yOffset, 410, Constants.Graphing.Y_CENTER + yOffset);
            yOffset += 10;
        }

        //set color and draw x and y axes
        g.setColor(Color.BLACK);
        g.drawLine(Constants.Graphing.X_CENTER, 0, Constants.Graphing.X_CENTER, 410);
        g.drawLine(0, Constants.Graphing.Y_CENTER, 410, Constants.Graphing.Y_CENTER);
    }

    //CONVERSION OPERATIONS

    public double convert(String from, String to, double num) {
        double result = 0.0;
        int table = 0;
        int fromIndex = 0;
        int toIndex = 0;

        switch (from) {
            case "centimeters": table = 1; fromIndex = 0; break;
            case "inches": table = 1; fromIndex = 1; break;
            case "meters": table = 1; fromIndex = 2; break;
            case "feet": table = 1; fromIndex = 3; break;
            case "kilometers": table = 1; fromIndex = 4; break;
            case "miles": table = 1; fromIndex = 5; break;
            case "kilograms": table = 2; fromIndex = 0; break;
            case "pounds": table = 2; fromIndex = 1; break;
            case "grams": table = 2; fromIndex = 2; break;
            case "ounces": table = 2; fromIndex = 3; break;
            case "liters": table = 3; fromIndex = 0; break;
            case "gallons": table = 3; fromIndex = 1; break;
        }
        switch (to) {
            case "centimeters": toIndex = 0; break;
            case "inches": toIndex = 1; break;
            case "meters": toIndex = 2; break;
            case "feet": toIndex = 3; break;
            case "kilometers": toIndex = 4; break;
            case "miles": toIndex = 5; break;
            case "kilograms": toIndex = 0; break;
            case "pounds": toIndex = 1; break;
            case "grams": toIndex = 2; break;
            case "ounces": toIndex = 3; break;
            case "liters": toIndex = 0; break;
            case "gallons": toIndex = 1; break;
        }
        switch (table) {
            case 1: result = num * Constants.Conversion.LENGTH_CONVERSION_TABLE[fromIndex][toIndex]; break;
            case 2: result = num * Constants.Conversion.MASS_CONVERSION_TABLE[fromIndex][toIndex]; break;
            case 3: result = num * Constants.Conversion.VOLUME_CONVERSION_TABLE[fromIndex][toIndex]; break;
        }

        return result;
    }
}