#include <stdio.h>

int main () {
	char buf[11];

	printf("Inputting...\n");
	gets(buf);
	printf("Got this: <%s>\n", buf);
	printf("DONE\n");

	return 0;
}
