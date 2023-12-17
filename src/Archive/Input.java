// package Archive;
// import java.util.ArrayList;
// import java.util.Scanner;

// public class Input {
//     Scanner scnr = new Scanner(System.in);
//     private static String function;
//     private static int operation;
//     private static int numVals = 1;
//     private static int conversion;
//     private static double[] userArray;
//     private static String[][] userPlane = new String[31][31];
//     private static ArrayList<String> s = new ArrayList();

//     public void setFunction() {
//         System.out.println("\nPlease select desired function:\n[a] Arithmetic\n[g] Graphing\n[c] Conversion\n[d] Derivative\n[r] Random");
//         function = scnr.next();
//         if (!function.equals("a") && !function.equals("g") && !function.equals("c") && !function.equals("d") && !function.equals("r")) {
//             System.out.println("\nInvalid function.");
//             setFunction();
//         }
//     }
//     public String getFunction() {return function;}

//     public void setOperation() {
//         if (function.equals("a")) {
//             System.out.println("\nPlease input the desired operation:\n[1] Add\n[2] Subtract\n[3] Multiply\n[4] Divide\n[5] CircleArea\n[6] CircleCircumference\n[7] SphereSurface\n[8] SphereVolume");
//             operation  = this.getUserInt(scnr);
//             if (operation > 9 || operation < 1) {
//                 System.out.println("\nInvalid operation.");
//                 setOperation();
//             }   
//         }
//         else if (function.equals("g")) {
//             System.out.println("\nPlease input the desired graphing function:\n[1] Linear\n[2] Quadratic\n[3] Cubic\n[4] Exponential");
//             operation  = this.getUserInt(scnr);
//             if (operation > 4 || operation < 1) {
//                 System.out.println("\nInvalid graphing function.");
//                 setOperation();
//             }
//         }
//         else if (function.equals("c")) {
//             System.out.println("\nPlease input the desired conversion:\n[1] Imperial to Metric\n[2] Metric to Imperial");
//             operation  = this.getUserInt(scnr);
//             if (operation > 2 || operation < 1) {
//                 System.out.println("\nInvalid conversion.");
//                 setOperation();
//             }
//         }
//         else if (function.equals("d")) {
//             System.out.println("\nPlease input the desired derivative:\n[1] nx^a\n[2] sin(ax)\n[3] cos(ax)\n[4] tan(ax)\n[5] sinh(ax)\n[6] cosh(ax)\n[7] tanh(ax)\n[8] arcsin(ax)\n[9] arccos(ax)\n[10] arctan(ax)\n[11] ln(ax)\n[12] a/x\n[13] e^ax\n[14] sqrt(ax)\n[15] a^x");
//             operation  = this.getUserInt(scnr);
//             if (operation > 15 || operation < 1) {
//                 System.out.println("\nInvalid derivative.");
//                 setOperation();
//             }
//         }
//         else if (function.equals("r")) {
//             System.out.println("\nPlease input the desired operation:\n[1] Random Number Generator\n[2] List Shuffler\n[3] Coin Flip");
//             operation = this.getUserInt(scnr);
//             if (operation > 3 || operation < 1) {
//                 System.out.println("\nInvalid operation.");
//                 setOperation();
//             }
//         }
//     }
//     public int getOperation() {return operation;}

//     public void setNumVals() {
//         numVals = 1;
//         if (function.equals("a")) {
//             if (operation == 1 || operation == 3) {
//                 System.out.println("\nPlease input the number of values (2-100):");
//                 numVals = this.getUserInt(scnr);
//                 if (numVals > 100 || numVals < 2) {
//                     numVals = 0;
//                     System.out.println("\nInvalid number of values.");
//                     setNumVals();
//                 }
//             }
//             else if (operation == 2 || operation == 4) {numVals = 2;}
//         }
//         else if (function.equals("d")) {
//             if (operation == 1) {numVals = 2;}
//         }
//         else if (function.equals("r") && operation == 1) {
//             System.out.println("\nPlease input the upper bound for your random number:");
//             numVals = this.getUserInt(scnr);
//             if (numVals > Integer.MAX_VALUE || numVals < 1) {
//                 numVals = 0;
//                 System.out.println("\nInvalid upper bound.");
//                 setNumVals();
//             }
//         }
//         else if (function.equals("r") && operation == 3) {
//             System.out.println("\nPlease input the number of times you wish to flip the coin: ");
//             numVals = this.getUserInt(scnr);
//             if (numVals < 1) {
//                 System.out.println("Invalid number.");
//                 setNumVals();
//             }
//         }
//     }
//     public int getNumVals() {return numVals;}

