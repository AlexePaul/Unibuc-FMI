#ifndef student_H
#define student_H

#include <string>
#include <iostream>

using namespace std;

class student{
public:
	student();
	student(string nume, int anulNasterii, int numarCredite);
	student(const student &t);
	void setAnulNasterii(int anulNasterii);
	void setNumarCredite(int numarCredite);
	void setNume(string nume);
	int getAnulNasterii();
	int getNumarCredite();
	string getNume();
	student operator +(student b);
	student operator -(student b);
	void operator +=(student b);
	void operator -=(student b);
	bool operator ==(student b);
	bool operator !=(student b);

	friend ostream& operator << (ostream&, student&);
	friend istream& operator >> (istream&, student&);
private:
	int anulNasterii,numarCredite;
	string nume;
};

#endif