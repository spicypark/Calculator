package BackEnd;
import java.util.Scanner;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class Operations {
    Scanner scnr = new Scanner(System.in);
    Random rand = new Random();
    NumberFormat decimal = new DecimalFormat("#0.00000");
    double result = 0;

    //ARITHMETIC OPERATIONS

    public static void main(String[] args) { //TODO test class
        //System.out.println("FINAL SOLUTION " + getFirstOrder("5*4*4*3/2.5/32.4224"));//*6/2+2
        //double bruh = calculate("-3+5/54/-35*2+4/3+4*2-1");
        // ArrayList<String> bruh2 = splitFirstOrder("-3.54x^-2.42+5.1x-45.424");
        // for (int i = 0; i < bruh2.size(); i++) {
        //     System.out.println(bruh2.get(i));
        // }
        ArrayList<String> testTerms = new ArrayList<>();
        testTerms.add("3x^2");
        testTerms.add("4x");
        testTerms.add("13");
        ArrayList<Character> testOperators = new ArrayList<>();
        testOperators.add('+');
        testOperators.add('+');
        System.out.println("RESULT IS " + calculateY(10, testTerms, testOperators));
    }

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
            if (i > 0)
                before = eq.charAt(i - 1);
            if (i < eq.length() - 1)
                after = eq.charAt(i + 1);
            if (c.equals('-') && (before.equals('*') || before.equals('/')) && Character.isDigit(after)) {
                negativeIndexes.add(i);
            }
        }

        //take the split array without negative values and use negativeIndexes to make appropriate values negative
        for (int i = 0; i < splitArray.length; i++) {
            if (splitArray[i].equals("")) fSplitArray.add(-Double.parseDouble(splitArray[i + 1]));
            else if (i > 0 && !splitArray[i].equals("") && !splitArray[i - 1].equals("")) fSplitArray.add(Double.parseDouble(splitArray[i]));
            else if (i == 0) fSplitArray.add(Double.parseDouble(splitArray[i]));
        }

        for (int i = 0; i < fSplitArray.size(); i++) System.out.println(fSplitArray.get(i));//TODO test
        for (int i = 0; i < firstOperators.size(); i++) System.out.println(firstOperators.get(i));//TODO test

        //declare necessary variables for calculation
        double left = 0;
        double right = 0;
        double replacement = 0;
        String replacementS;
        String leftS;

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
            leftS = "" + left;

            System.out.println("Left: " + left);//TODO test
            System.out.println("Right: " + right);//TODO test
            System.out.println("LeftS: " + leftS);//TODO test

            //calculate the result of left and right according to the operator
            if (firstOperators.get(0).equals("*")) replacement = left * right;
            else if (firstOperators.get(0).equals("/")) replacement = left / right;
            replacementS = "" + replacement;
            System.out.println("REP: " + replacementS);//TODO test

            //recursion to solve entire equation
            if (firstOperatorIndexes.size() > 1) {
                System.out.println(eq.indexOf(leftS));//TODO test
                System.out.println(firstOperatorIndexes.get(1));//TODO test
                eq = replacementS + eq.substring(firstOperatorIndexes.get(1));//eq.substring(0, eq.indexOf(leftS)) + 
            }
            else {
                System.out.println("solution found is " + replacementS);//TODO test
                eq = replacementS;
                result = Double.parseDouble(eq);
                return Double.parseDouble(replacementS);
            }

            System.out.println("LEFTS " + leftS);//TODO test
            System.out.println(eq);//TODO test

            if (firstOperators.size() > 2) runFirstOrder(eq);
        }
        System.out.println("AAAAAAAAAAAA " + result);//TODO test

        //return calculated result
        return result;
    }

    public double getFirstOrder(String eq) {
        return runFirstOrder(eq);
    }

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
            if (current == '+' || (current == '-' && before != '*' && before != '/')) hasSecondOrder = true;
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
        System.out.println("BREAKS SIZE " + breaks.size());
        for (int i = 0; i < breaks.size(); i++) System.out.println(breaks.get(i));
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

    public double calculate(String eq) {
        return runSecondOrder(eq);
    }

    //GRAPHING OPERATIONS

    public void testMethod(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawLine(34, 146, 51, 10);
    }

    public void plotLine(Graphics g, String eq) {
        ArrayList<String> terms = this.splitFirstOrder(eq);
        ArrayList<Character> operators = new ArrayList<>();
        for (int i = 0; i < eq.length(); i++) {
            Character c = eq.charAt(i);
            Character before = '~';
            if (i == 0 && c == '-') continue;
            if (i > 0) before = eq.charAt(i - 1); 
            if (c == '+' || (c == '-' && before != '*' && before != '/' && before != '^')) operators.add(c);
        }

        g.setColor(Color.BLUE);
        for (int xVal = -194; xVal < 195; xVal++) {
            g.drawLine(this.convertX(xVal), this.convertY(this.calculateY(xVal * Constants.Graphing.X_SCALE, terms, operators)), this.convertX(xVal), this.convertY(this.calculateY(xVal * Constants.Graphing.X_SCALE, terms, operators)));
        }
    }

    public static int calculateY(double x, ArrayList<String> terms, ArrayList<Character> operators) {//TODO unstatic this
        double calculatedTerm = 0.0;
        for (int i = 0; i < terms.size(); i++) {
            double gradual;
            double coeff;
            if (terms.get(i).contains("x") && terms.get(i).indexOf("x") > 0) coeff = Double.parseDouble(terms.get(i).substring(0, terms.get(i).indexOf("x")));
            else coeff = 1;
            if (terms.get(i).contains("^")) {
                gradual = Math.pow(x, Double.parseDouble(terms.get(i).substring(terms.get(i).indexOf("^") + 1)));
            }
            else gradual = x;
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
        System.out.println("for x value " + x + " y is " + ((int) (calculatedTerm + 0.5)));
        // System.out.println("same thing but scaled is " + (((int) (calculatedTerm + 0.5)) * Constants.Graphing.SCALE));
        return (int) ((calculatedTerm) * Constants.Graphing.Y_SCALE);
        // return (int) (calculatedTerm + 0.5);
    }

    public int convertX(int x) {return x + Constants.Graphing.X_CENTER;}
    public int convertY(int y) {return -y + Constants.Graphing.Y_CENTER;}

    public void drawPlane(Graphics g) {
        int xOffset = -190;
        int yOffset = -170;

        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 39; i++) {
            g.drawLine(Constants.Graphing.X_CENTER + xOffset, 0, Constants.Graphing.X_CENTER + xOffset, 410);
            xOffset += 10;
        }
        for (int i = 0; i < 35; i++) {
            g.drawLine(0, Constants.Graphing.Y_CENTER + yOffset, 410, Constants.Graphing.Y_CENTER + yOffset);
            yOffset += 10;
        }

        g.setColor(Color.BLACK);
        g.drawLine(Constants.Graphing.X_CENTER, 0, Constants.Graphing.X_CENTER, 410);
        g.drawLine(0, Constants.Graphing.Y_CENTER, 410, Constants.Graphing.Y_CENTER);
    }

    // public double runCircleArea(double[] inputArray) {
    //     double cAreaResult = inputArray[0] * inputArray[0] * Math.PI;
    //     return cAreaResult;
    // }

    // public double runCircleCircumference(double[] inputArray) {
    //     double cCircumferenceResult = inputArray[0] * Math.PI * 2;
    //     return cCircumferenceResult;
    // }

    // public double runSphereSurface(double[] inputArray) {
    //     double sSurfaceResult = inputArray[0] * inputArray[0] * Math.PI * 4;
    //     return sSurfaceResult;
    // }

    // public double runSphereVolume(double[] inputArray) {
    //     double sVolumeResult = (inputArray[0] * inputArray[0] * inputArray[0] * Math.PI * 4) / 3;
    //     return sVolumeResult;
    // }

    //CONVERSION OPERATIONS

