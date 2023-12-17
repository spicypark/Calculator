package FrontEnd.ModePanels;
import javax.swing.*;
import java.awt.*;

public class ConversionPanel extends JPanel {
    public ConversionPanel() {
        super();
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Coming soon", 30, 30);
        g.drawString("v3.0.0-alpha.3", 160, 330);
        repaint();
    }
}