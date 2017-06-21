
#include <iostream>
#include "enterote.h"

using namespace std;

int main (){
	Enterote a("12345678"), b("987654321"), c;

	c.add(a, b);
	c.output();

	return 0;
}