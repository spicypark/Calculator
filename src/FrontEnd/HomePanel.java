package FrontEnd;
import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {
    public HomePanel() {
        super();
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics b) {
        super.paintComponent(b);
        b.drawString("Version 3.0.0-alpha.2", 30, 30);

        b.drawString("Made by SpicyPark", 30, 55);
        b.drawString("Inspired by Nicholas", 30, 70);
        b.drawString("Thanks to rocketbooster1k, Infiniteless", 30, 85);

        b.drawString("A - Arithmetic", 30, 110);
        b.drawString("G - Graphing", 30, 125);
        b.drawString("C - Conversion", 30, 140);
        b.drawString("D - Derivative", 30, 155);
        b.drawString("R - Random", 30, 170);

        b.drawString("The calculator is currently in alpha testing.", 30, 300);
        b.drawString("Please report any bugs you encounter.", 30, 315);

        repaint();
    }
}