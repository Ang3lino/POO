
#include <iostream>
#include <vector>
#include <stack>
#include "enterote.h"

using namespace std;

//	Asumo que la cadena solo contiene caracteres numericos

Enterote::Enterote (string start){
	if (start.size() == 1 && start[0] == '0')
		m.push_back (0);
	else	
		for (int i = 0; i < start.size(); i++)
			m.push_back( start[i] - '0' );	
}

Enterote::~Enterote (){}

int Enterote::getDigit (int i){ return m[i]; }

int Enterote::digits (){ return m.size(); }

void printStack (stack <int> s){
	while (!s.empty()){
		cout << s.top();
		s.pop();
	}
	cout << endl;
}

void fillStacks (stack <int> &p, stack <int> &q, Enterote a, Enterote b){
	int n, i, j = 0;

	if (a.digits() > b.digits()){
		n = a.digits() - b.digits();
		for (i = 0; i < a.digits(); i++)
			p.push (a.getDigit(i));
		for (i = 0; i < n; i++)
			q.push (0);
		while (i < a.digits()){
			q.push(b.getDigit(j++));
			i++;
		}
	} else { // |b| >= |a|
		n = b.digits() - a.digits();
		for (i = 0; i < b.digits(); i++)
			p.push (b.getDigit(i));
		for (i = 0; i < n; i++)
			q.push (0);
		while (i < b.digits()){
			q.push(a.getDigit(j++));
			i++;
		}
	}

	//printStack (p);
	//printStack (q);

}

// asumo que a >= b >= 0

void Enterote::minus (Enterote a, Enterote b){
	stack <int> p, q, r;
	int x, u, v;

	fillStacks (p, q, a, b);
	while (!p.empty()){
		u = p.top(); p.pop();
		v = q.top(); q.pop();
		x = u - v;
		if (x < 0){
			q.top()++;
			x += 10;
		}
		r.push(x);
	}
	x = 0;
	while (!r.empty()){
		m[x++] = r.top(); r.pop();
	}
}

/*	El numero con mas digitos sera guardado en la pila p por medio de fillStacks*/

void Enterote::add (Enterote a, Enterote b){
	stack <int> p, q, r;
	int acum = 0, llevo = 0, j = 0, u, v;
	
	fillStacks (p, q, a,  b);
	while (!p.empty()){
		u = p.top(); p.pop();
		v = q.top(); q.pop();
		acum = u + v + llevo;
		if (acum >= 10){
			llevo = 1;
			acum -= 10;
		} else
			llevo = 0;
		r.push(acum);
	}
	if (llevo == 1)
		r.push(1);
	m.clear();
	while (!r.empty()){
		m.push_back(r.top());
		r.pop();
	}
}

void Enterote::input(string data){
	for (int i = 0; i < data.size(); i++)
		m[i] = data[i] - '0';
}

void Enterote::output (){
	for (int i = 0; i < m.size(); i++)
		cout << m[i];
	cout << "\n";
}
