
/* Juego de  tirar 2 dados (usando Swing para la IGU)
	-Poner dos etiquetas gráficas una por cada dado y un botón para jugar. Si la suma de los dos 
		dados es 7 el usuario gana si no pierde. Después de que el usuario presione el botón mostrar en 
			una tercer etiqueta si el usuario gana o pierde. */

import javax.swing.JOptionPane;
import java.util.*;

public class Dados{
	
	public static void play () {
		Random randGen = new Random ();
		int rand = randGen.nextInt (100),
			ans = 0;
		String aux ;
		for (int i = 0; i < 6; i++) {
			aux = JOptionPane.showInputDialog ("Introduzca un numero: ");
			ans = Integer.parseInt (aux);
			if (ans == rand)
				JOptionPane.showMessageDialog (null, "Correcto!", JOptionPane.PLAIN_MESSAGE);
			if (ans < rand) 
				JOptionPane.showMessageDialog (null, "Menos", JOptionPane.PLAIN_MESSAGE);
			if (ans > rand) 
				JOptionPane.showMessageDialog (null, "Mas", JOptionPane.PLAIN_MESSAGE);
		}
		JOptionPane.showMessageDialog (null, "Se acabaron los intentos", JOptionPane.PLAIN_MESSAGE);
	}
			
	public static void main (String[] args) {
		play ();
	}
}
	
	
