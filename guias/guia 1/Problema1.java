
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Problema1 extends Frame {
    private Button pesoToDollar, dollarToPeso;
    private TextField left, right;
    final double convertionFact = 18.52;

    public Problema1() {
        super("Conversiones peso/dollar");
        addWindowListener(new VentanaEscucha());        
        setLayout(new FlowLayout(FlowLayout.LEFT));

        left = new TextField(10);
        pesoToDollar = new Button("Peso a dolar");
        dollarToPeso = new Button("Dolar a peso");
        right = new TextField(10);

        pesoToDollar.addActionListener(new PesoDollar());
        dollarToPeso.addActionListener(new DollarPeso());

        add(left);
        add(pesoToDollar);
        add(dollarToPeso);
        add(right);

        pack();
        setVisible(true);
    }

    class PesoDollar implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double doubleLeft = new Double(left.getText());
            doubleLeft *= convertionFact;
            right.setText(String.valueOf(doubleLeft));
        }
    }

    class DollarPeso implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double doubleLeft = new Double(left.getText());
            doubleLeft /= convertionFact;
            right.setText(String.valueOf(doubleLeft));
        }
    }

    class VentanaEscucha implements WindowListener {
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
        new Problema1();
    }
}
