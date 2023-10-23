/** MADE BY JERRY ZHENG
 *  INSPIRED BY NICHOLAS MOFFA
 *  VERSION 2.0 - 05/05/2023
 *  THIS IS OLD AND POSSIBLY REDUNDANT CODE
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("MADE BY JERRY ZHENG");
        Battery battery = new Battery();
        int batteryLimit = battery.getBatteryLimit();
        while (battery.continueUse() && (battery.getInstance() < batteryLimit)) {
            battery.increaseInstance();
            Input input = new Input();
            Output output = new Output();
            input.setFunction();
            if (input.getFunction().equals("a")) {
                input.setOperation();
                input.setNumVals();
                input.setUserArray();
            }
            else if (input.getFunction().equals("g")) { 
                input.setOperation();
                input.defineUserPlane();
            }
            output.operationOutput();
        }
    }
}