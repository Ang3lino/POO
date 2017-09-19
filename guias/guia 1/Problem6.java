
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Problem6 extends JFrame {
    JButton bfruit[] = new JButton[3];
    JLabel ans = new JLabel();

    public static void main(String[] args) {
        new Problem6();
    }

    public Problem6() {
        super("Frutas, llevele llevele!");
        Container c = getContentPane();
        c.setLayout(new GridLayout(1, 4));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        bfruit[0] = new JButton("Manzana");
        bfruit[1] = new JButton("Limon");
        bfruit[2] = new JButton("Naranja");
        bfruit[0].addActionListener(new AppleHandler());
        bfruit[1].addActionListener(new LemonHandler());
        bfruit[2].addActionListener(new OrangeHandler());
        for (int i = 0; i < bfruit.length; i++)
            c.add(bfruit[i]);
        c.add(ans);
        pack();
        setVisible(true);
    } 

    class AppleHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ans.setText("Manzana");
        }
    }
    
    class LemonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ans.setText("Limon");
        }
    }

    class OrangeHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ans.setText("Naranja");
        }
    }
}