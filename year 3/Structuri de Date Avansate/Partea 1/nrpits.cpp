#include <fstream>
#include <stack>

using namespace std;

ifstream fin("nrpits.in");
ofstream fout("nrpits.out");

stack<int>s;
int v[1000005];

/*
    Am decis sa utilizez o stiva deoarece in felul asta pot parcurge numerele din vector si sa tin cont de cate gropi o sa "inchid" cu fiecare numar nou.
    Am scos toate numerele din stiva care erau mai mici decat pozitia pe care ma aflu  
        -> Daca aveam in stiva mai mult de un element insemna ca se inchide o groapa. Ex: daca in stiva am 12 1 si ma aflu pe v[i] = 10, se gaseste o groapa.
            --> In schimb daca aveam v[i] = 13 as fi scos si 1 si 12, dar as fi contorizat o singura groapa (scot si 12 ptc avand 13, nu as mai putea inchide gropi vreodata)
    Complexitate: O(n)

*/
int main(){
    int n;

    fin >> n;
    for(int i = 0; i < n; ++i){
        fin >> v[i];
    }

    int count = 0;
    for(int i = 0; i < n; ++i){
        while(s.size() && s.top() < v[i]){
            if(s.size() > 1)
                count++;
            s.pop();
        }
        s.push(v[i]);
    }
    fout << count;
}