
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Problema4 extends Frame {
    private TextField m, n;
    private Button plus, minus, times, divition;
    private Label answer;
    public double x, y;

    public Problema4() {
        super("Calculadora");
        addWindowListener(new CloseWindow());
        setLayout(new BorderLayout());
        
        Panel input = createInputPanel();
        answer = new Label();
        add(input, BorderLayout.NORTH);
        add(answer, BorderLayout.CENTER);
        pack();
        setVisible(true);
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

    public Panel createInputPanel() {
        Panel p = new Panel(new GridLayout(1, 6));
        m = new TextField(20);
        n = new TextField(20);
        
        m.setText("0");
        n.setText("0");
        plus = new Button("+");
        minus = new Button("-");
        times = new Button("x");
        divition = new Button("/");
        
        plus.addActionListener(new PlusAction());
        minus.addActionListener(new MinusAction());
        times.addActionListener(new TimesAction());
        divition.addActionListener(new DivitionAction());

        p.add(m);
        p.add(n);
        p.add(plus);
        p.add(minus);
        p.add(times);
        p.add(divition);
        return p;        
    }

    public void getNumbers() {
        x = Double.valueOf(m.getText());
        y = Double.valueOf(n.getText());
    }

    class PlusAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            getNumbers();
            answer.setText(String.valueOf(x + y));
        }
    }
    
    class MinusAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            getNumbers();
            answer.setText(String.valueOf(x - y));
        }
    }

    class TimesAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            getNumbers();
            answer.setText(String.valueOf(x * y));
        }
    }

    class DivitionAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            getNumbers();
            if (y == 0)
                throw new ArithmeticException ("Division entre 0");
            answer.setText(String.valueOf(x / y));
        }
    }

    public static void main(String[] args) {
        new Problema4();
    }
}