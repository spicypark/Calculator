package FrontEnd.ModePanels.RandomPanel;
import javax.swing.*;

import BackEnd.*;

import java.awt.*;
import java.awt.event.*;

public class SelectorPanel  extends JPanel {
    public SelectorPanel() {
        super();
        this.setBackground(Color.GREEN);//TODO white

        JTextField input = new JTextField(40);
        JTextField solution = new JTextField(40);
        input.setText("Please input your terms here.");
        solution.setText("Scrambled input: ");
        this.add(input);
        this.add(solution);
        solution.setEditable(false);

        JButton submit = new JButton("Submit");
        this.add(submit);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton clear = new JButton("Clear");
        this.add(clear);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                solution.setText("Scrambled input: ");
            }
        });
    }
}