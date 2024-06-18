package frontend.modes.random;
import javax.swing.*;
import backend.*;
import java.awt.*;

public class Random extends JPanel {
    private static Random instance = null;
    GridLayout layout = new GridLayout(1, 2);
    RandomGenerator generator = RandomGenerator.getInstance();
    CoinFlip coin = CoinFlip.getInstance();    
    
    public Random() {
        super();
        setBackground(Color.WHITE);
        setLayout(layout);
        add(generator);
        add(coin);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(Constants.Version.UID, Constants.Version.VX, Constants.Version.VY);
        repaint();
    }

    public static Random getInstance() {
        if (instance == null) instance = new Random();
        return instance;
    }
}