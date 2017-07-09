
/*	Programa que intenta hacer el recorrido del caballo hamiltoniano mediante 
 *	fuerza bruta, no siempre recorre los 64 cuadros.	*/

import java.util.Scanner;
import java.util.Random;

public class Knight
{
	public static int rand (int a, int b){
		Random aleat = new Random ();
		return a + aleat.nextInt (b);
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

	public static boolean trySolve (){
		int board[][] = Matrix.newMat (8, 8);
		int[] hor = { 2, 1, -1, -2, -2, -1, 1, 2 },
			  ver = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int x, y, move;
		boolean repeated[] = new boolean[7]; //  para marcar a lo mucho los 7 elementos de hor, ver.
		
		x = rand (0, 7);
		y = rand (0, 7);
		Matrix.setMatPos (board, x, y, 1);
		for (int cont = 2, x1, y1; cont <= 64; cont++){
			x1 = x;
			y1 = y;
			move = rand (0, 7);
			x += hor[move];
			y += ver[move];
			for (int i = 0; i < repeated.length; i++)
				repeated[i] = false;
			while (!Matrix.setMatPos (board, x, y, cont)){
				repeated[move] = true;
				move = rand (0, 7);
				while (repeated[move]){
					move = rand (0, 7);
					if (allRepeated (repeated)){
					//	Matrix.showMat (board);
						return false;
					}
				}
				x = x1 + hor[move];
				y = y1 + ver[move];
			}
			if (cont >= 60)
				Matrix.showMat (board);
		}
		Matrix.showMat (board);

		return true;
	}

	public static boolean allRepeated (boolean[] array){

		for (int i = 0; i < array.length; i++){
			if (array[i] == false)
				return false;
		}

		return true;
	}
}

