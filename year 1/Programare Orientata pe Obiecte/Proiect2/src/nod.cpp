#include "../include/nod.h"
#include <iostream>

using namespace std;

template<typename type>
nod<type>::nod(type element){
	this->value = element;
	this->next = NULL;
}

template<typename type>
nod<type>::nod(){
	this->value = 0;
	this->next = NULL;
}

template<typename type>
void nod<type>::setNext(nod* nextToSet){
	this->next = nextToSet;
}

template<typename type>
nod<type>::nod(const nod<type>& nodToCopy){
	this->value = nodToCopy.value;
	this->next = NULL;
}

template<typename type>
nod<type>::~nod(){
	// nu am ce sa fac aici :)
}

template<typename type>
ostream& operator << (ostream& o, nod<type>& nodToPrint){
	o << nodToPrint.value;
	return o;
}

template<typename type>
istream& operator >> (istream& in, nod<type>& nodToRead){
	in >> nodToRead.value;
	return in;
}

template<typename type>
void nod<type>::operator = (nod<type> node){
	this->value = node.value;
	this->next = node.next;
}