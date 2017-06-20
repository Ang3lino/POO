
#include <iostream>
#include <ctime>
#include "clock.h"

using namespace std;

//	Por defecto, el reloj tendra la hora actual de la computadora
Clock::Clock (int h, int m, int s){
	if (h == 0 && m == 0 && s == 0){
		t = time(0);   // Obtenemos el tiempo actual
	    now = localtime( &t );	// Llenamos los campos de la estructura now
	    hour = now->tm_hour;
	    minute = now->tm_min;
	    second = now->tm_sec;
	} else{
		hour = h % (12 + 1);
		minute = m % 60;
		second = s % 60;	
	}
}

Clock::~Clock (){
	cout << "Reloj apagado \n";
}

void Clock::show (){
	cout << ((hour > 0 && hour < 10) ? "0" : "") << hour << ":" 
		 << ((minute >= 0 && hour < 10) ? "0" : "") << minute << ":"
		 << ((second >= 0 && second < 10) ? "0" : "") << second << "\n"; 
}

void Clock::set (int h, int m, int s){
	hour = h % 13;
	minute = m % 60;
	second = s % 60;
}
