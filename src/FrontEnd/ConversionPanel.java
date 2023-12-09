package FrontEnd;
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
        repaint();
    }
}