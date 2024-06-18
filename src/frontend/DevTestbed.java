package frontend;
import javax.swing.*;
import backend.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class DevTestbed extends JPanel {
    private static DevTestbed instance = null;
    String equation;
    String solutionD = "0";
    NumberFormat decimal = new DecimalFormat("#0.00000");
    Operations operation = Operations.getInstance();
    Detector detector = Detector.getInstance();

    public DevTestbed() {
        super();
        setBackground(Color.WHITE);
        
        JLabel dPolynomial = new JLabel("--------------------------detectPolynomial--------------------------");
        add(dPolynomial);

        JTextField polynomialInput = new JTextField(40);
        polynomialInput.setText("Please input your equation here.");
        add(polynomialInput);

        JTextField polynomialSolution = new JTextField(40);
        polynomialSolution.setText("");
        polynomialSolution.setEditable(false);
        add(polynomialSolution);

        JButton polynomialSubmit = new JButton("Submit");
        add(polynomialSubmit);
        polynomialSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equation = polynomialInput.getText();
                polynomialSolution.setText("" + detector.detectPolynomial(equation));
            }
        });

        JButton polynomialClear = new JButton("Clear");
        add(polynomialClear);
        polynomialClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                polynomialInput.setText("");
                polynomialSolution.setText("");
            }
        });

        JLabel dArithmetic = new JLabel("--------------------------detectArithmetic--------------------------");
        add(dArithmetic);

        JTextField arithmeticInput = new JTextField(40);
        arithmeticInput.setText("Please input your equation here.");
        add(arithmeticInput);

        JTextField arithmeticSolution = new JTextField(40);
        arithmeticSolution.setText("");
        arithmeticSolution.setEditable(false);
        add(arithmeticSolution);

        JButton arithmeticSubmit = new JButton("Submit");
        add(arithmeticSubmit);
        arithmeticSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equation = arithmeticInput.getText();
                arithmeticSolution.setText("" + detector.detectArithmetic(equation));
            }
        });

        JButton arithmeticClear = new JButton("Clear");
        add(arithmeticClear);
        arithmeticClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                arithmeticInput.setText("");
                arithmeticSolution.setText("");
            }
        });

        JLabel fixthislmao = new JLabel("arithmetic detector operator at start or end of eq, fix this lmao");
        add(fixthislmao);
        JLabel fixthislmao2 = new JLabel("two operators or more in a row wtf wtf wtf, fix this lmao");
        add(fixthislmao2);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(Constants.Version.UID, Constants.Version.VX, Constants.Version.VY);
        repaint();
    }

    public static DevTestbed getInstance() {
        if (instance == null) instance = new DevTestbed();
        return instance;
    }
}