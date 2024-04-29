#include "student.h"
#include "grupa.h"
#include <iostream>

using namespace std;

void fluxTestare1(){
	grupa gr1, gr2;
	cin >> gr1 >> gr2;
	student st, st2;
	cin >> st >> st2;
	if(st == st2){
		cout << "studentul care va fii adaugat in grupa 1 este acelasi cu cel care va fii scos din grupa 2\n";
	}
	else if(st != st2){
		cout << "studentul care va fii adaugat in grupa 1 nu este acelasi cu cel care va fii scos din grupa 2\n";
	}
	gr1.adaugaStudent(st);
	gr2.scoateStudent(st2.getNume());
	cout << "grupa1: \n" << gr1 << '\n';
	cout << "grupa2: \n" << gr2 << '\n';
}

void fluxTestare2(){
	grupa gr1;
	cin >> gr1;
	student st1, st2;
	cin >> st1 >> st2;
	st1 += st2;
	cout << "Media Grupei inainte de adaugarea noului student: " << gr1.mediaGrupei() << '\n';
	gr1.adaugaStudent(st1);
	cout << "Media Grupei dupa de adaugarea noului student: " << gr1.mediaGrupei() << '\n';
}

int main(){

	fluxTestare1();
	fluxTestare2();
	return 0;
}