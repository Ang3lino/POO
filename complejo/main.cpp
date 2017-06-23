
#include <iostream>
#include "complex.h"

using std::cout;

int main (){
	Complex u, v(0,1), z(0, 0.5);

	for (int k = 0; k < 999999; k++){
		u = u + fcPow (z, k);
		cout << u << "\t";
	}
	cout << "\n";

	return 0;
}
