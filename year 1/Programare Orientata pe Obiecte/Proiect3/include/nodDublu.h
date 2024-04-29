#ifndef nodDublu_H
#define nodDublu_H

#include "nod.h"

template <typename type>
class nodDublu : public nod<type>{
public:
	nodDublu();
	nodDublu(type);
	nodDublu(const nodDublu<type>&);
	void setPrev(nod<type>*);
	nod<type>* getPrev();
	~nodDublu();	
	void operator = (nodDublu<type>);
private:
	nod<type>* prev;
};

#endif