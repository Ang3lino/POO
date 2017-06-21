
#include <iostream>
#include "enterote.h"

using namespace std;

int main (){
	Enterote a("0"), b("1"), c;

	// 0, 1, 1, 2, 3, 5, 8, ...
	for (int i = 0; i < 1e4; i++){
		a = b;
		b = c;
		c.add (a, b);
		c.output();
	}

	return 0;
}
