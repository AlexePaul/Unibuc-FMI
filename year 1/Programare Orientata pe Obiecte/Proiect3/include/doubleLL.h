#ifndef doubleLL_H
#define doubleLL_H

#include "nodDublu.h"
#include <iostream>

using namespace std;

template<class T>
class doubleLL;

template<typename type>
ostream& operator <<(ostream& o, doubleLL<type>& list);

template<typename type>
istream& operator >>(istream& in, doubleLL<type>& list);

template <typename type>
class doubleLL{
	public:
		static void setX(int x1){
			x = x1;
		}
		doubleLL();
		doubleLL(const doubleLL&);
		void push_back(type);
		nod<type>& operator[](unsigned int);
		int getSize(){
			return this->size;
		}
		void operator = (doubleLL<type>);
		void pop_back();
		friend ostream& operator << <>(ostream&, doubleLL<type>&);
		friend istream& operator >> <>(istream&, doubleLL<type>&);
	private:
		nodDublu<type>* front;
		nodDublu<type>* back;
		int size;	
		static int x; //nu aveam ce data statica sa am
};

#endif