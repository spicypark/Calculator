package frontend;
import javax.swing.*;
import backend.*;
import frontend.modes.Conversion;
import java.awt.*;
import java.awt.event.*;

public class Settings extends JPanel {
    private static Settings instance = null;
    GridLayout layout = new GridLayout(15, 1);
    Detector detector = Detector.getInstance();

    boolean graphNumbers = true;
    boolean graphGrid = true;
    String graphColor = "Blue";
    String conversionUnits = "Select units to be displayed";
    boolean falseLimit = false;
    int upperBound = 0;

    public Settings() {
        super();
        setBackground(Color.WHITE);
        setLayout(layout);

        JLabel graphing = new JLabel(" Graphing");
        add(graphing);
        
        JCheckBox gridSelect = new JCheckBox();
        gridSelect.setText("Gridlines");
        gridSelect.setSelected(true);
        add(gridSelect);
        gridSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                graphGrid = gridSelect.isSelected();
            }   
        });

        JCheckBox numberSelect = new JCheckBox();
        numberSelect.setText("Numbers");
        numberSelect.setSelected(true);
        add(numberSelect);
        numberSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                graphNumbers = numberSelect.isSelected();
            }   
        });

        String[] colors = {"Blue", "Red", "Green", "Magenta", "Black"};
        JComboBox<String> colorSelect = new JComboBox<String>(colors);
        colorSelect.setEditable(false);
        add(colorSelect);
        colorSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                graphColor = (String) colorSelect.getSelectedItem();
            }
        });

        JLabel conversion = new JLabel(" Conversion");
        add(conversion);

        String[] units = {"Select units to be displayed", "Distance", "Weight", "Volume", "All"};
        JComboBox<String> unitSelect = new JComboBox<String>(units);
        unitSelect.setEditable(false);
        add(unitSelect);
        unitSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conversionUnits = (String) unitSelect.getSelectedItem();
                Conversion.getInstance().updateUnits();
            }
        });

        JLabel random = new JLabel(" Random");
        add(random);

        JTextField limit = new JTextField(10);
        limit.setText("Upper bound for randomly generated number");
        add(limit);
        limit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean detected = detector.detectPosInt(limit.getText());
                if (detected) {
                    upperBound = Integer.parseInt(limit.getText());
                    falseLimit = false;
                }
                else falseLimit = true;
            }
        });

        JLabel dev = new JLabel(" Developer");
        add(dev);

        JCheckBox devSelect = new JCheckBox();
        devSelect.setText("Show developer tab");
        add(devSelect);
        devSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (devSelect.isSelected()) UserInterface.showDev();
                else UserInterface.hideDev();
            }   
        });
    }

    public boolean getNumberSelect() {
        return graphNumbers;
    }

    public boolean getGridSelect() {
        return graphGrid;
    }

    public Color getColorSelect() {
        if (graphColor.equals("Blue")) return Color.BLUE;
        else if (graphColor.equals("Red")) return Color.RED;
        else if (graphColor.equals("Green")) return Color.GREEN;
        else if (graphColor.equals("Magenta")) return Color.MAGENTA;
        else return Color.BLACK;
    }

    public String[] getUnits() {
        switch (conversionUnits) {
            case "Distance":
                return new String[] {"centimeters", "inches", "meters", "feet", "kilometers", "miles"};
            case "Weight":
                return new String[] {"kilograms", "pounds", "grams", "ounces"};
            case "Volume":
                return new String[] {"liters", "gallons"};
            case "All":
                return new String[] {"units", "centimeters", "inches", "meters", "feet", "kilometers", "miles", "kilograms", "pounds", "grams", "ounces", "liters", "gallons"};
        }
        return new String[] {"units", "centimeters", "inches", "meters", "feet", "kilometers", "miles", "kilograms", "pounds", "grams", "ounces", "liters", "gallons"};
    }

    public int getUpperBound() {
        return upperBound;
    }

    public boolean getFalseLimit() {
        return falseLimit;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(Constants.Version.UID, Constants.Version.VX, Constants.Version.VY);
        repaint();
    }

    public static Settings getInstance() {
        if (instance == null) instance = new Settings();
        return instance;
    }
}