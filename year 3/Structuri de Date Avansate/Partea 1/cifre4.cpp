#include <fstream>
#include <queue>
#include <iostream>

using namespace std;

ifstream fin("cifre4.in");
ofstream fout("cifre4.out");

/*
    Am folosit un queue pentru a "parcurge" numerele formate din 2,3,5,7.
        -> Am decis sa aleg un queue, deoarece asa am putut sa ma asigur ca se vor genera in ordinea buna, de la mic la mare.
    Am inceput prin a introduce in queue in ordine crescatoare cifrele de start, apoi de fiecare data cand treceam la un numar nou care avea un rest de care nu am mai dat pana acum:
        -> Ii adaugam la urma un 2,3,5 si 7, si le introduceam in queue (evident in cazul in care acel rest nu era fix n)
    Complexitate: O(p), deoarece am maxim p resturi posibile.

*/

long long calculeaza(int n, int p){
    queue<long long> q;
    vector<bool> frecv(p, false);

    q.push(2);
    q.push(3);
    q.push(5);
    q.push(7);

    while(!q.empty()){
        long long fr = q.front();
        q.pop();

        if(frecv[fr%p] == false){
            frecv[fr%p] = true;

            if(fr % p == n)
                return fr;
            
            q.push(fr*10 + 2);
            q.push(fr*10 + 3);
            q.push(fr*10 + 5);
            q.push(fr*10 + 7);
        }
    }
    return -1;
}

int main(){
    int n, p, k;
    fin >> k;
    for(int i = 0; i < k; ++i){
        fin >> n >> p;
        fout << calculeaza(n,p) << '\n';
    }
}