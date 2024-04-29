#include <stdio.h>
#include <unistd.h>

int main(){
	const char msg[] = "Hello World!";
	write(1, msg, sizeof(msg)-1);
	return 0;
}