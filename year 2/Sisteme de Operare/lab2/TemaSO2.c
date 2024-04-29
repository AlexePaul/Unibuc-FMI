#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <errno.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{

	if(argc != 2)
		return -1;

    char *buffer = (char *)calloc(4096, sizeof(char));
    int fdA, fdB, temp;

    fdA = open(argv[1], O_RDONLY);
    fdB = open(argv[2], O_WRONLY);
    do
    {
        temp = read(fdA, buffer, 4096);
        printf("%s ", buffer);
        write(fdB, buffer, temp);
    } while (temp != 0);
    close(fdA);
    close(fdB);
    return 0;
}