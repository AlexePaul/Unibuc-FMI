#include "grupa.h"
#include "student.h"
#include <iostream>

grupa::grupa():listaStudenti(0){
	numarStudenti = 0;
}

grupa::grupa(const grupa& g){
	this->listaStudenti = g.listaStudenti;
	this->numarStudenti = g.numarStudenti;
}

double grupa::mediaGrupei(){
	double medie = 0;
	for(int i = 0; i < numarStudenti; ++i)
		medie += listaStudenti[i].getNumarCredite();
	return medie/numarStudenti;
}

void grupa::adaugaStudent(string nume, unsigned int anulNasterii, unsigned int numarCredite){
	student newStudent(nume, anulNasterii, numarCredite);
	this->listaStudenti.push_back(newStudent);
	this->numarStudenti++;
}

void grupa::adaugaStudent(student newStudent){
	this->listaStudenti.push_back(newStudent);
	this->numarStudenti++;	
}

student grupa::getStudent(int position){
	if(position < numarStudenti)
		return listaStudenti[position];
	return listaStudenti[0];
}

void grupa::scoateStudent(string nume){
	for(int i = 0; i < numarStudenti; ++i){
		if(listaStudenti[i].getNume() == nume)
			listaStudenti.erase(listaStudenti.begin()+i);
	}
}

istream& operator >> (istream &i, grupa &grupaToRead){
	student studentToRead;
	cout << "Numarul de elevi din grupa este: ";
	i >> grupaToRead.numarStudenti;
	for(int j = 0; j < grupaToRead.numarStudenti; ++j){
		string nume;
		unsigned int anulNasterii,numarCredite;
		cout << "Numele studentului " << j+1 << " este: ";
		i.ignore();
		getline(i, nume);
		cout << "Anul nasterii studentului " << j+1 << " este: ";
		i >> anulNasterii;
		cout << "Numarul de credite ale studentului " << j+1 << " este: ";
		i >> numarCredite;
		cout << '\n';
		studentToRead.setNume(nume);
		studentToRead.setAnulNasterii(anulNasterii);
		studentToRead.setNumarCredite(numarCredite);
		grupaToRead.listaStudenti.push_back(studentToRead);
	}
	return i;
}

ostream& operator <<(ostream &o, grupa &grupaToPrint){
	o << "Grupa contine " << grupaToPrint.numarStudenti << " studenti\n";
	for(int j = 0; j < grupaToPrint.numarStudenti; ++j){
		o << "\nNumele studentului " << j+1 << " este: " << grupaToPrint.listaStudenti[j].getNume() << '\n';
		o << "Anul nasterii studentului " << j+1 << " este: " << grupaToPrint.listaStudenti[j].getAnulNasterii() << '\n';
		o << "Numarul de credite ale studentului " << j+1 << " este: " << grupaToPrint.listaStudenti[j].getNumarCredite() << '\n';
	}
	return o;
}