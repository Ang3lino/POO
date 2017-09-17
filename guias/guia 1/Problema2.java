
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Problema2 extends Frame {
    private TextField value1, value2;
    private Button bEquals;

    public Problema2() {
        super("Son iguales");
        addWindowListener(new CloseWindow());
        setLayout(new BorderLayout());
        value1 = new TextField(10);
        value2 = new TextField(10);
        bEquals = new Button("Son iguales?");

        bEquals.addActionListener(new BotonEscucha());
        add(value1, BorderLayout.WEST);
        add(value2, BorderLayout.EAST);
        add(bEquals, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    class BotonEscucha implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double x = Double.valueOf(value1.getText());
            double y = Double.valueOf(value2.getText());
            if (x == y) 
                System.out.println("Iguales"); 
            else 
                System.out.println("Distintos");
        }
    }

    public class CloseWindow implements WindowListener {
        public void windowClosing(WindowEvent e) {
            setVisible(false);
            dispose();
            System.exit(0);
        }

        public void windowDeactivated(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}        
    }

    public static void main(String[] args) {
        new Problema2();
    }
}
