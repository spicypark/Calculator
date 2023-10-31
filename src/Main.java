/** MADE BY JERRY ZHENG
 *  INSPIRED BY NICHOLAS MOFFA
 *  THANKS TO JADEN TU, JASON GUO
 *  VERSION 2.2.0-PR
 *  PORTIONS OF THIS CODE ARE EXTREMELY OLD
 */

import Modules.Battery;
import Modules.Input;
import Modules.Output;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nMADE BY JERRY ZHENG\nINSPIRED BY NICHOLAS MOFFA\nTHANKS TO JADEN TU, JASON GUO\n\nVERSION 2.2.0-PR");
        Input input = new Input();
        Output output = new Output();
        Battery battery = new Battery();
        battery.setBatteryLimit();
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
            else if (input.getFunction().equals("d")) {
                input.setOperation();
                input.setNumVals();
                input.setUserArray();
            }
            output.operationOutput();
        }
    }
}