
#include <iostream>
#include "complex.h"

using std::cout;

int main (){
	Complex u(4, 1), v(5, 9), z;

	z.add (u, v);
	z.show();

	z = u + v;
	z.show();

	z = u - v;
	z.show();

	z = u * v;
	cout << z << endl;

	z = u / v;
	z.show();


	return 0;
}
