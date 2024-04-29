#include "student.h"
#include <string>
#include <vector>
#include <iostream>

using namespace std;

student::student(){
	this->nume = "";
	this->anulNasterii = 0;
	this->numarCredite = 0;
}

student::student(string nume, int anulNasterii, int numarCredite){
	this->nume = nume;
	this->anulNasterii = anulNasterii;
	this->numarCredite = numarCredite;
}

student::student(const student &t){
	this->nume = t.nume;
	this->anulNasterii = t.anulNasterii;
	this->numarCredite = t.numarCredite;
}

void student::setAnulNasterii(int anulNasterii){
	this->anulNasterii = anulNasterii;
}

void student::setNumarCredite(int numarCredite){
	this->numarCredite = numarCredite;
}

void student::setNume(string nume){
	this->nume = nume;
}

int student::getAnulNasterii(){
	return this->anulNasterii;
}

int student::getNumarCredite(){
	return this->numarCredite;
}

string student::getNume(){
	return this->nume;
}


student student::operator +(student b){
	student returnStudent(*this);
	returnStudent.numarCredite += b.numarCredite;
	return returnStudent;
}

student student::operator -(student b){
	student returnStudent(*this);
	returnStudent.numarCredite -= b.numarCredite;
	return returnStudent;
}

void student::operator +=(student b){
	this->numarCredite += b.numarCredite;
}

void student::operator -=(student b){
	this->numarCredite -= b.numarCredite;
}

bool student::operator ==(student b){
	if(this->numarCredite == b.numarCredite && this->nume == b.nume && this->anulNasterii == b.anulNasterii)
		return true;
	return false;
}

bool student::operator !=(student b){
	if(this->numarCredite == b.numarCredite && this->nume == b.nume && this->anulNasterii == b.anulNasterii)
		return false;
	return true;
}

ostream& operator <<(ostream &o, student &t){
	o << "Numele studentului este: " << t.nume << '\n';
	o << "Anul nasterii studentului este: " << t.anulNasterii << '\n';
	o << "Numarul de credite ale studentului este: " << t.numarCredite << '\n';
	return o;
}

istream& operator >> (istream &i, student &t){
	cout << "Numele studentului este: ";
	i >> t.nume; 
	cout << "Anul nasterii studentului este: ";
	i >> t.anulNasterii;
	cout << "Numarul de credite ale studentului este: ";
	i >> t.numarCredite;
	return i;
}