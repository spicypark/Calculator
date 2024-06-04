package frontend.modes.random;
import javax.swing.*;
import backend.*;
import java.awt.*;

public class TopPanel extends JPanel {
    private static TopPanel instance = null;
    GridLayout layout = new GridLayout(1, 2);
    GeneratorPanel generator = GeneratorPanel.getInstance();
    CoinPanel coin = CoinPanel.getInstance();    
    
    public TopPanel() {
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

    public static TopPanel getInstance() {
        if (instance == null) instance = new TopPanel();
        return instance;
    }
}