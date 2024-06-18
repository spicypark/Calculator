package frontend.modes;
import javax.swing.*;
import backend.*;
import java.awt.*;

public class Derivative extends JPanel {
    private static Derivative instance = null;

    public Derivative() {
        super();
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Coming soon", 30, 30);
        g.drawString(Constants.Version.UID, Constants.Version.VX, Constants.Version.VY);
        repaint();
    }

    public static Derivative getInstance() {
        if (instance == null) instance = new Derivative();
        return instance;
    }
}