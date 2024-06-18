package frontend.modes;
import javax.swing.*;
import backend.*;
import frontend.Settings;

import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class Conversion extends JPanel {
    private static Conversion instance = null;
    String solutionD = "0";
    NumberFormat decimal = new DecimalFormat("#0.00000");
    Operations operation = Operations.getInstance();
    Detector detector = Detector.getInstance();
    Settings settings = Settings.getInstance();

    JComboBox<String> from = new JComboBox<String>(settings.getUnits());
    JComboBox<String> to = new JComboBox<String>(settings.getUnits());
    
    public Conversion() {
        super();
        setBackground(Color.WHITE);

        JTextField input = new JTextField(15);
        add(input);
        
        from.setEditable(false);
        add(from);

        JTextField middle = new JTextField(2);
        middle.setText("to");
        middle.setEditable(false);
        add(middle);
        
        to.setEditable(false);
        add(to);

        JTextField solution = new JTextField(40);
        solution.setText("Solution: ");
        solution.setEditable(false);
        add(solution);

        JButton submit = new JButton("Submit");
        add(submit);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean inputValueValid = detector.detectDouble(input.getText());
                if (inputValueValid) {
                    boolean detected = detector.detectConversion(from.getSelectedItem().toString(), to.getSelectedItem().toString());
                    if (!detected) solution.setText("Solution: Invalid or unsupported input");
                    else {
                        solutionD = decimal.format(operation.convert(from.getSelectedItem().toString(), to.getSelectedItem().toString(), Double.parseDouble(input.getText())));
                        solution.setText("Solution: " + solutionD);
                    }
                }
                else solution.setText("Solution: Invalid or unsupported input");
            }
        });

        JButton clear = new JButton("Clear");
        add(clear);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                from.setSelectedItem(settings.getUnits()[0]);
                to.setSelectedItem(settings.getUnits()[0]);
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

    public void updateUnits() {
        from.setModel(new JComboBox<>(settings.getUnits()).getModel());
        to.setModel(new JComboBox<>(settings.getUnits()).getModel());
    }

    public static Conversion getInstance() {
        if (instance == null) instance = new Conversion();
        return instance;
    }
}