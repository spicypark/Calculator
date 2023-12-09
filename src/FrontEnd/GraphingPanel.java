package FrontEnd;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BackEnd.*;

public class GraphingPanel extends JPanel {
    Operations operations = new Operations();
    public boolean refresh = false;
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
                refresh = true;
            }
        });
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        operations.drawPlane(g);
        if (refresh) {
            operations.testMethod(g);
        }
        repaint();
    }
}