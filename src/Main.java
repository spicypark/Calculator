/** MADE BY JERRY ZHENG
 *  INSPIRED BY NICHOLAS MOFFA
 *  THANKS TO: JADEN TU, JASON GUO
 *  VERSION 2.0.1-PR
 *  THIS IS OLD AND POSSIBLY REDUNDANT CODE
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("MADE BY JERRY ZHENG");
        Input input = new Input();
        Output output = new Output();
        Battery battery = new Battery();
        int batteryLimit = battery.getBatteryLimit();
        while (battery.continueUse() && (battery.getInstance() < batteryLimit)) {
            battery.increaseInstance();
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
            else if (input.getFunction().equals("c")) {
                input.setOperation();
                input.setConversion();
                input.setUserArray();
            }
            output.operationOutput();
        }
    }
}