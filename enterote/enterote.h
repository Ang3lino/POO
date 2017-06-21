
#ifndef ENTEROTE_H
#define ENTEROTE_H

#include <vector>
#include <string>

using namespace std;
typedef long long int BINT;

class Enterote{
public:
	Enterote (string = "0");
	~Enterote ();
	
	void input (long long int);
	void output ();
	void add (Enterote, Enterote);
	void substract (Enterote, Enterote);

	int getDigit (int);
private:
	vector <int> m;
};

#endif
