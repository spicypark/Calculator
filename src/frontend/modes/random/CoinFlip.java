package frontend.modes.random;
import javax.swing.*;
import backend.*;
import java.awt.*;
import java.awt.event.*;

public class CoinFlip extends JPanel {
    private static CoinFlip instance = null;
    Operations operation = Operations.getInstance();
    
    public CoinFlip() {
        super();
        setBackground(new Color(0, 0, 0, 0));

        JTextField title = new JTextField(19);
        title.setText("Coin Flipper");
        title.setEditable(false);
        add(title);

        JTextField output = new JTextField(19);
        add(output);
        output.setEditable(false);

        JButton submit = new JButton("Flip");
        add(submit);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText(operation.flipCoin());
            }
        });
    }

    public static CoinFlip getInstance() {
        if (instance == null) instance = new CoinFlip();
        return instance;
    }
}