package frontend;
import javax.swing.*;
import backend.Constants;
import java.awt.*;

public class HomePanel extends JPanel {
    private static HomePanel instance = null;

    public HomePanel() {
        super();
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(Constants.Version.UID, 30, 30);

        g.drawString("Made by SpicyPark", 30, 55);
        g.drawString("Inspired by Nicholas", 30, 70);
        g.drawString("Thanks to rocketbooster1k, Infiniteless", 30, 85);

        g.drawString("A - Arithmetic", 30, 110);
        g.drawString("G - Graphing", 30, 125);
        g.drawString("C - Conversion", 30, 140);
        // g.drawString("D - Derivative", 30, 155);
        g.drawString("R - Random", 30, 170 - 15);

        g.drawString("https://github.com/SpicyPark/Calculator", 30, 315);

        repaint();
    }

    public static HomePanel getInstance() {
        if (instance == null) instance = new HomePanel();
        return instance;
    }
}