
#include "complex.h"
#include <cmath>
#include <iostream>
#include <iomanip>

using namespace std;

//	Constructores	==================================================== 
Complex::Complex (double x, double y){
	re = x;
	im = y;
}

Complex::~Complex (){}

//	Sobrecarga de operadores	========================================
Complex Complex::operator+(const Complex &z2) const{
	return Complex (re + z2.re,im + z2.im);
}

Complex Complex::operator-(const Complex &z2) const{
	Complex z(re - z2.re, im - z2.im);
	return z;
}

// (a, b)(c, d) = (ac - bd, ad + bc)
Complex Complex::operator*(const Complex &z2) const{
	Complex z(re*z2.re - im*z2.im, re*z2.im + im*z2.re);
	return z;
}

/*	Sean u, v, w complejos, entonces si se ejecuta en el fuente: 
		w = u / v 
	en la funcion u = (re, im), v = (z2.re, z2.im).
	Para obtener el cociente, si u = (a, b), v = (c, d), entonces
		u / v = (1 / (c^2 + d^2))(ac + bd, bc - ad)		*/
Complex Complex::operator/ (const Complex &z2) const{
	double esc = (pow(z2.re, 2) + pow(z2.im, 2));
	double x = re*z2.re + im*z2.im;
	double y = im*z2.re - re * z2.im;

	return Complex (x / esc, y / esc);
}

/*	Al invocar << se llamara a esta funcion con dos argumentos, en la 
	cual output "sera como una cadena" que se retornara para mostrar 
	por pantalla los atributos de z.	*/
ostream &operator<< (ostream &output, Complex &z){
	output << "(" << z.re << ", " << z.im << ")";

	return output;
}

/*	Al invocar >> se llamara esta funcion donde input se usara como se 
	muestra aqui abajo, parecida al cin; al final se retornara.		*/
istream &operator>> (istream &input, Complex &z){
	cout << "re: ";
	input >> z.re;
	cout << "im: ";
	input >> z.im;

	return input;																																																																																																																																																																																																																																																																																																																																																																									
}

bool Complex::operator== (const Complex &zri) const{
	if (re == zri.re && im == zri.im)
		return true;
	return false;
}	

// Si se hace u != v, entonces this es el apuntador a u
bool Complex::operator!= (const Complex &zri) const{
	return !(*this == zri);
}

//	Funciones miembro	================================================
double Complex::Re (){ return re; }

double Complex::Im (){ return im; }

void Complex::show () const{
	cout << "(" << re << ", " << im << ")\n";
}

void Complex::set (double a, double b){
	re = a;
	im = b;
}

void Complex::add (Complex a, Complex b){
	 re = a.re + b.re;
	 im = a.im + b.im;
}

Complex Complex::conjugate () const{
	return Complex (re, -im);
}

// |z| = (z * z.conjugate()) ^ (1 / 2)
double Complex::abs () const {
	return sqrt (pow (re, 2) + pow (im, 2));
}

//	Funciones compa		===============================================

Complex icPow (Complex z, int n){
	Complex aux(1, 0);
	
	if (n >= 0)
		for (int i = 0; i < n; i++)
			aux = aux * z;
	else if (n < 0){
		Complex realUnity (1);
		for (int i = 0; i < -n; i++)
			aux = aux * z;
		aux = realUnity / aux;
	}

	return aux;
}

Complex fcPow (Complex z, double n){
	double r = z.abs();
	double tetha = atan (z.im / z.re);
	
	return Complex (pow (r, n) * cos (n * tetha),
					pow (r, n) * sin (n * tetha));
}
