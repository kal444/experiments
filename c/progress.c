#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

extern void usleep();

/* outputs a frame of a twirling baton for every successive call to it.
 * non-zero direction means the twirling is clockwise
 * zero direction means the twirling is counter-clockwise
*/
void twirl_baton(int direction) {
	static char cur_char='-';
	static int first_run=1;

	switch(cur_char) {
	case '-':
		if(direction) cur_char='\\';
		else cur_char='/';
		break;
	case '\\':
		if(direction) cur_char='|';
		else cur_char='-';
		break;
	case '|':
		if(direction) cur_char='/';
		else cur_char='\\';
		break;
	case '/':
		if(direction) cur_char='-';
		else cur_char='|';
	}

	if(first_run) first_run=0;
	else fputc('\b', stdout);

	fputc(cur_char, stdout);
	fflush(stdout);
}

int main () {
	while(1) {
		/* printf("Calling twirl_baton()\n"); */
		twirl_baton(1);
		usleep(250000);
	}
	return 0;
}
