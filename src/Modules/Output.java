package Modules;
public class Output {
    public void operationOutput() {
        double result = 0;
        Input input = new Input();
        Operations operation = new Operations();
        double[] userArray = input.getUserArray();
        int numVals = input.getNumVals();
        String function = input.getFunction();
        boolean found = false;
        //TODO: make arithmetic and graphing operation a number input instead of string for better accessibility
        if (function.equals("a")) {
            switch (input.getOperation()) {

                case 1:
                    result = operation.runAddition(userArray);
                    System.out.println("");
                    for (int aIndex = 0; aIndex < numVals; aIndex++) {
                        
                        String equalsPlace = numVals - aIndex > 1 ? " + " : " = ";
                        System.out.print(userArray[aIndex] + equalsPlace);

                    }

                    break;

                case 2:

                    result = operation.runSubtraction(userArray);
                    System.out.println("");
                    System.out.print(userArray[0] + " - " + userArray[1] + " = ");

                    break;

                case 3:

                    result = operation.runMultiplication(userArray);
                    System.out.println("");
                    for (int mIndex = 0; mIndex < numVals; mIndex++) {

                        String equalsPlace = numVals - mIndex > 1 ? " * " : " = ";
                        System.out.print(userArray[mIndex] + equalsPlace);

                    }

                    break;

                case 4:

                    result = operation.runDivision(userArray);
                    System.out.println("");
                    if (result == 0) {
                        System.out.println("ERROR");
                        return;
                    }

                    else {
                        System.out.print(userArray[0] + " / " + userArray[1] + " = ");
                    }

                    break;

                case 5:

                    result = operation.runCircleArea(userArray);
                    System.out.print("\nThe area of a circle with radius " + userArray[0] + " is ");

                    break;

                case 6:

                    result = operation.runCircleCircumference(userArray);
                    System.out.print("\nThe circumference of a circle with radius " + userArray[0] + " is ");

                    break;

                case 7:

                    result = operation.runSphereSurface(userArray);
                    System.out.print("\nThe surface area of a sphere with radius " + userArray[0] + " is ");

                    break;

                case 8:

                    result = operation.runSphereVolume(userArray);
                    System.out.print("\nThe volume of a sphere with radius " + userArray[0] + " is ");

                    break;

                case 9:
                    System.out.println("\nYou found an Easter egg :)");
                    found = true;
                    break;

            } 

            if (!found) {System.out.printf("%.2f\n", result);}
        }
        else if (function.equals("g")) {
            String[][] userPlane = new String[31][31];
            userPlane = operation.runGraphFunction(input.getOperation(), input.getUserPlane());
            System.out.println("");
            for (int i = 0; i < 31; i++) {
                for (int j = 0; j < 31; j++) {
                    if (j == 30) {
                        System.out.println(userPlane[i][j]);
                    }
                    else {
                        System.out.print(userPlane[i][j]);
                    }
                }
            }

        }
        else if (function.equals("c")) {
            String firstOP;
            String secondOP;
            switch(input.getConversion()) {

                case 1:
                    result = operation.runCentimeterInch(input.getOperation(), input.getUserArray());
                    System.out.println("");
                    firstOP = (input.getOperation() == 2) ? " centimeters is " : " inches is ";
                    System.out.print(input.getUserArray()[0] + firstOP);
                    System.out.printf("%.2f", result);
                    secondOP = (input.getOperation() == 2) ? " inches." : " centimeters.";
                    System.out.println(secondOP);
                    break;

                case 2:
                    result = operation.runMeterFoot(input.getOperation(), input.getUserArray());
                    System.out.println("");
                    firstOP = (input.getOperation() == 2) ? " meters is " : " feet is ";
                    System.out.print(input.getUserArray()[0] + firstOP);
                    System.out.printf("%.2f", result);
                    secondOP = (input.getOperation() == 2) ? " feet." : " meters.";
                    System.out.println(secondOP);
                    break;

                case 3:
                    result = operation.runKilometerMile(input.getOperation(), input.getUserArray());
                    System.out.println("");
                    firstOP = (input.getOperation() == 2) ? " kilometers is " : " miles is ";
                    System.out.print(input.getUserArray()[0] + firstOP);
                    System.out.printf("%.2f", result);
                    secondOP = (input.getOperation() == 2) ? " miles." : " kilometers.";
                    System.out.println(secondOP);
                    break;

                case 4:
                    result = operation.runKilogramPound(input.getOperation(), input.getUserArray());
                    System.out.println("");
                    firstOP = (input.getOperation() == 2) ? " kilograms is " : " pounds is ";
                    System.out.print(input.getUserArray()[0] + firstOP);
                    System.out.printf("%.2f", result);
                    secondOP = (input.getOperation() == 2) ? " pounds." : " kilograms.";
                    System.out.println(secondOP);
                    break;
                
                case 5:
                    result = operation.runGramOunce(input.getOperation(), input.getUserArray());
                    System.out.println("");
                    firstOP = (input.getOperation() == 2) ? " grams is " : " ounces is ";
                    System.out.print(input.getUserArray()[0] + firstOP);
                    System.out.printf("%.2f", result);
                    secondOP = (input.getOperation() == 2) ? " ounces." : " grams.";
                    System.out.println(secondOP);
                    break;

                case 6:
                    result = operation.runLiterGallon(input.getOperation(), input.getUserArray());
                    System.out.println("");
                    firstOP = (input.getOperation() == 2) ? " liters is " : " gallons is ";
                    System.out.print(input.getUserArray()[0] + firstOP);
                    System.out.printf("%.2f", result);
                    secondOP = (input.getOperation() == 2) ? " gallons." : " liters.";
                    System.out.println(secondOP);
                    break;
            }
            
        }
        else if (function.equals("d")) {
            switch (input.getOperation()) {

                case 1:
                    System.out.println();

            }
        }
    }
}