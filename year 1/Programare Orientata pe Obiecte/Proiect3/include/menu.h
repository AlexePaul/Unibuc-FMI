#ifndef menu_H
#define menu_H

#include "repoList.h"
#include "nod.h"

// Singleton design pattern, no object can be created

template<typename type>
class menu{
public:
	void runMenu();
	static menu<type>* getInstance();
private: 
	void clear();
	static menu<type>* instance;
	menu(){

	}
};

#endif