//     public double runCentimeterInch(int operation, double[] userArray) {
//         double result = 0;
//         if (operation == 2) {result = userArray[0] * 0.393701;}
//         else {result = userArray[0] * 2.54;}
//         return result;
//     }

//     public double runMeterFoot(int operation, double[] userArray) {
//         double result = 0;
//         if (operation == 2) {result = userArray[0] * 3.28084;}
//         else {result = userArray[0] * 0.3048;}
//         return result;
//     }

//     public double runKilometerMile(int operation, double[] userArray) {
//         double result = 0;
//         if (operation == 2) {result = userArray[0] * 0.621371;}
//         else {result = userArray[0] * 1.60934;}
//         return result;
//     }

//     public double runKilogramPound(int operation, double[] userArray) {
//         double result = 0;
//         if (operation == 2) {result = userArray[0] * 2.20462;}
//         else {result = userArray[0] * 0.453592;}
//         return result;
//     }

//     public double runGramOunce(int operation, double[] userArray) {
//         double result = 0;
//         if (operation == 2) {result = userArray[0] * 0.035274;}
//         else {result = userArray[0] * 28.3495;}
//         return result;
//     }

//     public double runLiterGallon(int operation, double[] userArray) {
//         double result = 0;
//         if (operation == 2) {result = userArray[0] * 0.264172;}
//         else {result = userArray[0] * 3.78541;}
//         return result;
//     }

//     //RANDOM OPERATIONS

//     public double randomNumGen(int numoperands) {
//         double result = rand.nextInt(numoperands + 1);
//         return result;
//     }

//     public ArrayList<String> RSS(ArrayList<String> s) {
//         String temp;
//         int randNum;
//         for (int i = 0; i < s.size(); i++) {
//             randNum = rand.nextInt(s.size());
//             temp = s.get(i);
//             s.set(i, s.get(randNum));
//             s.set(randNum, temp);
//         }
//         return s;
//     }
}