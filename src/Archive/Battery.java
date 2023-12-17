// package Archive;
// import java.util.Scanner;

// public class Battery {
//     Scanner scnr = new Scanner(System.in);
//     Input input = new Input();
//     private boolean continueUsing = true;
//     private int useInstance = 0;
//     private int batteryLimit;
    
//     public void setBatteryLimit() {
//         System.out.println("\nPlease input desired battery limit:");
//         batteryLimit = input.getUserInt(scnr);
//         if (batteryLimit < 1) {
//             System.out.println("Invalid battery limit.");
//             setBatteryLimit();
//         }
//     }
//     public int getBatteryLimit() {
//         return batteryLimit;
//     }

//     public boolean continueUse() {
//         if (useInstance > 0) {
//             String continueInput;
//             System.out.println("\nContinue using calculator? (y/n)");
//             continueInput = scnr.next();

//             if (!continueInput.equals("y") && !continueInput.equals("n")) {
//                 System.out.println("Invalid option.");
//                 continueUse();
//             }

//             if (continueInput.equals("y")) {
//                 continueUsing = true;
//             }

//             else if (continueInput.equals("n")) {
//                 System.out.println("\nThank you for using this program.");
//                 continueUsing = false;
//             }
//         }
//         return continueUsing;
//     }

//     public int increaseInstance() {
//         useInstance += 1;
//         return useInstance;
//     }

//     public int getInstance() {
//         if (useInstance == batteryLimit) {System.out.println("\nBATTERY IS DEAD");}
//         return useInstance;
//     }
// }

// //CODE BELOW HERE IS ARCHIVED OLD OPERATIONS



//     // public double runCircleArea(double[] inputArray) {
//     //     double cAreaResult = inputArray[0] * inputArray[0] * Math.PI;
//     //     return cAreaResult;
//     // }

//     // public double runCircleCircumference(double[] inputArray) {
//     //     double cCircumferenceResult = inputArray[0] * Math.PI * 2;
//     //     return cCircumferenceResult;
//     // }

//     // public double runSphereSurface(double[] inputArray) {
//     //     double sSurfaceResult = inputArray[0] * inputArray[0] * Math.PI * 4;
//     //     return sSurfaceResult;
//     // }

//     // public double runSphereVolume(double[] inputArray) {
//     //     double sVolumeResult = (inputArray[0] * inputArray[0] * inputArray[0] * Math.PI * 4) / 3;
//     //     return sVolumeResult;
//     // }

//     //CONVERSION OPERATIONS

// //     public double runCentimeterInch(int operation, double[] userArray) {
// //         double result = 0;
// //         if (operation == 2) {result = userArray[0] * 0.393701;}
// //         else {result = userArray[0] * 2.54;}
// //         return result;
// //     }

// //     public double runMeterFoot(int operation, double[] userArray) {
// //         double result = 0;
// //         if (operation == 2) {result = userArray[0] * 3.28084;}
// //         else {result = userArray[0] * 0.3048;}
// //         return result;
// //     }

// //     public double runKilometerMile(int operation, double[] userArray) {
// //         double result = 0;
// //         if (operation == 2) {result = userArray[0] * 0.621371;}
// //         else {result = userArray[0] * 1.60934;}
// //         return result;
// //     }

// //     public double runKilogramPound(int operation, double[] userArray) {
// //         double result = 0;
// //         if (operation == 2) {result = userArray[0] * 2.20462;}
// //         else {result = userArray[0] * 0.453592;}
// //         return result;
// //     }

// //     public double runGramOunce(int operation, double[] userArray) {
// //         double result = 0;
// //         if (operation == 2) {result = userArray[0] * 0.035274;}
// //         else {result = userArray[0] * 28.3495;}
// //         return result;
// //     }

// //     public double runLiterGallon(int operation, double[] userArray) {
// //         double result = 0;
// //         if (operation == 2) {result = userArray[0] * 0.264172;}
// //         else {result = userArray[0] * 3.78541;}
// //         return result;
// //     }

// //     //RANDOM OPERATIONS

// //     public double randomNumGen(int numoperands) {
// //         double result = rand.nextInt(numoperands + 1);
// //         return result;
// //     }

// //     public ArrayList<String> RSS(ArrayList<String> s) {
// //         String temp;
// //         int randNum;
// //         for (int i = 0; i < s.size(); i++) {
// //             randNum = rand.nextInt(s.size());
// //             temp = s.get(i);
// //             s.set(i, s.get(randNum));
// //             s.set(randNum, temp);
// //         }
// //         return s;
// //     }