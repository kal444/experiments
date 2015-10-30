#include <stdio.h>
#include <unistd.h>

int main(){
	/* printf("execve addr: %p\n", (void *)execve); */
	char * const args[]={ "/bin/ls", NULL };
	execve(args[0], args, NULL);
	return 0;
}
