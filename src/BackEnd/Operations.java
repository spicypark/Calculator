package BackEnd;
import java.util.Scanner;
import java.awt.*;
import java.awt.Graphics;
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

    public void main(String[] args) { //TODO test class
        //System.out.println("FINAL SOLUTION " + getFirstOrder("5*4*4*3/2.5/32.4224"));//*6/2+2
        //double bruh = calculate("-3+5/54/-35*2+4/3+4*2-1");
        double bruh2 = calculate("5.4+3.5*61-56.2314+4+3/5*40");
        System.out.println("FINAL RESULT " + bruh2);
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
            if (current == '+' || (current == '-' && before != '*' && before != '/')) breaks.add(i);
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
            if (c == '+' || (c == '-' && before != '*' && before != '/')) secondOperators.add(c);//-34*1.13/-23+5.5-3.134/524*-2
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

    public void drawPlane(Graphics g) {
        int xCenter = 194;
        int yCenter = 171;
        
        g.setColor(Color.LIGHT_GRAY);

        g.drawLine(xCenter + 10, 0, xCenter + 10, 410);
        g.drawLine(xCenter + 20, 0, xCenter + 20, 410);
        g.drawLine(xCenter + 30, 0, xCenter + 30, 410);
        g.drawLine(xCenter + 40, 0, xCenter + 40, 410);
        g.drawLine(xCenter + 50, 0, xCenter + 50, 410);
        g.drawLine(xCenter + 60, 0, xCenter + 60, 410);
        g.drawLine(xCenter + 70, 0, xCenter + 70, 410);
        g.drawLine(xCenter + 80, 0, xCenter + 80, 410);
        g.drawLine(xCenter + 90, 0, xCenter + 90, 410);
        g.drawLine(xCenter + 100, 0, xCenter + 100, 410);
        g.drawLine(xCenter + 110, 0, xCenter + 110, 410);
        g.drawLine(xCenter + 120, 0, xCenter + 120, 410);
        g.drawLine(xCenter + 130, 0, xCenter + 130, 410);
        g.drawLine(xCenter + 140, 0, xCenter + 140, 410);
        g.drawLine(xCenter + 150, 0, xCenter + 150, 410);
        g.drawLine(xCenter + 160, 0, xCenter + 160, 410);
        g.drawLine(xCenter + 170, 0, xCenter + 170, 410);
        g.drawLine(xCenter + 180, 0, xCenter + 180, 410);
        g.drawLine(xCenter + 190, 0, xCenter + 190, 410);
        g.drawLine(xCenter + 200, 0, xCenter + 200, 410);

        g.drawLine(xCenter - 10, 0, xCenter - 10, 410);
        g.drawLine(xCenter - 20, 0, xCenter - 20, 410);
        g.drawLine(xCenter - 30, 0, xCenter - 30, 410);
        g.drawLine(xCenter - 40, 0, xCenter - 40, 410);
        g.drawLine(xCenter - 50, 0, xCenter - 50, 410);
        g.drawLine(xCenter - 60, 0, xCenter - 60, 410);
        g.drawLine(xCenter - 70, 0, xCenter - 70, 410);
        g.drawLine(xCenter - 80, 0, xCenter - 80, 410);
        g.drawLine(xCenter - 90, 0, xCenter - 90, 410);
        g.drawLine(xCenter - 100, 0, xCenter - 100, 410);
        g.drawLine(xCenter - 110, 0, xCenter - 110, 410);
        g.drawLine(xCenter - 120, 0, xCenter - 120, 410);
        g.drawLine(xCenter - 130, 0, xCenter - 130, 410);
        g.drawLine(xCenter - 140, 0, xCenter - 140, 410);
        g.drawLine(xCenter - 150, 0, xCenter - 150, 410);
        g.drawLine(xCenter - 160, 0, xCenter - 160, 410);
        g.drawLine(xCenter - 170, 0, xCenter - 170, 410);
        g.drawLine(xCenter - 180, 0, xCenter - 180, 410);
        g.drawLine(xCenter - 190, 0, xCenter - 190, 410);
        g.drawLine(xCenter - 200, 0, xCenter - 200, 410);

        g.drawLine(0, yCenter + 10, 410, yCenter + 10);
        g.drawLine(0, yCenter + 20, 410, yCenter + 20);
        g.drawLine(0, yCenter + 30, 410, yCenter + 30);
        g.drawLine(0, yCenter + 40, 410, yCenter + 40);
        g.drawLine(0, yCenter + 50, 410, yCenter + 50);
        g.drawLine(0, yCenter + 60, 410, yCenter + 60);
        g.drawLine(0, yCenter + 70, 410, yCenter + 70);
        g.drawLine(0, yCenter + 80, 410, yCenter + 80);
        g.drawLine(0, yCenter + 90, 410, yCenter + 90);
        g.drawLine(0, yCenter + 100, 410, yCenter + 100);
        g.drawLine(0, yCenter + 110, 410, yCenter + 110);
        g.drawLine(0, yCenter + 120, 410, yCenter + 120);
        g.drawLine(0, yCenter + 130, 410, yCenter + 130);
        g.drawLine(0, yCenter + 140, 410, yCenter + 140);
        g.drawLine(0, yCenter + 150, 410, yCenter + 150);
        g.drawLine(0, yCenter + 160, 410, yCenter + 160);
        g.drawLine(0, yCenter + 170, 410, yCenter + 170);
        g.drawLine(0, yCenter + 180, 410, yCenter + 180);
        g.drawLine(0, yCenter + 190, 410, yCenter + 190);
        g.drawLine(0, yCenter + 200, 410, yCenter + 200);
  
        g.drawLine(0, yCenter - 10, 410, yCenter - 10);
        g.drawLine(0, yCenter - 20, 410, yCenter - 20);
        g.drawLine(0, yCenter - 30, 410, yCenter - 30);
        g.drawLine(0, yCenter - 40, 410, yCenter - 40);
        g.drawLine(0, yCenter - 50, 410, yCenter - 50);
        g.drawLine(0, yCenter - 60, 410, yCenter - 60);
        g.drawLine(0, yCenter - 70, 410, yCenter - 70);
        g.drawLine(0, yCenter - 80, 410, yCenter - 80);
        g.drawLine(0, yCenter - 90, 410, yCenter - 90);
        g.drawLine(0, yCenter - 100, 410, yCenter - 100);
        g.drawLine(0, yCenter - 110, 410, yCenter - 110);
        g.drawLine(0, yCenter - 120, 410, yCenter - 120);
        g.drawLine(0, yCenter - 130, 410, yCenter - 130);
        g.drawLine(0, yCenter - 140, 410, yCenter - 140);
        g.drawLine(0, yCenter - 150, 410, yCenter - 150);
        g.drawLine(0, yCenter - 160, 410, yCenter - 160);
        g.drawLine(0, yCenter - 170, 410, yCenter - 170);
        g.drawLine(0, yCenter - 180, 410, yCenter - 180);
        g.drawLine(0, yCenter - 190, 410, yCenter - 190);
        g.drawLine(0, yCenter - 200, 410, yCenter - 200);

        g.setColor(Color.BLACK);

        g.drawLine(xCenter, 0, xCenter, 410);
        g.drawLine(0, yCenter, 410, yCenter);
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

    //GRAPHING OPERATIONS

    // public String[] [] runGraphFunction(int userGraphOp, String[] [] userPlane) {
    //     // WHEN I KEEP SAYING THAT THIS PROGRAM MAY BE REDUNDANT, PROBABLY 90% OF THOSE REDUNDANCIES ARE IN THIS METHOD
    //     double userX;
    //     double userY;

    //     if (userGraphOp == 1) {
    //         System.out.println("\nPlease input slope and y-intercept:");
    //         double userSlope = input.getUserDouble(scnr);
    //         double userYInt = input.getUserDouble(scnr);

    //         for (int j = 0; j < 31; j++) {

    //             userX = j;
    //             userY = ((j - 15) * -userSlope) - userYInt;

    //             if ((int)userY + 15 < 0 || (int)userY + 15 > 31) {
    //                 userPlane[15][j] = "- ";
    //             }

    //             else if (userY + 15 >=0 && userY + 15 < 31) {
    //                 userPlane[(int)userY + 15][(int)userX] = "■ ";
    //             }
    //         }
    //     }
        
    //     else if (userGraphOp == 2) {
    //         System.out.println("\nPlease input a, b, and c values:");
    //         double aValQ = input.getUserDouble(scnr);
    //         System.out.println(aValQ);
    //         double bValQ = input.getUserDouble(scnr);
    //         System.out.println(bValQ);
    //         double cValQ = input.getUserDouble(scnr);
    //         System.out.println(cValQ);

    //         for (int k = 0; k < 31; k++) {

    //             userX = k;
    //             userY = ((k - 15) * (k - 15) * -aValQ) - (bValQ * (k - 15)) - cValQ;

    //             if ((int)userY + 15 < 0 || (int)userY + 15 > 31) {
    //                 userPlane[15][k] = "- ";
    //             }

    //             else if (userY + 15 >=0 && userY + 15 < 31) {
    //                 userPlane[(int)userY + 15][(int)userX] = "■ ";
    //             }
    //         }
    //     }

    //     else if (userGraphOp == 3) {
    //         System.out.println("\nPlease input a, b, c, and d values:");
    //         double aValC = input.getUserDouble(scnr);
    //         double bValC = input.getUserDouble(scnr);
    //         double cValC = input.getUserDouble(scnr);
    //         double dValC = input.getUserDouble(scnr);

    //         for (int k = 0; k < 31; k++) {

    //             userX = k;
    //             userY = ((k - 15) * (k - 15) * (k - 15) * -aValC) - ((k - 15) * (k - 15) * -bValC) - (cValC * (k - 15)) - dValC;

    //             if ((int)userY + 15 < 0 || (int)userY + 15 > 31) {
    //                 userPlane[15][k] = "- ";
    //             }

    //             else if (userY + 15 >=0 && userY + 15 < 31) {
    //                 userPlane[(int)userY + 15][(int)userX] = "■ ";
    //             }
    //         }
    //     }

    //     else if (userGraphOp == 4) {
    //         System.out.println("\nPlease input a value:");
    //         double aValE = input.getUserDouble(scnr);

    //         for (int k = 0; k < 31; k++) {
    //             userX = k;
    //             userY = 1;
    //             double tempUserX = userX - 15.0;

    //             if (tempUserX < 0) {
    //                 double negDenom = 1;
    //                 for (int l = 0; l < (tempUserX * -1) ; l++) {
    //                     negDenom *= aValE;
    //                 }

    //                 userY = (1 / negDenom) * -1.0;
    //             }

    //             else if (tempUserX == 0) {
    //                 userY = -1.0;
    //             }

    //             else if (tempUserX > 0) {
    //                 double userYE = 1;
    //                 for (int l = 0; l < tempUserX; l++) {
    //                     userYE *= aValE;
    //                 }
    //                 userY = userYE * -1.0;
    //             }

    //             if ((int)userY + 15 < 0 || (int)userY + 15 > 31) {
    //                 userPlane[15][k] = "- ";
    //             }

    //             else if (userY + 15 >=0 && userY + 15 < 31) {
    //                 userPlane[(int)userY + 15][(int)userX] = "■ ";
    //             }
    //         }
    //     }
        
    //     return userPlane;
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