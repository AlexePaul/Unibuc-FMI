#include "../include/menu.h"
#include "doubleLL.cpp"
#include "../include/repoList.h"
#include "repoList.cpp"
#include "../include/nod.h"

template<typename type>
menu<type>* menu<type>::instance = nullptr;

template<typename type>
void menu<type>::clear(){ // preluata de la oameni cu mai mult de 2 neuroni (care in cazul meu sunt in vacanta in grecia) (Stack Overflow)
#if defined _WIN32
    system("cls");
#elif defined (__LINUX__) || defined(__gnu_linux__) || defined(__linux__)
    system("clear");
#elif defined (__APPLE__)
    system("clear");
#endif
}

template<typename type>
menu<type>* menu<type>::getInstance(){
		if(instance == nullptr)
			instance = new menu<type>();
		return instance;
}

template<typename type>
void menu<type>::runMenu(){
	int x,nr,nr1;
	type n;
	repoList<type> rL;
	doubleLL<type> t;
	clear();
	while(true){
		cout << "1. Adauga un element la sfarsitul listei\n";
		cout << "2. Scoate Un element de la sfarsitul listei\n";
		cout << "3. Afiseaza lista\n";
		cout << "4. Afiseaza elementul de pe pozitia data\n";
		cout << "5. Citeste o lista\n";
		cout << "6. Goleste Consola\n";
		cout << "7. Alege Numarul de liste\n";
		cout << "8. Opreste Programul\n";
		cin >> x;
		switch (x){
			case 1:
				cout << "Numarul care sa fie adaugat este: ";
				cin >> n;
				cout << "Lista in care sa fie adaugat numarul este: ";
				cin >> nr;
				try{
					rL[nr].push_back(n);
				}
				catch(const char* s){
					cout << s << '\n';
				}
				cout << '\n';
				break;
			case 2:
				cout << "Lista din care sa fie scos numarul este: ";
				cin >> nr;
				try{
					rL[nr].pop_back();
				}
				catch(const char* s){
					cout << s << '\n';
				}
				cout << '\n';
				break;		
			case 3:
				cout << "Lista care sa fie afisata este: ";
				cin >> nr;
				try{
					cout << rL[nr] << '\n';
				}
				catch(const char* s){
					cout << s << '\n';
				}
				break;
			case 4:
				cout << "Pozitia elementului pe care il doresti afisat: ";
				cin >> nr1;
				cout << "Lista din care doriti numarul afisat este: ";
				cin >> nr;
				try{
					cout << '\n' << rL[nr][nr1] << '\n';
				}
				catch(const char* s){
					cout << s << '\n';
				}
				break;
			case 5:
				cin >> t;
				rL.push_back(t);
				break;
			case 6:
				clear();
				break;
			case 7:
				cout << "dimensiunea va fi: \n";
				cin >> nr; 
				rL.resize(nr);
				break;
			case 8:
				return;
				break;
			default:
				break;
		}
	}
}