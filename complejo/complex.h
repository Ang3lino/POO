
#ifndef COMPLEX_H
#define COMPLEX_H

#include <iomanip> // se supone que las cabeceras van en el .h...

using namespace std;

class Complex{
	friend ostream &operator<< (ostream &, Complex &);
	friend istream &operator>> (istream &, Complex &);

public:
	Complex (double = 0, double = 0);
	~Complex ();

	Complex operator+(const Complex &) const; 
	Complex operator-(const Complex &) const; 
	Complex operator*(const Complex &) const; 
	Complex operator/(const Complex &) const; 


	void show () const;
	void set (double, double);
	void add (Complex, Complex);
	
	double Re ();
	double Im ();

private:
	double re, im;
};

#endif
