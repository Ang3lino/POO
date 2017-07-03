
/*	Programa que opera dos cadenas	*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "ColaDin.h"

#define MAXSIZE 100

/*	Dada una queue con un elemento que contiene un char letra, esta funcion retorna 
	una cadena con base a c.	*/
char *queueToString (cola *c){
	char *s = (char *) calloc (Size (c), sizeof (char));
	int i = 0;
	elemento e;

	while (!Empty (c)){
		e = Dequeue (c);
		s[i++] = e.letra;
	}

	return s;
}

/*	Dada una cadena s, la funcion retorna la cadena w ^ n.	*/
char *potency (char *s, int n){
	int i = 0, j = 0;
	elemento e;
	char *ns;
	cola c;

	Initialize (&c);
	for (i = 0; i < n; i++)
		for (j = 0; j < strlen (s); j++){
			e.letra = s[j];
			Queue (&c, e);
		}
	ns = queueToString (&c);
	Destroy (&c);
	
	return ns;
}

/*	Dadas las palabras x, y, el programa retornara z = xy	*/
char *concatenate (char *x, char *y){
	int i = 0;
	elemento e;
	cola z;
	char *s;

	Initialize (&z);
	for (i = 0; i < strlen (x); i++){
		e.letra = x[i];
		Queue (&z, e);
	}
	for (i = 0; i < strlen (y); i++){
		e.letra = y[i];
		Queue (&z, e);
	}
	s = queueToString (&z);
	Destroy (&z);
	
	return s;
}

/*	Dada una cadena s el programa imprimira todos los prefijos de s.
	En las tres funciones siguientes se obvio a Epsilon. */
void prefixes (char *s){
	int n = strlen (s), i, j;

	for (i = 0; i < n; i++){
		for (j = 0; j < i; j++){
			printf ("%c", s[j]);
		}	
		printf ("\n");
	}	

}

/*	Dada una cadena s la funcion imprimira todos los sufijos de s */
void 
sufixes (char *s){
	int i, j;

	for (i = 0; i < strlen (s); i++){
		for (j = i; j < strlen (s) ; j++)
			printf ("%c", s[j]);
		printf ("\n");
	}

}

/*	Dada una palabra s, imprimiremos las subcadenas de s	*/
void 
substrings (char *s){
	int i, j, k = 0, l = 0, m = strlen (s);

	for (l = 0; l < m; l++){
		for (i = 0; i < m - l; i++){
			k = 0;
			for (j = i; k < l + 1; k++)
				printf ("%c", s[j++]);
			printf (" ");
		}
		printf("\n");
	}

}

int 
main (){
	char *a = (char *) calloc (MAXSIZE, sizeof (char));
	char *b = (char *) calloc (MAXSIZE, sizeof (char));
	char *s;
	
	strcpy (a, "the king of fighters");
	strcpy (b, "que haces viendo mi repositorio");

	s = potency (a, 5);
	prefixes (a);
	sufixes (a);
	substrings (a);

	return 0;
}

/*	Falta que el usuario tenga el control, pero es lo de menos	
void input (char *a, char *b){
	int opcion = 6;
	char *s;

	printf ("Introduzca la cadena A: ");
	fgets (a, MAXSIZE, stdin);
	printf ("Introduzca la cadena B: ");
	fgets (b, MAXSIZE, stdin);

	do{
		puts (" Opciones:");
		puts ("	1.- Concatenar la cadena");
		puts ("	2.- Obtener la potencia");
		puts ("	3.- Generar prefijos");
		puts ("	4.- Generar sufijos");
		puts ("	5.- Generar subcadenas");
		puts ("	6.- Salir");

		scanf ("%d", &opcion);

		switch (opcion){
			case 1: concatenate (a, b); break;
			case 2: potency (a, 3); break;
			case 3: prefixes (a); break;
			case 4: sufixes (a); break;
			case 5: substrings (a); break;
			case 6: puts ("adios :D"); break;
			default: puts ("OPCION INVALIDA, WEY"); break;
		}	
	} while (opcion != 6);
}
*/
