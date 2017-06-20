
#ifndef RATIONAL_H
#define RATIONAL_H

//	Las cabeceras que contengan clases van en cada archivo
#include <vector>
//	Esta linea no se incluye en todos los archivos, por lo que si se le requiere
//	en otro archivo, se tendra que poner otra vez
using namespace std;

class Rational{
public:
	Rational (int = 0, int = 1);
	~Rational ();
	
	void simplify ();
	void sum (Rational, Rational);
	void substract (Rational, Rational);
	void product (Rational, Rational);
	void quotient (Rational, Rational);
	void showNatural ();
	void showFloat ();

	int numerator ();
	int denominator ();

private:
	int num, den;
	vector <bool> primes;
};

void criba (vector <bool> &);

#endif
