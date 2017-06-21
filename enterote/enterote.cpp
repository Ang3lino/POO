
#include <iostream>
#include <vector>
#include <cmath>
#include <stack>

using namespace std;

//	Asumo que la cadena solo contiene caracteres numericos

Enterote::Enterote (string start){
	if (start.size == 1 && start[0] == '0')
		m.push_back (0);
	else	
		for (int i = 1; i <= start.size(); i++)
			m.push_back( start[i] - '0' );	
}

Enterote::~Enterote (){}

int Enterote::getDigit (int i){ return n[i]; }

/*	El numero con mayor no. de digitos sera guardado en la pila p */

void Enterote::add (Enterote a, Enterote b){
	stack <int> p, q, r;
	int acum = 0, llevo = 0, j = 0;
	if (a.size() > b.size()){
		for (int i = 0; i < a.size(); i++)
			p.push_back (a[i]);
		for (int i = 0; i < b.size(); i++)
			q.push_back (b[i]);
		while (b.size() < a.size())
			q.push_back(0);
	} else{
		for (int i = 0; i < b.size(); i++)
			p.push_back (b[i]);
		for (int i = 0; i < a.size(); i++)
			q.push_back (a[i]);
		while (a.size() < b.size())
			q.push_back(0);
	}
	while (!p.empty() && !q.empty()){
		acum = p.pop() + q.pop() + llevo;
		if (acum >= 10){
			llevo = 1;
			acum -= 10;
		} else
			llevo = 0;
		r.push_back(acum);
	}
	if (llevo == 1)
		r.push_back(1);
	while (!r.empty())
		m[j++] = r.pop ();
}
