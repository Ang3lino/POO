
#ifndef CLOCK_H
#define CLOCK_H

#include <ctime>

class Clock{
public:
	Clock (int = 0, int = 0, int = 0);
	~Clock ();
	void set (int, int, int);
	void show ();
private:
	int hour, minute, second;
	time_t t;
	struct tm *now;
};

#endif
