#include "../include/doubleLL.h"
#include "../include/nod.h"
#include "nodDublu.cpp"
#include "nod.cpp"
#include <iostream>

using namespace std;

template<typename type>
int doubleLL<type>::x;

template<typename type>
doubleLL<type>::doubleLL(){
	this->size = 0;
	this->front = NULL;
	this->back = NULL;
}

template<typename type>
doubleLL<type>::doubleLL(const doubleLL& list){
	this->size = list.size;
	this->front = list.front;
	this->back = list.back;
}

template<typename type>
doubleLL<type>::~doubleLL(){
	nod<type>* x = this->front;
	nod<type>* x2 = this->front->getNext();
	for(int i = 0; i < this->size-1; i++){
		delete x;
		x = x2;
		x2 = x2->getNext();
	}
}

template<typename type>
void doubleLL<type>::push_back(type element){
	if(this->front == NULL){
		nodDublu<type>* x = new nodDublu<type>(element);	
		this->front = x;
		this->back = x;
	}
	else{
		nodDublu<type>* x = new nodDublu<type>(element);
		x->setNext(NULL);
		this->back->setNext(x);
		x->setPrev(this->back);
		this->back = x;
	}
	this->size++;
}

template<typename type>
void doubleLL<type>::pop_back(){
	nod<type>* x = this->back->getPrev();
	delete this->back;
	this->back = dynamic_cast< nodDublu<type>* >(x); // downcast
	this->size--;
}

template<typename type>
nod<type>& doubleLL<type>::operator [](unsigned index){
	if(index >= this->size)
		throw "Index Overflow";
	nod<type>* x = this->front;
	for(int i = 0; i < index; i++)
		x = x->getNext();
	return *x;
}

template<typename type>
ostream& operator <<(ostream& o, doubleLL<type>& list){ // afisarea a n obiecte
	nod<type>* x = list.front; //upcast
	for(int i = 0; i < list.getSize(); i++){
		o << *x << ' ';
		x = x->getNext();
	}
	o << '\n';
	return o;
}

template<typename type>
istream& operator >>(istream& in, doubleLL<type>& list){ // citirea completa a n obiecte
	int s;
	type x;
	cout << "Numarul de numere citite: ";
	in >> s;
	for(int i = 0; i < s; i++){
		cout << "al " << i+1 << "-lea element este: ";
		in >> x;
		list.push_back(x);	
	}
	return in;
}

template<typename type>
void doubleLL<type>::operator = (doubleLL<type> list){
	this->front = list.front;
	this->back = list.back;
	this->size = list.size;
}