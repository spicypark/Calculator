package backend;
import javax.swing.*;

import frontend.*;
import frontend.modes.*;
import frontend.modes.random.*;

public class UserInterface {
    public static void initialize() {
        try {UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");} 
        catch (Exception e) {}
        
        JFrame frame = new JFrame();
        JTabbedPane panel = new JTabbedPane();
        HomePanel home = HomePanel.getInstance();
        panel.addTab("Home", null, home);
        SettingsPanel settings = SettingsPanel.getInstance();
        panel.addTab("Settings", null, settings);
        ArithmeticPanel arithmetic = ArithmeticPanel.getInstance();
        panel.addTab("A", null, arithmetic);
        GraphingPanel graphing = GraphingPanel.getInstance();
        panel.addTab("G", null, graphing);
        ConversionPanel conversion = ConversionPanel.getInstance();
        panel.addTab("C", null, conversion);
        // DerivativePanel derivative = DerivativePanel.getInstance();
        // panel.addTab("D", null, derivative);
        TopPanel random = TopPanel.getInstance();
        panel.addTab("R", null, random);
        
        frame.setTitle("Calculator");
        frame.setSize(410,410);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.setVisible(true);
    }
}