package FrontEnd.ModePanels.RandomPanel;
import javax.swing.*;

import BackEnd.*;

import java.awt.*;
// import java.awt.event.*;

public class SelectorPanel  extends JPanel {
    Operations operation = new Operations();
    
    public SelectorPanel() {
        super();
        this.setBackground(new Color(0, 0, 0, 0));

        // JTextField title = new JTextField(40);
        // title.setText("List Scrambler");
        // title.setEditable(false);
        // this.add(title);

        // JTextField input = new JTextField(40);
        // input.setText("Please input your terms here.");
        // this.add(input);
        
        // JTextField solution = new JTextField(40);
        // solution.setText("Scrambled input: ");
        // solution.setEditable(false);
        // this.add(solution);

        // JButton submit = new JButton("Submit");
        // this.add(submit);
        // submit.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {

        //     }
        // });

        // JButton clear = new JButton("Clear");
        // this.add(clear);
        // clear.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         input.setText("");
        //         solution.setText("Scrambled input: ");
        //     }
        // });
    }
}