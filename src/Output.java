public class Output {
    public void operationOutput() {
        double result = 0;
        Input input = new Input();
        Operations operation = new Operations();
        double[] userArray = input.getUserArray();
        int numVals = input.getNumVals();
        String function = input.getFunction();

        if (function.equals("a")) {
            switch (input.getOperation()) {

                case "Add":
                    result = operation.runAddition(userArray);
                    
                    for (int aIndex = 0; aIndex < numVals; aIndex++) {
                        
                        String equalsPlace = numVals - aIndex > 1 ? " + " : " = ";
                        System.out.print(userArray[aIndex] + equalsPlace);

                    }

                    break;

                case "Subtract":

                    result = operation.runSubtraction(userArray);
                    System.out.print(userArray[0] + " - " + userArray[1] + " = ");

                    break;

                case "Multiply":

                    result = operation.runMultiplication(userArray);

                    for (int mIndex = 0; mIndex < numVals; mIndex++) {

                        String equalsPlace = numVals - mIndex > 1 ? " * " : " = ";
                        System.out.print(userArray[mIndex] + equalsPlace);

                    }

                    break;

                case "Divide":

                    result = operation.runDivision(userArray);

                    if (result == 0) {
                        System.out.println("ERROR");
                        return;
                    }

                    else {
                        System.out.print(userArray[0] + " / " + userArray[1] + " = ");
                    }

                    break;

                case "CircleArea":

                    result = operation.runCircleArea(userArray);
                    System.out.print("The area of a circle with radius " + userArray[0] + " is ");

                    break;

                case "CircleCircumference":

                    result = operation.runCircleCircumference(userArray);
                    System.out.print("The circumference of a circle with radius " + userArray[0] + " is ");

                    break;

                case "SphereSurface":

                    result = operation.runSphereSurface(userArray);
                    System.out.print("The surface area of a sphere with radius " + userArray[0] + " is ");

                    break;

                case "SphereVolume":

                    result = operation.runSphereVolume(userArray);
                    System.out.print("The volume of a sphere with radius " + userArray[0] + " is ");

                    break;

                case "EasterEgg":
                    System.out.println("You found an Easter egg :)");
                    break;

            } 

            System.out.printf("%.2f\n", result);
        }
        else if (function.equals("g")) {
            String[][] userPlane = new String[31][31];
            userPlane = operation.runGraphFunction(input.getOperation(), input.getUserPlane());

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

    }
}