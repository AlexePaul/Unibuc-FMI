#ifndef nod_H
#define nod_H

#include <iostream>

using namespace std;

template<class T>
class nod;

template<typename type>
ostream& operator <<(ostream& o, nod<type>& list);

template<typename type>
istream& operator >>(istream& in, nod<type>& list);

template <typename type>
class nod{
public:
	nod(type);
	nod();
	nod(const nod<type>&);
	void operator = (nod<type>);
	virtual void setNext(nod*);
	virtual nod<type>* getNext(){
		return next;
	}
	virtual type getValue(){	
		return value;
	}
	~nod();
	friend ostream& operator << <>(ostream&, nod<type>&);
	friend istream& operator >> <>(istream&, nod<type>&);
private:
	type value;
	nod<type>* next;
};

#endif