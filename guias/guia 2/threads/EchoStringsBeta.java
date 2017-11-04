
/* Problema 3.-Codificar un programa que permita al usuario introducir varios textos (el usuario escribe un 
   texto en un campo de entrada y dicho texto se almacena cuando el usuario presiona un botón). Guarde los 
   textos en una arreglo de cadenas y use un hilo para que después de un cierto numero de segundos el texto 
   actual en una etiqueta se sustituye por el siguiente  texto en el arreglo. */

import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EchoStrings extends JFrame implements ActionListener {

    private LinkedList<String> words = new LinkedList<String>();
    private JTextField input = new JTextField(10);
    private JLabel ans = new JLabel();
    private JButton b = new JButton("Presiona para agregar");
    private Container c;
    private int currentPos = 0;
    private Thread paImprimir; 

    public EchoStrings() {
        super("Eco, eco, eco, co, ...");
        paImprimir = new Thread(new wordPrinter());
        c = getContentPane();
        c.setLayout(new GridLayout(2, 2));
        c.add(input);
        b.addActionListener(this);
        c.add(b);
        c.add(ans);
        paImprimir.start();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public void actionPerformed(ActionEvent ae) {
        words.add(input.getText());
    }

    class wordPrinter implements Runnable {
        public void run() {
            while (true) {
                try {
                    if (words.size() > 0) {
                        Thread.sleep(1000);
                        ans.setText(words.get(currentPos++));
                        currentPos %= words.size();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } 
                System.out.println(words.size());
                // si no pongo la linea de aqui arriba, no funciona?!
            }
        }
    }

    public static void main(String[] s) {
        new EchoStrings();
    }

}
