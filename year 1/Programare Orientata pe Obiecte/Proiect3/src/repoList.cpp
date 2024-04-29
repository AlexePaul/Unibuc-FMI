#include "../include/repoList.h"
#include "../include/doubleLL.h"

using namespace std;

template<typename type>
doubleLL<type>& repoList<type>::operator[](unsigned int i){
	if(i >= vect.size())
		throw "Index Error";
	return vect[i];
}