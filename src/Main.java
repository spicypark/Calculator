/** MADE BY JERRY ZHENG
 *  INSPIRED BY NICHOLAS MOFFA
 *  THANKS TO JASON GUO, JADEN TU
 *  VERSION 2.3.0
 *  PORTIONS OF THIS CODE ARE EXTREMELY OLD
 */

import Modules.Battery;
import Modules.Input;
import Modules.Output;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nMADE BY JERRY ZHENG\nINSPIRED BY NICHOLAS MOFFA\nTHANKS TO JASON GUO, JADEN TU\n\nVERSION 2.3.0");
        Input input = new Input();
        Output output = new Output();
        Battery battery = new Battery();
        battery.setBatteryLimit();
        int batteryLimit = battery.getBatteryLimit();

        while (battery.getInstance() < batteryLimit && battery.continueUse()) {
            battery.increaseInstance();
            input.setFunction();
            input.setOperation();
            if (input.getFunction().equals("a")) {
                input.setNumVals();
                input.setUserArray();
            }
            else if (input.getFunction().equals("g")) {
                input.defineUserPlane();
            }
            else if (input.getFunction().equals("c")) {
                input.setConversion();
                input.setUserArray();
            }
            else if (input.getFunction().equals("d")) {
                input.setNumVals();
                input.setUserArray();
            }
            else if (input.getFunction().equals("r")) {
                input.setNumVals();
                input.setArrayList();
            }
            output.start();
        }
    }
}