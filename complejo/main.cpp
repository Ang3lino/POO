
#include <iostream>
#include "complex.h"

using std::cout;

int main (){
	Complex u, v, z;

	u.show();
	v.show();

	u.set (2, 4);
	v.set (-1, -3);
	z.add(u, v);

	z.show();

	return 0;
}