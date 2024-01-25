package frontend.modes;
import javax.swing.*;
import backend.*;
import java.awt.*;

public class DerivativePanel extends JPanel {
    public DerivativePanel() {
        super();
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Coming soon", 30, 30);
        g.drawString(Constants.Version.UID, Constants.Version.VX, Constants.Version.VY);
        repaint();
    }
}