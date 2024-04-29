#include <iostream>
#include "./src/doubleLL.cpp"
#include "./include/nod.h"

using namespace std;

void clear(){ // preluata de la oameni cu mai mult de 2 neuroni (care in cazul meu sunt in vacanta in grecia) (Stack Overflow)
#if defined _WIN32
    system("cls");
#elif defined (__LINUX__) || defined(__gnu_linux__) || defined(__linux__)
    system("clear");
#elif defined (__APPLE__)
    system("clear");
#endif
}

int main(){
doubleLL<int>::setX(5);
doubleLL<int>t;
doubleLL<int>p;
long long n,x;

cin >> t;
p = t;
cout << p;
cin >> x; //asta este aici ca sa nu treaca direct la meniu
// am vrut sa arat ca merge insa nu stiu unde/ cu ce scop sa il introduc in meniu

clear();
	while(true){
		cout << "1. Adauga un element la sfarsitul listei\n";
		cout << "2. Scoate Un element de la sfarsitul listei\n";
		cout << "3. Afiseaza lista\n";
		cout << "4. Afiseaza elementul de pe pozitia data\n";
		cout << "5. Citeste o lista\n";
		cout << "6. Goleste Consola\n";
		cout << "7. Opreste Programul\n";
		cin >> x;
		switch (x){
			case 1:
				cout << "Numarul care sa fie adaugat este: ";
				cin >> n;
				t.push_back(n);
				cout << '\n';
				break;
			case 2:
				t.pop_back();
				cout << '\n';
				break;		
			case 3:
				cout << t << '\n';
				break;
			case 4:
				cout << "Pozitia elementului pe care il doresti afisat: ";
				cin >> n;
				try{
					cout << '\n' << t[n] << '\n';
				}
				catch(const char* s){
					cout << s << '\n';
				}
				break;
			case 5:
				cin >> t;
				break;
			case 6:
				clear();
				break;
			case 7:
				return 0;
				break;
			default:
				break;
		}
	}
}