
#include <iostream>
#include "rational.h"

using namespace std;

int main (){
	Rational a, b(30, 20), c(15, 3);

	a.showNatural ();
	b.showNatural();
	c.showNatural();

	a.sum (b, c);
	a.showFloat ();

	return 0;
}