#include <stdio.h>
#include <stdlib.h>

int main(){
	int n;
	scanf("%d", &n);
	int ** mat = (int **) malloc(n * sizeof(int*));
	for(int i = 0; i < n; ++i){
		mat[i] = (int*) malloc(n * sizeof(int));		
	}

	for(int i = 0; i < n; ++i){
		for(int j = 0; j < n; ++j){
			scanf("%d", &mat[i][j]);
		}
	}	

	printf("%d",mat[n/2][n/2]);
	printf("%c", '\n');

	for(int i = 0 ; i < n; ++i){
		printf("%d", mat[i][i]);
		printf("%s", " ");
	}
	printf("%c", '\n');

	for(int i = 0; i < n; ++i){
		printf("%d", mat[i][n-i-1]);
		printf("%s", " ");
	}
}
