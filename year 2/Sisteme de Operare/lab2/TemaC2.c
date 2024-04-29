#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int  count_occurrences(const char* text, const char *word){
	char* pch = strstr(text, word);
	int count = 0;
	while(pch != NULL){
		count++;
		pch = strstr(pch+1, word);
	}
	return count;
}

int main(){
	char* text = (char *) malloc(50 * sizeof(char));
	char* word = (char *) malloc(10 * sizeof(char));

	gets(text);
	gets(word);
	printf("%d",count_occurrences(text, word));
}