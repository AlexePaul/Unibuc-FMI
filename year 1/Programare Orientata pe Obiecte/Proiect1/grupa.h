#ifndef grupa_H
#define grupa_H

#include "student.h"
#include <vector>

class grupa{
public:
	grupa();
	grupa(const grupa&);
	void adaugaStudent(student);
	void adaugaStudent(string, unsigned int, unsigned int);
	void scoateStudent(string);
	double mediaGrupei();
	student getStudent(int);
	friend ostream& operator << (ostream&, grupa&);
	friend istream& operator >> (istream&, grupa&);
private:
	vector<student> listaStudenti;
	unsigned int numarStudenti;
};

#endif