package FrontEnd;
import javax.swing.*;

import BackEnd.*;

import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class ArithmeticPanel extends JPanel{
    EquationDetector detector = new EquationDetector();
    String equation;
    String solutionD = "0";
    NumberFormat decimal = new DecimalFormat("#0.00000");
    Operations operation = new Operations();

    public ArithmeticPanel() {
        super();
        this.setBackground(Color.WHITE);
        
        JTextField input = new JTextField(40);
        JTextField solution = new JTextField(40);
        input.setText("Please input your equation here.");
        solution.setText("Solution: ");
        this.add(input);
        this.add(solution);
        solution.setEditable(false);

        JButton submit = new JButton("Submit");
        this.add(submit);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equation = input.getText();
                // input.setText("");
                boolean detected = detector.detectArithmetic(equation);
                if (!detected) {
                    solution.setText("Solution: Invalid input");
                    input.setText("Please input your equation here.");
                }
                else {
                    solutionD = decimal.format(operation.calculate(equation));
                    System.out.println("THE SOLUTION HANDED TO APANEL IS " + solutionD);
                    solution.setText("Solution: " + solutionD);
                }
            }
        });

        JButton clear = new JButton("Clear");
        this.add(clear);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                solution.setText("Solution: ");
            }
        });
    }

    @Override
    public void paintComponent(Graphics b) {
        super.paintComponent(b);
        b.drawString("v3.0.0-alpha.1", 160, 330);
        repaint();
    }
}