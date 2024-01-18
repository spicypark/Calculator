package frontend.modes.random;
import javax.swing.*;

import backend.Constants;

import java.awt.*;

public class TopPanel extends JPanel {
    GridLayout layout = new GridLayout(1, 2);
    GeneratorPanel generator = new GeneratorPanel();
    CoinPanel coin = new CoinPanel();    
    
    public TopPanel() {
        super();
        this.setBackground(Color.WHITE);
        this.setLayout(layout);
        this.add(generator);
        this.add(coin);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(Constants.VERSION, 160, 330);
        repaint();
    }
}