FLAGS=-ansi -pedantic -Wall
CFLAGS=-g $(FLAGS)
SRC=crash.c

all: $(SRC) pchar.c
	cc $(CFLAGS) -c $(SRC)
	cc $(FLAGS) -S $(SRC)
	cc $(CFLAGS) -o crash $(SRC)
	cc $(CFLAGS) -c pchar.c
	cc $(FLAGS) -S pchar.c
	grep -E '^	+[^.]' crash.s > crash.asm
	as -a crash.asm -o crash.as.o > crash.list
	grep -E '^	+[^.]' pchar.s > pchar.asm
	as -a pchar.asm -o pchar.as.o > pchar.list
	cc $(CFLAGS) -o pchar pchar.c

clean:
	rm -rf *.o *.s *.asm crash pchar *.list core