//     public int setConversion() {
//         if (operation == 2) {
//             System.out.println("\nPlease input desired conversion:\n[1] Centimeter to Inch\n[2] Meter to Foot\n[3] Kilometer to Mile\n[4] Kilogram to Pound\n[5] Gram to Ounce\n[6] Liter to Gallon");
//         }
//         if (operation == 1) {
//             System.out.println("\nPlease input desired conversion:\n[1] Inch to Centimeter\n[2] Foot to Meter\n[3] Mile to Kilometer\n[4] Pound to Kilogram\n[5] Ounce to Gram\n[6] Gallon to Liter");
//         }
//         conversion  = this.getUserInt(scnr);
//         if (conversion > 6 || conversion < 1) {
//             System.out.println("\nInvalid conversion.");
//             setConversion();
//         }
//         return conversion;
//     }
//     public int getConversion() {return conversion;}

//     public void setUserArray() {
//         userArray = new double[numVals];

//         if (function.equals("a")) {
//             if (operation >= 5 && operation <= 8) {
//                 System.out.println("\nPlease input the radius:");
//                 userArray[0] = this.getUserDouble(scnr);
//             }
//             else if (numVals <= 100 && numVals >= 2) {
//                 System.out.println("\nPlease input your values:");
//                 for (int i = 0; i < numVals; i++) {
//                     userArray[i] = this.getUserDouble(scnr);
//                 }
//             }
//         }
//         else if (function.equals("c")) {
//             System.out.println("\nPlease input the number of units to be converted:");
//             userArray[0] = this.getUserDouble(scnr);
//         }
//         else if (function.equals("d")) {
//             if (operation == 1) {
//                 System.out.println("\nPlease input your n and a values:");
//                 userArray[0] = this.getUserDouble(scnr);
//                 userArray[1] = this.getUserDouble(scnr);
//             }
//             else {
//                 System.out.println("\nPlease input your a value:");
//                 userArray[0] = this.getUserDouble(scnr);
//                 if (operation == 14 && userArray[0] < 0) {
//                     System.out.println("Please do not input a negative number.");
//                     setUserArray();
//                 }
//             }
//         }
//     }
//     public double[] getUserArray() {return userArray;}

//     public void setArrayList() {
//         if (operation == 2) {
//             s.clear();
//             boolean noEnd = true;
//             String input;
//             System.out.println("\nPlease input values to be scrambled. Separate all values by a space. To finish inputting, type \"END.\"");
//             while (noEnd) {
//                 input = scnr.next();
//                 if (input.equals("END")) noEnd = false;
//                 else s.add(input);
//             }
//         }
//     }
//     public ArrayList getArrayList() {return s;}

//     public void defineUserPlane() {
//         for (int upYIndex = 0; upYIndex < 31; upYIndex++) {

//             if (upYIndex == 15) {
//                 for (int xAxisIndex = 0; xAxisIndex < 31; xAxisIndex++) {
//                     userPlane[15][xAxisIndex] = "- ";
//                 }
//             }

//             else {
//                 for (int upXIndex = 0; upXIndex < 31; upXIndex++) {
//                     if (upXIndex == 15) {
//                         userPlane[upYIndex][upXIndex] = "- ";
//                     }
//                     else {
//                         userPlane[upYIndex][upXIndex] = "o ";
//                     }
//                 }
//             }
            
//         }
//     }
//     public String[][] setUserPlane(String[][] plane) {
//         userPlane = plane;
//         return userPlane;
//     }
//     public String[][] getUserPlane() {return userPlane;}

//     public int getUserInt(Scanner scnr){
//         return getUserInt(scnr, "Invalid response.\n\nPlease reinput starting from the invalid input:");
//     }
//     public int getUserInt(Scanner scnr, String prompt){
//         while (true){
//             try {
//                 int x  = scnr.nextInt();
//                 return x;
//             } catch (Exception e){
//                 System.out.println(prompt);
//                 scnr.nextLine();
//                 continue;
//             }
//         }
//     }

//     public double getUserDouble(Scanner scnr){
//         return getUserDouble(scnr, "Invalid response.\n\nPlease reinput starting from the invalid input:");
//     }
//     public double getUserDouble(Scanner scnr, String prompt){
//         while (true){
//             try {
//                 double x = scnr.nextDouble();
//                 return x;
//             } catch (Exception e){
//                 System.out.println(prompt);
//                 scnr.nextLine();
//                 continue;
//             }
//         }
//     }
// }