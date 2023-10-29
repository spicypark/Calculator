package Modules;
import java.util.Scanner;

public class Input {
    Scanner scnr = new Scanner(System.in);
    private static String function;
    private static String operation;
    private static int operationD;
    private static int numVals = 1;
    private static int conversion;
    private static double[] userArray;
    private static String[][] userPlane = new String[31][31];

    private static final String[][] conversionOptions = {new String[]{"Inch to Centimeter\n", "Foot to Meter\n", "Mile to Kilometer\n", "Pound to Kilogram\n", "Ounce to Gram\n", "Gallon to Liter\n"}, 
                                                   new String[]{"Centimeter to Inch\n", "Meter to Foot\n", "Kilometer to Mile\n", "Kilogram to Pound\n", "Gram to Ounce\n", "Liter to Gallon\n"}};

    private static final int IMPERIAL_METRIC_ID = 0;
    private static final int METRIC_IMPERIAL_ID = 1;

    public void setFunction() {
        System.out.println("");
        System.out.println("Select desired function (Arithmetic [a] | Graphing [g] | Conversion [c] | Derivative [d]):");
        function = scnr.next();
        if (!function.equals("a") && !function.equals("g") && !function.equals("c") && !function.equals("d")) {
            System.out.println("");
            System.out.println("Invalid function.");
            setFunction();
        }
    }
    public String getFunction() {return function;}

    public void setOperation() {
        if (function.equals("a")) {
            System.out.println("");
            System.out.println("Please input an operation:\nAdd\nSubtract\nMultiply\nDivide\nCircleArea\nCircleCircumference\nSphereSurface\nSphereVolume\n");
            operation = scnr.next();
            if (!"Add".equals(operation) && !"Subtract".equals(operation) && !"Multiply".equals(operation) && !"Divide".equals(operation) && !"CircleArea".equals(operation) && !"CircleCircumference".equals(operation) && !"SphereSurface".equals(operation) && !"SphereVolume".equals(operation) && !"EasterEgg".equals(operation)) {
                System.out.println("");
                System.out.println("Invalid operation.");
                setOperation();
            }   
        }
        else if (function.equals("g")) {
            System.out.println("");
            System.out.println("Please input graphing function (Linear | Quadratic | Cubic | Exponential):");
            operation = scnr.next();
            if (!"Linear".equals(operation) && !"Quadratic".equals(operation) && !"Cubic".equals(operation) && !"Exponential".equals(operation)) {
                System.out.println("");
                System.out.println("Invalid operation.");
                setOperation();
            }
        }
        else if (function.equals("c")) {
            System.out.println("");
            System.out.println("Please input desired conversion:\n[IM] Imperial to Metric\n[MI] Metric to Imperial\n");
            operation = scnr.next();
            if (!"MI".equals(operation) && !"IM".equals(operation)) {
                System.out.println("");
                System.out.println("Invalid operation.");
                setOperation();
            }
        }
        else if (function.equals("d")) {
            System.out.println("");
            System.out.println("Please input the desired derivative:\n[1] nx^a\n[2] sin(ax)\n[3] cos(ax)\n[4] tan(ax)\n[5] sinh(ax)\n[6] cosh(ax)\n[7] tanh(ax)\n[8] arcsin(ax)\n[9] arccos(ax)\n[10] arctan(ax)\n[11] ln(ax)\n[12] a/x\n[13] e^ax\n[14] sqrt(ax)\n");
            operationD = scnr.nextInt();
            if (operationD > 14 || operationD < 1) {
                System.out.println("");
                System.out.println("Invalid operation.");
                setOperation();
            }
        }
    }
    public String getOperation() {return operation;}
    public int getOperationD() {return operationD;}

    public void setNumVals() {
        if (operation.equals("Add") || operation.equals("Multiply")) {
            System.out.println("");
            System.out.println("Please input the number of values (2-100):");
            numVals = scnr.nextInt();
            if (numVals > 100 || numVals < 2) {
                numVals = 0;
                System.out.println("");
                System.out.println("Invalid number of values.");
                setNumVals();
            }
        }
        else if (operation.equals("Subtract") || operation.equals("Divide")) {numVals = 2;}
    }
    public int getNumVals() {return numVals;}

    public int setConversion() {
        int metricImperialID = ("MI".equals(operation)) ? METRIC_IMPERIAL_ID : IMPERIAL_METRIC_ID;

        System.out.println("\nPlease input desiered conversions:\n");

        for (int i = 0; i < conversionOptions[metricImperialID].length; i++){
            System.out.print("[" + (i + 1) + "] " + conversionOptions[metricImperialID][i]);
        }

        System.out.println("");

        conversion = scnr.nextInt();

        if (conversion > 6 || conversion < 1){
            System.out.println("\nInvalid conversion.");
            setConversion();
        }

        System.out.println("\nYou chose: " + conversionOptions[metricImperialID][conversion - 1] + ".");
        return conversion;
    }

    public int getConversion() {return conversion;}

    public void setUserArray() {
        userArray = new double[numVals];

        if (function.equals("a")) {
            if (operation.equals("CircleArea") || operation.equals("CircleCircumference") || operation.equals("SphereSurface") || operation.equals("SphereVolume")) {
                System.out.println("");
                System.out.println("Please input the radius:");
                userArray[0] = scnr.nextDouble();
            }
            else if (numVals <= 100 && numVals >= 2) {
                System.out.println("");
                System.out.println("Please input your values:");
                for (int i = 0; i < numVals; i++) {
                    userArray[i] = scnr.nextDouble();
                }
            }
        }
        else if (function.equals("c")) {
            System.out.println("");            
            System.out.println("Please input the number of units to be converted:");
            userArray[0] = scnr.nextDouble();
        }
    }
    public double[] getUserArray() {return userArray;}

    public void defineUserPlane() {
        for (int upYIndex = 0; upYIndex < 31; upYIndex++) {

            if (upYIndex == 15) {
                for (int xAxisIndex = 0; xAxisIndex < 31; xAxisIndex++) {
                    userPlane[15][xAxisIndex] = "- ";
                }
            }

            else {
                for (int upXIndex = 0; upXIndex < 31; upXIndex++) {
                    if (upXIndex == 15) {
                        userPlane[upYIndex][upXIndex] = "- ";
                    }
                    else {
                        userPlane[upYIndex][upXIndex] = "o ";
                    }
                }
            }
            
        }
    }
    public String[][] setUserPlane(String[][] plane) {
        userPlane = plane;
        return userPlane;
    }
    public String[][] getUserPlane() {return userPlane;}
}