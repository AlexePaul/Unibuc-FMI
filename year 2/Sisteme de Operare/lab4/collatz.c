#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

void reverse(char s[])
{
 int i, j;
 char c;

 for (i = 0, j = strlen(s)-1; i<j; i++, j--) {
     c = s[i];
     s[i] = s[j];
     s[j] = c;
 }
}

void itoa(int n, char s[])
{
 int i, sign;

 if ((sign = n) < 0)  
     n = -n;          
 i = 0;
 do {       
     s[i++] = n % 10 + '0';   
 } while ((n /= 10) > 0);     
 if (sign < 0)
     s[i++] = '-';
 s[i] = '\0';
 reverse(s);
}

int main(int argc, const char* argv[]){
	int n = atoi(argv[1]);
	pid_t pid = fork();
	label:
	if(pid < 0)
		return -1;
	if(pid == 0){
		printf("%d ", n);
		if(n%2 == 0){
			n /= 2;
		}
		else{
			n = 3 * n + 1;
		}
		char param[100000];
		itoa(n, param);
		if(n != 1){
			char* argvv[] = {"collatz.c", param};
			execve("/Users/vasilepaulalexe/Documents/Projects/SO/lab4/collatz.c", argvv, NULL);
			goto label;
		}
		else{
			printf("%d",1);
		}
		return 0;
	}
	else{
		printf("\n");
		wait(NULL);
	}
}
 