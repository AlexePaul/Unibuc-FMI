#ifndef repoList_H
#define repoList_H

#include "doubleLL.h"
#include <vector>

//repository design pattern, holds information about n objects stored in vect

template<typename type>
class repoList{
private:
	vector<doubleLL<type>> vect;
public:
	repoList(){}
	void push_back(doubleLL<type> t){
		vect.push_back(t);
	}
	void resize(int nr){
		vect.resize(nr);
	}
	doubleLL<type>& operator[](unsigned int);
	void pop_back(doubleLL<type> t){
		vect.pop_back();
	}
};

#endif