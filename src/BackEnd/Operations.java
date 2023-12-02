package BackEnd;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class Operations {
    Scanner scnr = new Scanner(System.in);
    Random rand = new Random();
    NumberFormat decimal = new DecimalFormat("#0.00000");
    double result;

    //ARITHMETIC OPERATIONS

    // public static void main(String[] args) {//TODO test class
        
    // }

    public void runArithmetic(String eq) {
        ArrayList<String> firstOperators = new ArrayList<>();
        ArrayList<String> secondOperators = new ArrayList<>();
        ArrayList<Integer> firstOperatorIndexes = new ArrayList<>();
        ArrayList<Integer> secondOperatorIndexes = new ArrayList<>();
        ArrayList<Integer> negativeIndexes = new ArrayList<>();
        ArrayList<Double> fSplitArray = new ArrayList<>();
        int opIndex = 0;
        String[] splitArray = eq.split("[-\\+/\\*]");

        for (int i = 0; i < eq.length(); i++) {
            Character c = eq.charAt(i);
            if (c.equals('+') || c.equals('-')) {
                firstOperators.add(c.toString());
                firstOperators.add("" + opIndex);
                opIndex++;
                firstOperatorIndexes.add(i);
            }
            else if (c.equals('*') || c.equals('/')) {
                secondOperators.add(c.toString());
                secondOperators.add("" + opIndex);
                opIndex++;
                secondOperatorIndexes.add(i);
            }
        }

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

        for (int i = 0; i < splitArray.length; i++) {
            if (splitArray[i].equals("")) fSplitArray.add(-Double.parseDouble(splitArray[i + 1]));
            else if (i > 0 && !splitArray[i].equals("") && !splitArray[i - 1].equals("")) fSplitArray.add(Double.parseDouble(splitArray[i]));
            else if (i == 0) fSplitArray.add(Double.parseDouble(splitArray[i]));
        }

        for (int i = 0; i < fSplitArray.size(); i++) System.out.println(fSplitArray.get(i));
        for (int i = 0; i < secondOperators.size(); i++) System.out.println(secondOperators.get(i));

        double left = 0;
        double right = 0;
        double replacement = 0;
        String replacementS;
        String leftS;

        if (secondOperators.size() > 0) {
            if (eq.charAt(0) == '-') {
                left = fSplitArray.get(Integer.parseInt(secondOperators.get(1)) - 1);
                right = fSplitArray.get(Integer.parseInt(secondOperators.get(1)));
            }
            else {
                left = fSplitArray.get(Integer.parseInt(secondOperators.get(1)));
                right = fSplitArray.get(Integer.parseInt(secondOperators.get(1)) + 1);
            }
            //leftS = splitArray[Integer.parseInt(secondOperators.get(1))];
            leftS = "" + left;

            System.out.println("Left: " + left);
            System.out.println("Right: " + right);
            System.out.println("LeftS: " + leftS);

            if (secondOperators.get(0).equals("*")) replacement = left * right;
            else if (secondOperators.get(0).equals("/")) replacement = left / right;
            replacementS = "" + replacement;
            System.out.println("REP: " + replacementS);

            if (secondOperatorIndexes.size() > 1) {
                System.out.println(eq.indexOf(leftS));
                System.out.println(secondOperatorIndexes.get(1));
                eq = replacementS + eq.substring(secondOperatorIndexes.get(1));//eq.substring(0, eq.indexOf(leftS)) + 
            }
            else {
                System.out.println("solution found is " + replacementS);
                eq = replacementS;
                result = Double.parseDouble(eq);
            }
            System.out.println("LEFTS " + leftS);
            System.out.println(eq);

            if (secondOperators.size() > 2) runArithmetic(eq);
        }
    }

    public double getArithmetic(String eq) {
        runArithmetic(eq);
        return result;
    }

    // public double runAddition(double[] inputArray) {
    //     double addResult = 0;
    //     for (int i = 0; i < inputArray.length; i++) {
    //         addResult = addResult + inputArray[i];
    //     }
    //     return addResult;
    // }

    // public double runSubtraction(double[] inputArray) {
    //     double subtractResult = inputArray[0] - inputArray[1];
    //     return subtractResult;
    // }

    // public double runMultiplication(double[] inputArray) {
    //     double multiplyResult = 1;
    //     for (int i = 0; i < inputArray.length; i++) {
    //         multiplyResult = multiplyResult * inputArray[i];
    //     }
    //     return multiplyResult;
    // }

    // public double runDivision(double[] inputArray) {
    //     if (inputArray[1] < 1) {
    //         return 0;
    //     }

    //     else { 
    //         double divideResult = inputArray[0] / inputArray[1];
    //         return divideResult;
    //     }
    // }

    public double runCircleArea(double[] inputArray) {
        double cAreaResult = inputArray[0] * inputArray[0] * Math.PI;
        return cAreaResult;
    }

    public double runCircleCircumference(double[] inputArray) {
        double cCircumferenceResult = inputArray[0] * Math.PI * 2;
        return cCircumferenceResult;
    }

    public double runSphereSurface(double[] inputArray) {
        double sSurfaceResult = inputArray[0] * inputArray[0] * Math.PI * 4;
        return sSurfaceResult;
    }

    public double runSphereVolume(double[] inputArray) {
        double sVolumeResult = (inputArray[0] * inputArray[0] * inputArray[0] * Math.PI * 4) / 3;
        return sVolumeResult;
    }

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

    public double runCentimeterInch(int operation, double[] userArray) {
        double result = 0;
        if (operation == 2) {result = userArray[0] * 0.393701;}
        else {result = userArray[0] * 2.54;}
        return result;
    }

    public double runMeterFoot(int operation, double[] userArray) {
        double result = 0;
        if (operation == 2) {result = userArray[0] * 3.28084;}
        else {result = userArray[0] * 0.3048;}
        return result;
    }

    public double runKilometerMile(int operation, double[] userArray) {
        double result = 0;
        if (operation == 2) {result = userArray[0] * 0.621371;}
        else {result = userArray[0] * 1.60934;}
        return result;
    }

    public double runKilogramPound(int operation, double[] userArray) {
        double result = 0;
        if (operation == 2) {result = userArray[0] * 2.20462;}
        else {result = userArray[0] * 0.453592;}
        return result;
    }

    public double runGramOunce(int operation, double[] userArray) {
        double result = 0;
        if (operation == 2) {result = userArray[0] * 0.035274;}
        else {result = userArray[0] * 28.3495;}
        return result;
    }

    public double runLiterGallon(int operation, double[] userArray) {
        double result = 0;
        if (operation == 2) {result = userArray[0] * 0.264172;}
        else {result = userArray[0] * 3.78541;}
        return result;
    }

    //RANDOM OPERATIONS

    public double randomNumGen(int numVals) {
        double result = rand.nextInt(numVals + 1);
        return result;
    }

    public ArrayList RSS(ArrayList<String> s) {
        String temp;
        int randNum;
        for (int i = 0; i < s.size(); i++) {
            randNum = rand.nextInt(s.size());
            temp = s.get(i);
            s.set(i, s.get(randNum));
            s.set(randNum, temp);
        }
        return s;
    }
}