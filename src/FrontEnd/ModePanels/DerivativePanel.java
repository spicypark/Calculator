package FrontEnd.ModePanels;
import javax.swing.*;

import BackEnd.*;

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
        g.drawString(Constants.VERSION, 160, 330);
        repaint();
    }
}
