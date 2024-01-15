package FrontEnd.ModePanels.RandomPanel;
import javax.swing.*;

import BackEnd.*;

import java.awt.*;
import java.awt.event.*;

public class GeneratorPanel extends JPanel {
    int upperBound;
    Detector detector = new Detector();
    boolean falseLimit = false;
    Operations operation = new Operations();

    public GeneratorPanel() {
        super();
        this.setBackground(new Color(0, 0, 0, 0));

        JTextField title = new JTextField(19);
        title.setText("Random Number Generator");
        title.setEditable(false);
        this.add(title);

        JTextField limit = new JTextField(10);
        limit.setText("Upper bound");
        this.add(limit);

        JButton limitSubmit = new JButton("Submit");
        this.add(limitSubmit);
        limitSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean detected = detector.detectPosInt(limit.getText());
                if (detected) {
                    upperBound = Integer.parseInt(limit.getText());
                    falseLimit = false;
                }
                else falseLimit = true;
            }
        });

        JTextField output = new JTextField(19);
        this.add(output);
        output.setEditable(false);

        JButton inputSubmit = new JButton("Generate");
        this.add(inputSubmit);
        inputSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (falseLimit) output.setText("Invalid or unsupported input");
                else output.setText("" + operation.generateRandomNumber(upperBound));
            }
        });
    }
}