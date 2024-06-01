package frontend.modes;
import javax.swing.*;
import backend.*;
import frontend.SettingsPanel;

import java.awt.*;
import java.awt.event.*;

public class GraphingPanel extends JPanel {
    private static GraphingPanel instance = null;
    Operations operation = Operations.getInstance();
    Detector detector = Detector.getInstance();
    SettingsPanel settings = SettingsPanel.getInstance();
    private boolean refresh = false;
    private String eq;

    public GraphingPanel() {
        super();
        this.setBackground(Color.WHITE);

        JTextField input = new JTextField(24);
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
        if (settings.getGridSelect()) operation.drawPlane(g);
        if (settings.getNumberSelect()) operation.drawNumbers(g);
        if (refresh) operation.plotLine(g, eq);
        g.setColor(Color.BLACK);
        g.drawString(Constants.Version.UID, Constants.Version.VX, Constants.Version.VY);
        repaint();
    }

    public static GraphingPanel getInstance() {
        if (instance == null) instance = new GraphingPanel();
        return instance;
    }
}