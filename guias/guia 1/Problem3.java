
// Programa que calcula cuanto tiempo te queda de vida dada una fecha, suponiendo que 
// la esperanza de vida es de 77 anios

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Problem3 extends JFrame implements ActionListener {
    private JTextField tfAge = new JTextField(3);
    private JButton bSay = new JButton("Calcular");
    private JLabel lData = new JLabel();
    private final int hope = 77;
    private Border border;

    public Problem3() {
        super("Hopping life 3000 v:");
        border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        bSay.addActionListener(this);
        content.add(tfAge, BorderLayout.WEST);
        content.add(lData, BorderLayout.CENTER);
        content.add(bSay, BorderLayout.EAST);
        //setSize(500, 400);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        lData.setText(String.valueOf(hope - Double.valueOf(tfAge.getText())));
    }

    public static void main(String[] args) {
        new Problem3();
    }
}