
#ifndef COMPLEX_H
#define COMPLEX_H

class Complex{
public:
	Complex (double = 0, double = 0);
	~Complex ();
	void show ();
	void set (double, double);
	void add (Complex, Complex);
	double re ();
	double im ();
private:
	double Re, Im;
};

#endif
