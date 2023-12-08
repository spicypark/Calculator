package Modules;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Operations {
    Scanner scnr = new Scanner(System.in);
    Input input = new Input();
    Random rand = new Random();

    //ARITHMETIC OPERATIONS

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

    //GRAPHING OPERATIONS

    public String[] [] runGraphFunction(int userGraphOp, String[] [] userPlane) {
        // WHEN I KEEP SAYING THAT THIS PROGRAM MAY BE REDUNDANT, PROBABLY 90% OF THOSE REDUNDANCIES ARE IN THIS METHOD
        double userX;
        double userY;

        if (userGraphOp == 1) {
            System.out.println("\nPlease input slope and y-intercept:");
            double userSlope = input.getUserDouble(scnr);
            double userYInt = input.getUserDouble(scnr);

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
        
        else if (userGraphOp == 2) {
            System.out.println("\nPlease input a, b, and c values:");
            double aValQ = input.getUserDouble(scnr);
            System.out.println(aValQ);
            double bValQ = input.getUserDouble(scnr);
            System.out.println(bValQ);
            double cValQ = input.getUserDouble(scnr);
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

        else if (userGraphOp == 3) {
            System.out.println("\nPlease input a, b, c, and d values:");
            double aValC = input.getUserDouble(scnr);
            double bValC = input.getUserDouble(scnr);
            double cValC = input.getUserDouble(scnr);
            double dValC = input.getUserDouble(scnr);

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

        else if (userGraphOp == 4) {
            System.out.println("\nPlease input a value:");
            double aValE = input.getUserDouble(scnr);

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