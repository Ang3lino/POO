
#include <iostream>
#include "complex.h"

using std::cout;

Complex::Complex (double x, double y){
	Re = x;
	Im = y;
}

Complex::~Complex (){}

double Complex::re (){ return Re; }

double Complex::im (){ return Im; }

void Complex::show (){
	cout << "(" << Re << ", " << Im << ")\n";
}
void Complex::set (double a, double b){
	Re = a;
	Im = b;
}

void Complex::add (Complex a, Complex b){
	 Re = a.re() + b.re();
	 Im = a.im() + b.im();
}
