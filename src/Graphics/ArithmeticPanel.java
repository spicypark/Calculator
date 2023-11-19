package Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Modules.EquationDetector;

public class ArithmeticPanel extends JPanel{
    EquationDetector detector = new EquationDetector();
    String equation;
    public ArithmeticPanel() {
        super();
        this.setBackground(Color.WHITE);
        JTextField input = new JTextField(20);
        input.setText("Please input your equation.");
        this.add(input);
        JButton submit = new JButton("Submit");
        this.add(submit);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equation = input.getText();
                input.setText("");
                boolean detected = detector.detectArithmetic(equation);
                System.out.println(detected);
            }
        });
    }

    @Override
    public void paintComponent(Graphics b) {
        super.paintComponent(b);
        b.drawString("Implemented operations:", 30, 300);
        b.drawString("Add, Subtract, Multiply, Divide", 30, 315);
        repaint();
    }
}