
/*	Programa que intenta hacer el recorrido del caballo hamiltoniano mediante 
 *	fuerza bruta, no siempre recorre los 64 cuadros.	*/

import java.util.Scanner;
import java.util.Random;
//import static Matrix.*;  // Se puede?

public class Knight
{
	// retorna un valor aleatorio comprendido en a + (0, b].
	public static int rand (int a, int b){
		Random aleat = new Random ();
		return a + aleat.nextInt (b + 1);
	}	

	public static void main (String args[]){
		int tries = 0;

		while (!trySolve ()){
			tries++;
			if (tries % 1000 == 0)
				System.out.printf ("%d\t", tries);
		} 

		System.out.println (tries);
	}

	// al ejecutar las intrucciones: x += hor[move], y += ver[move] el caballo se movera dependiendo
	// del valor move, , por ejemplo, si es 0, el caballo se movera 2u a la drcha y -1u a la derecha.
	
	public static boolean trySolve (){
		int board[][] = Matrix.newMat (8, 8);
		int[] hor = { 2, 1, -1, -2, -2, -1, 1, 2 },
			  ver = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int x = rand (0, 7), y = rand (0, 7), move;
		boolean repeated[] = new boolean[8]; //  para marcar a lo mucho los 8 elementos de hor, ver.
		
		Matrix.setMatPos (board, x, y, 1);
		for (int cont = 2, x1, y1; cont <= 64; cont++){
			x1 = x;
			y1 = y;
			move = rand (0, 7);
			x += hor[move];
			y += ver[move];
			for (int i = 0; i < repeated.length; i++)
				repeated[i] = false;
			while (!Matrix.setMatPos (board, x, y, cont)){  //posicion invalida
				repeated[move] = true;
				move = rand (0, 7);
				if (repeated[move]){  
					move = getNewMove (repeated);
					if (move == -1)
						return false;
				}
				x = x1 + hor[move];
				y = y1 + ver[move];
			}
			if (cont >= 61)
				Matrix.showMat (board);
		}

		return true;
	}

	public static int getNewMove (boolean[] repeated){
		int go = rand (0, 7);

		if (allRepeated (repeated) == true)
			return -1;
		if (repeated[go] == true) 
			go = getNewMove (repeated);

		return go;
	}

	public static boolean allRepeated (boolean[] array){
		
		for (int i = 0; i < array.length; i++){
			if (array[i] == false)
				return false;
		}

		return true;
	}
}

