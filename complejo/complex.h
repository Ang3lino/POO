
#ifndef COMPLEX_H
#define COMPLEX_H

#include <iomanip> // se supone que las cabeceras van en el .h...

using namespace std;

class Complex{
	friend ostream &operator<< (ostream &, Complex &);
	friend istream &operator>> (istream &, Complex &);

	friend Complex icPow (Complex, int);
	friend Complex fcPow (Complex, double);

public:
	Complex (double = 0, double = 0);
	~Complex ();

	Complex operator+ (const Complex &) const; 
	Complex operator- (const Complex &) const; 
	Complex operator* (const Complex &) const; 
	Complex operator/ (const Complex &) const; 
	Complex operator^ (const Complex &) const;
	bool operator== (const Complex &) const;
	bool operator!= (const Complex &) const;

	void show () const;
	void set (double, double);
	void add (Complex, Complex);

	Complex conjugate () const;
	
	double abs () const;
	double Re ();
	double Im ();

private:
	double re, im;
};

#endif
