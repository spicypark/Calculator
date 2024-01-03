package FrontEnd.ModePanels;
import javax.swing.*;

import BackEnd.*;

import java.awt.*;
import java.awt.event.*;

public class GraphingPanel extends JPanel {
    Operations operation = new Operations();
    Detector detector = new Detector();
    private boolean refresh = false;
    private String eq;
    public GraphingPanel() {
        super();
        this.setBackground(Color.WHITE);

        JTextField input = new JTextField(20);
        input.setText("Please input your equation here.");
        this.add(input);

        JButton submit = new JButton("Submit");
        this.add(submit);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eq = input.getText();
                boolean detected = detector.detectPolynomial(eq);
                if (detected) {
                    refresh = true;
                }
                else {
                    input.setText("Invalid or unsupported input");
                    refresh = false;
                }
            }
        });

        JButton clear = new JButton("Clear");
        this.add(clear);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input.setText("");
            }   
        });
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        operation.drawPlane(g);
        if (refresh) operation.plotLine(g, eq);
        g.setColor(Color.BLACK);
        g.drawString("v3.0.0-alpha.4", 160, 330);
        repaint();
    }
}