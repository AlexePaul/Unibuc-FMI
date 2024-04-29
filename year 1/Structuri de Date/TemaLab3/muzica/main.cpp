#include <bits/stdc++.h>

#pragma GCC optimize("O3")
#define FILE "muzica"

using namespace std;

int main(){
	ifstream fin(FILE".in");
	ofstream fout(FILE".out");

	int n,m,nr,x;
	long long A,B,C,D,E,aux;
	unordered_set<int> uset(100012);
	
	ios::sync_with_stdio(false);
	
	fin >> n >> m;
	fin >> A >> B >> C >> D >> E;
	for(int i = 0; i < n; ++i){
		fin >> x;
		uset.insert(x);
	}

	if(uset.find(A) != uset.end()){
		nr++;
		uset.erase(A);
	}
	if(uset.find(B) != uset.end()){
		nr++;
		uset.erase(B);
	}

	for(int i = 2; i < m; ++i){
		aux = (C*B + D*A) % E;
		if(uset.find(aux) != uset.end()){
			nr++;
			uset.erase(aux);
		}
		A = B;
		B = aux;
	}
	fout << nr;
	return 0;
}