package Modules;
import java.util.Scanner;

public class Operations {
    Scanner scnr = new Scanner(System.in);

    public double runAddition(double[] inputArray) {
        double addResult = 0;
        for (int i = 0; i < inputArray.length; i++) {
            addResult = addResult + inputArray[i];
        }
        return addResult;
    }

    public double runSubtraction(double[] inputArray) {
        double subtractResult = inputArray[0] - inputArray[1];
        return subtractResult;
    }

    public double runMultiplication(double[] inputArray) {
        double multiplyResult = 1;
        for (int i = 0; i < inputArray.length; i++) {
            multiplyResult = multiplyResult * inputArray[i];
        }
        return multiplyResult;
    }

    public double runDivision(double[] inputArray) {
        if (inputArray[1] < 1) {
            return 0;
        }

        else {
            double divideResult = inputArray[0] / inputArray[1];
            return divideResult;
        }
    }

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

    public String[] [] runGraphFunction(String userGraphOp, String[] [] userPlane) {
        // i know this code is pretty redundant, i'm too lazy to fix it
        double userX;
        double userY;

        //GRAPHING FUNCTION
        if (userGraphOp.equals("Linear")) {
            System.out.println("");
            System.out.println("Please input slope and y-intercept:");
            double userSlope = scnr.nextDouble();
            double userYInt = scnr.nextDouble();

            for (int j = 0; j < 31; j++) {

                userX = j;
                userY = ((j - 15) * -userSlope) - userYInt;

                if ((int)userY + 15 < 0 || (int)userY + 15 > 31) {
                    userPlane[15][j] = "- ";
                }

                else if (userY + 15 >=0 && userY + 15 < 31) {
                    userPlane[(int)userY + 15][(int)userX] = "■ ";
                }
            }
        }
        
        else if (userGraphOp.equals("Quadratic")) {
            System.out.println("");
            System.out.println("Please input a, b, and c values:");
            double aValQ = scnr.nextDouble();
            System.out.println(aValQ);
            double bValQ = scnr.nextDouble();
            System.out.println(bValQ);
            double cValQ = scnr.nextDouble();
            System.out.println(cValQ);

            for (int k = 0; k < 31; k++) {

                userX = k;
                userY = ((k - 15) * (k - 15) * -aValQ) - (bValQ * (k - 15)) - cValQ;

                if ((int)userY + 15 < 0 || (int)userY + 15 > 31) {
                    userPlane[15][k] = "- ";
                }

                else if (userY + 15 >=0 && userY + 15 < 31) {
                    userPlane[(int)userY + 15][(int)userX] = "■ ";
                }
            }
        }

        else if (userGraphOp.equals("Cubic")) {
            System.out.println("");
            System.out.println("Please input a, b, c, and d values:");
            double aValC = scnr.nextDouble();
            double bValC = scnr.nextDouble();
            double cValC = scnr.nextDouble();
            double dValC = scnr.nextDouble();

            for (int k = 0; k < 31; k++) {

                userX = k;
                userY = ((k - 15) * (k - 15) * (k - 15) * -aValC) - ((k - 15) * (k - 15) * -bValC) - (cValC * (k - 15)) - dValC;

                if ((int)userY + 15 < 0 || (int)userY + 15 > 31) {
                    userPlane[15][k] = "- ";
                }

                else if (userY + 15 >=0 && userY + 15 < 31) {
                    userPlane[(int)userY + 15][(int)userX] = "■ ";
                }
            }
        }

        else if (userGraphOp.equals("Exponential")) {
            System.out.println("");
            System.out.println("Please input a value:");
            double aValE = scnr.nextDouble();

            for (int k = 0; k < 31; k++) {
                userX = k;
                userY = 1;
                double tempUserX = userX - 15.0;

                if (tempUserX < 0) {
                    double negDenom = 1;
                    for (int l = 0; l < (tempUserX * -1) ; l++) {
                        negDenom *= aValE;
                    }

                    userY = (1 / negDenom) * -1.0;
                }

                else if (tempUserX == 0) {
                    userY = -1.0;
                }

                else if (tempUserX > 0) {
                    double userYE = 1;
                    for (int l = 0; l < tempUserX; l++) {
                        userYE *= aValE;
                    }
                    userY = userYE * -1.0;
                }

                if ((int)userY + 15 < 0 || (int)userY + 15 > 31) {
                    userPlane[15][k] = "- ";
                }

                else if (userY + 15 >=0 && userY + 15 < 31) {
                    userPlane[(int)userY + 15][(int)userX] = "■ ";
                }
            }
        }
        
        return userPlane;
    }

    public double runCentimeterInch (String operation, double[] userArray) {
        double result = 0;
        if (operation.equals("MI")) {result = userArray[0] * 0.393701;}
        else {result = userArray[0] * 2.54;}
        return result;
    }

    public double runMeterFoot (String operation, double[] userArray) {
        double result = 0;
        if (operation.equals("MI")) {result = userArray[0] * 3.28084;}
        else {result = userArray[0] * 0.3048;}
        return result;
    }

    public double runKilometerMile (String operation, double[] userArray) {
        double result = 0;
        if (operation.equals("MI")) {result = userArray[0] * 0.621371;}
        else {result = userArray[0] * 1.60934;}
        return result;
    }

    public double runKilogramPound (String operation, double[] userArray) {
        double result = 0;
        if (operation.equals("MI")) {result = userArray[0] * 2.20462;}
        else {result = userArray[0] * 0.453592;}
        return result;
    }

    public double runGramOunce (String operation, double[] userArray) {
        double result = 0;
        if (operation.equals("MI")) {result = userArray[0] * 0.035274;}
        else {result = userArray[0] * 28.3495;}
        return result;
    }

    public double runLiterGallon (String operation, double[] userArray) {
        double result = 0;
        if (operation.equals("MI")) {result = userArray[0] * 0.264172;}
        else {result = userArray[0] * 3.78541;}
        return result;
    }
}