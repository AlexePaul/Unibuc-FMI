#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

void main(int argc, const char* argv[]){
	pid_t pid = fork();
	if(pid < 0)
		return;
	if(pid == 0){
		printf("this is my pid: %d\n", getpid());
		char* argv[] = {"ls", NULL};
		execve("/bin/ls", argv, NULL);
	}
	else{
		printf("This is my father's pid: %d\n", getpid());
		wait(NULL);
	}
}