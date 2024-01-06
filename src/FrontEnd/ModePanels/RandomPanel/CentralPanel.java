package FrontEnd.ModePanels.RandomPanel;
import javax.swing.*;

import BackEnd.*;

import java.awt.*;

public class CentralPanel extends JPanel {
    GridLayout layout = new GridLayout(2, 1);
    TopPanel top = new TopPanel();
    SelectorPanel selector = new SelectorPanel();
    
    public CentralPanel() {
        super();
        this.setBackground(Color.WHITE);
        this.setLayout(layout);
        this.add(top);
        this.add(selector);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(Constants.VERSION, 160, 330);
        repaint();
    }
}