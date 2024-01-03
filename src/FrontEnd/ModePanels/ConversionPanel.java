package FrontEnd.ModePanels;
import javax.swing.*;

import BackEnd.*;

import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class ConversionPanel extends JPanel {
    Detector detector = new Detector();
    String solutionD = "0";
    NumberFormat decimal = new DecimalFormat("#0.00000");
    Operations operation = new Operations();
    
    public ConversionPanel() {
        super();
        this.setBackground(Color.WHITE);
        String[] units = {"units", "centimeters", "inches", "meters", "feet", "kilometers", "miles", "kilograms", "pounds", "grams", "ounces", "liters", "gallons"};

        JTextField input = new JTextField(15);
        this.add(input);
        
        JComboBox<String> from = new JComboBox<String>(units);
        from.setEditable(false);
        this.add(from);

        JTextField middle = new JTextField(2);
        middle.setText("to");
        middle.setEditable(false);
        this.add(middle);

        JComboBox<String> to = new JComboBox<String>(units);
        to.setEditable(false);
        this.add(to);

        JTextField solution = new JTextField(40);
        solution.setText("Solution: ");
        solution.setEditable(false);
        this.add(solution);

        JButton submit = new JButton("Submit");
        this.add(submit);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean detected = detector.detectConversion(from.getSelectedItem().toString(), to.getSelectedItem().toString(), input.getText());//first detect if input num value is a double
                if (!detected) solution.setText("Solution: Invalid or unsupported input");
                else {
                    solutionD = decimal.format(operation.convert(from.getSelectedItem().toString(), to.getSelectedItem().toString(), Double.parseDouble(input.getText())));
                    solution.setText("Solution: " + solutionD);
                }
                System.out.println(input.getText());
                System.out.println(from.getSelectedItem());
                System.out.println(to.getSelectedItem());
            }
        });

        JButton clear = new JButton("Clear");
        this.add(clear);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                from.setSelectedItem(units[0]);
                to.setSelectedItem(units[0]);
                solution.setText("Solution: ");
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("v3.0.0-alpha.4", 160, 330);
        repaint();
    }
}