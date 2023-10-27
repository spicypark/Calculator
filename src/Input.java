import java.util.Scanner;

public class Input {
    Scanner scnr = new Scanner(System.in);
    private static String function;
    private static String operation;
    private static int numVals;
    private static double[] userArray;
    private static String[][] userPlane = new String[31][31];

    public void setFunction() {
        System.out.println("Select desired function (Arithmetic [a] | Graphing [g] | Conversion [c]):");
        function = scnr.next();
    }
    public String getFunction() {return function;}

    public void setOperation() {
        if (function.equals("a")) {
            System.out.println("Please input an operation:\nAdd\nSubtract\nMultiply\nDivide\nCircleArea\nCircleCircumference\nSphereSurface\nSphereVolume");
            operation = scnr.next();
            if (!"Add".equals(operation) && !"Subtract".equals(operation) && !"Multiply".equals(operation) && !"Divide".equals(operation) && !"CircleArea".equals(operation) && !"CircleCircumference".equals(operation) && !"SphereSurface".equals(operation) && !"SphereVolume".equals(operation) && !"EasterEgg".equals(operation)) {
                System.out.println("Invalid operation.");
                setOperation();
            }   
        }
        else if (function.equals("g")) {
            System.out.println("Please input graphing function (Linear | Quadratic | Cubic | Exponential):");
            operation = scnr.next();
            if (!"Linear".equals(operation) && !"Quadratic".equals(operation) && !"Cubic".equals(operation) && !"Exponential".equals(operation)) {
                System.out.println("Invalid operation.");
                setOperation();
            }
        }
    }
    public String getOperation() {return operation;}

    public void setNumVals() {
        if (operation.equals("Add") || operation.equals("Multiply")) {
            System.out.println("Please input the number of values (2-100)");
            numVals = scnr.nextInt();
            if (numVals > 100 || numVals < 2) {
                numVals = 0;
                System.out.println("Invalid number of values.");
                setNumVals();
            }
        }
        else if (operation.equals("Subtract") || operation.equals("Divide")) {numVals = 2;}
        else {numVals = 1;}
    }
    public int getNumVals() {return numVals;}

    public void setUserArray() {
        userArray = new double[numVals];
        if (operation.equals("CircleArea") || operation.equals("CircleCircumference") || operation.equals("SphereSurface") || operation.equals("SphereVolume")) {
            System.out.println("Please input the radius:");
            userArray[0] = scnr.nextDouble();
        }
        else if (numVals <= 100 && numVals >= 2) {
            System.out.println("Please input your values:");
            for (int i = 0; i < numVals; i++) {
                userArray[i] = scnr.nextDouble();
            }
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