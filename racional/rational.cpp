
#include <iostream>
#include <vector>
#include <cmath> // al final -lm para compilar esta biblio desde consola
#include <cstdlib>
#include "rational.h"

using namespace std;

//	2 3 4n 5 6n 7 8n 9n 

/*	Funcion que ejecuta la criba de Eratostenes, donde p[i] representara 
	el numero i-esimo, al final, tendremos un vector de bool tal que si 
	p[i] = true, entonces i sera primo.

	Empezamos desde el numero 2 (puesto que empezar desde 0 o 1 no tiene 
	sentido, pues no son primos) y vamos "tachando" los numeros multiplos en la 
	posicion i.	*/

void criba (vector <bool> &p){
	p[0] = p[1] = false;
	for (int i = 2; i < p.size(); i++){
		if (p[i] == false)
			continue;
		for (int j = 2 * i; j < p.size (); j += i)
			p[j] = false;		
	}

}

//	EXIT_FAILURE = 1

Rational::Rational (int a, int b){
	if (b == 0)
		exit (EXIT_FAILURE);
	num = a;
	den = b;

	/*	La funcion miembro resize, como su nombre lo dice, redimensiona el 
		vector, los nuevos elementos tomaran el valor del segundo argumento.	*/ 

	primes.resize (fmax (abs (num), abs (den)), true);
	criba (primes);
	simplify ();
}

Rational::~Rational (){}

/*	Comprobaremos si tanto el num como den son divisibles por la lista de
	primos generada previamente, mientras que estos lo sean, dividiremos 
	por este primo tanto arriba como abajo.	*/

void Rational::simplify (){
	for (int i = 2; i < primes.size(); i++){
		if (primes[i] == false)
			continue;
		while (num % i == 0 && den % i == 0){
			num /= i;
			den /= i;
		}
	}
}

void Rational::showNatural (){ cout << num << "/" << den << endl; }

void Rational::showFloat (){ cout << (float) num / den << endl; }

int Rational::numerator (){ return num; }

int Rational::denominator (){ return den; }

void Rational::sum (Rational p, Rational q){
	int a = p.numerator() * q.denominator();
	int b = q.numerator() * p.denominator();
	int c = p.denominator() * q.denominator();

	num = a + b;
	den = c;
	primes.resize (fmax (abs (num), abs (den)), true);
	criba (primes);
	simplify ();
}

void Rational::substract (Rational p, Rational q){
	int a = p.numerator() * q.denominator();
	int b = q.numerator() * p.denominator();
	int c = p.denominator() * q.denominator();

	num = a - b;
	den = c;
	primes.resize (fmax (abs (num), abs (den)), true);
	criba (primes);
	simplify ();
}

void Rational::product (Rational p, Rational q){
	num = p.numerator() * q.numerator();
	den = p.denominator() * q.denominator();

	//	fmax retorna el valor maximo de dos valores

	primes.resize (fmax (abs (num), abs (den)), true);
	criba (primes);
	simplify ();
}

void Rational::quotient (Rational p, Rational q){
	num = p.numerator() * q.denominator();
	den = q.numerator() * p.numerator();
}
