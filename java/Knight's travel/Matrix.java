
import java.util.Scanner;
import java.util.Random;

public class Matrix
{
	private int ROWS, COLUMNS;
	private double[][] MATRIX;

	public static double[][] floatMat(int m, int n)
	{
		double[][] MATRIX; // shadowing

		MATRIX = new double[m][];
		for (int i = 0; i < m; i++)
			MATRIX[i] = new double[n]; return MATRIX;
	}
	
	public static int[][] newMat(int m, int n)
	{
		int[][] matrix;

		matrix = new int[m][];
		for (int i = 0; i < m; i++)
			matrix[i] = new int[n];

		return matrix;
	}

	public static int[][] newMat(int m, int n, int standard)
	{
		int[][] matrix;

		matrix = new int[m][];
		for (int i = 0; i < m; i++)
			matrix[i] = new int[n];
		
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = standard;

		return matrix;
	}

	public static void showMat (int[][] matrix)
	{
		System.out.println ();
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++)
				System.out.printf ("%d\t", matrix[i][j]);
			System.out.printf ("\n");
		}
		System.out.println ();
	}
	
	public static void setMat (int[][] matrix)
	{
		Scanner input = new Scanner (System.in);

		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
				System.out.printf ("A(%d, %d): ", i, j);
				matrix[i][j] = input.nextInt ();
			}
		}
	}

	public static boolean setMatPos (int[][] mat, int x, int y, int value)
	{
		if (y < 0 || x < 0 || x >= mat.length || y >= mat[0].length)
			return false;
		//	Statement required for Knight only	
		if (mat[x][y] != 0)
			return false;

		mat[x][y] = value;
		return true;
	}

}

