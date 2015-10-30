#include <stdio.h>

int main() {
	int ch;
	while( ( ch = fgetc( stdin ) ) != EOF ) {
		if( ( (ch > 0x7E) || (ch < 0x20) )
				&& (ch != 0x0A) && (ch != 0x0D) && (ch != 0x09) )
			fprintf( stdout, "\\0x%02X", ch );
		else
			fputc( ch, stdout );
	}
	return 0;
}
