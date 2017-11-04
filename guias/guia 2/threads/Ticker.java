
/* Problema 2.-Codificar una clase llamada Ticker que mueva las letras de un texto de izquierda a derecha 
   (o de derecha a izquierda). Se puede quitar la primer letra y pegarla (con +) al final y repetir esto de 
   forma periódica. */

import java.util.*;

public class Ticker {
    private String str;
    private long lim;

    public Ticker(String str, long lim) {
        this.str = new String(str);
        this.lim = lim;
        String aux = new String();
        long i = 0;
        while (i++ < lim) {
            try {
                aux = str.substring(str.length() - 1);
                str = aux + str.substring(0, str.length() - 1);
                System.out.println(str);
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main (String[] a) {
        new Ticker("topu", 100);
    }
}

