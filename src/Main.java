/** MADE BY JERRY ZHENG
 *  INSPIRED BY NICHOLAS MOFFA
 *  THANKS TO JASON GUO, JADEN TU
 *  VERSION 3.0.0-ALPHA.1
 *  PORTIONS OF THIS CODE ARE EXTREMELY OLD
 */

import Modules.Battery;
import Modules.Input;
import Modules.Output;
import Graphics.ArithmeticPanel;
import Graphics.ConversionPanel;
import Graphics.DerivativePanel;
import Graphics.GraphingPanel;
import Graphics.HomePanel;
import Graphics.RandomPanel;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JTabbedPane panel = new JTabbedPane();
        HomePanel home = new HomePanel();
        panel.addTab("Home", null, home);
        ArithmeticPanel arithmetic = new ArithmeticPanel();
        panel.addTab("A", null, arithmetic);
        GraphingPanel graphing = new GraphingPanel();
        panel.addTab("G", null, graphing);
        ConversionPanel conversion = new ConversionPanel();
        panel.addTab("C", null, conversion);
        DerivativePanel derivative = new DerivativePanel();
        panel.addTab("D", null, derivative);
        RandomPanel random = new RandomPanel();
        panel.addTab("R", null, random);
        frame.setTitle("Calculator");
        frame.setSize(410,410);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.setVisible(true);

        System.out.println("\nMADE BY JERRY ZHENG\nINSPIRED BY NICHOLAS MOFFA\nTHANKS TO JASON GUO, JADEN TU\n\nVERSION 2.3.1");
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