package frontend;
import javax.swing.*;

import backend.Constants;

import java.awt.*;

public class HomePanel extends JPanel {
    public HomePanel() {
        super();
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(Constants.VERSION, 30, 30);

        g.drawString("Made by SpicyPark", 30, 55);
        g.drawString("Inspired by Nicholas", 30, 70);
        g.drawString("Thanks to rocketbooster1k, Infiniteless", 30, 85);

        g.drawString("A - Arithmetic", 30, 110);
        g.drawString("G - Graphing", 30, 125);
        g.drawString("C - Conversion", 30, 140);
        g.drawString("D - Derivative", 30, 155);
        g.drawString("R - Random", 30, 170);

        g.drawString("The calculator is currently in alpha testing.", 30, 285);
        g.drawString("Please report any bugs you encounter.", 30, 300);
        g.drawString("https://github.com/SpicyPark/Calculator", 30, 315);

        repaint();
    }
}