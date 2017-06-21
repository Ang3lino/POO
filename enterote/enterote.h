
#ifndef ENTEROTE_H
#define ENTEROTE_H

#include <vector>
#include <string>
#include <stack>

using namespace std;

class Enterote{
public:
	Enterote (string = "0");
	~Enterote ();
	
	void input (string);
	void output ();
	void add (Enterote, Enterote);
	void minus (Enterote, Enterote);

	int digits ();
	int getDigit (int);
private:
	vector <int> m;
};

void fillStacks (stack <int> &, stack <int> &, Enterote, Enterote);

#endif
