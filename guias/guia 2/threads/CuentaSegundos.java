
/* Problema 1
    Codificar una clase llamada CuentaSegundos que implemente la interfaz Runnable: 
    -Que cada segundo incremente en una unidad  un contador y muestre el valor de dicho contador en una 
    etiqueta.
    -Que cuando llegue a un valor limite (que se establece cuando se crea un objeto) deje de incrementar el 
    contador y de actualizar el valor mostrado.
    Sugerencia extienda la clase Label y asigne cero al contador en el constructor. */

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CuentaSegundos extends JFrame {
    private long lim;
    private JLabel etiqueta;

    public CuentaSegundos(long _lim) throws Exception {
        super("Cuenta segundos");
        if (lim < 0)
            throw new ArithmeticException("Limite negativo.");
        lim = _lim;
        etiqueta = new JLabel("0");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(etiqueta);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        waiting();
    }

    public void waiting() throws Exception {
        long count = 0;
        while (count < lim) {
            Thread.sleep(1000);
            etiqueta.setText(Long.toString(count++));
            System.out.println(count);
        }
    }

    public static void main(String args[]) throws Exception {
        new CuentaSegundos(15);
    }
}
