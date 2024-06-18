package frontend.modes;
import javax.swing.*;
import backend.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class Arithmetic extends JPanel {
    private static Arithmetic instance = null;
    String equation;
    String solutionD = "0";
    NumberFormat decimal = new DecimalFormat("#0.00000");
    Operations operation = Operations.getInstance();
    Detector detector = Detector.getInstance();

    public Arithmetic() {
        super();
        setBackground(Color.WHITE);
        
        JTextField input = new JTextField(40);
        input.setText("Please input your equation here.");
        add(input);

        JTextField solution = new JTextField(40);
        solution.setText("Solution: ");
        solution.setEditable(false);
        add(solution);

        JButton submit = new JButton("Submit");
        add(submit);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equation = input.getText();
                boolean detected = detector.detectArithmetic(equation);
                if (!detected) {
                    solution.setText("Solution: Invalid or unsupported input");
                    input.setText("Please input your equation here.");
                }
                else {
                    solutionD = decimal.format(operation.calculate(equation));
                    solution.setText("Solution: " + solutionD);
                }
            }
        });

        JButton clear = new JButton("Clear");
        add(clear);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                solution.setText("Solution: ");
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(Constants.Version.UID, Constants.Version.VX, Constants.Version.VY);
        repaint();
    }

    public static Arithmetic getInstance() {
        if (instance == null) instance = new Arithmetic();
        return instance;
    }
}