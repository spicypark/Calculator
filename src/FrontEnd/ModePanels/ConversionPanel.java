package FrontEnd.ModePanels;
import javax.swing.*;
import java.awt.*;

public class ConversionPanel extends JPanel {
    public ConversionPanel() {
        super();
        this.setBackground(Color.WHITE);

        // JTextField input = new JTextField(10);
        // this.add(input);

        // String[] units = {"units", "centimeters", "inches", "meters", "feet", "kilometers", "miles", "kilograms", "pounds", "grams", "ounces", "liters", "gallons"};
        
        // JComboBox<String> from = new JComboBox<String>(units);
        // from.setEditable(false);
        // this.add(from);

        // JTextField middle = new JTextField(2);
        // middle.setText("to");
        // middle.setEditable(false);
        // this.add(middle);

        // JComboBox<String> to = new JComboBox<String>(units);
        // to.setEditable(false);
        // this.add(to);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Coming soon", 30, 30);
        g.drawString("v3.0.0-alpha.3", 160, 330);
        repaint();
    }
}