# CSCI3081 The Observer Pattern

CC = g++
DEBUG = -g
CFLAGS = -Wall -c -std=c++11 $(DEBUG)

LFLAGS = -Wall $(DEBUG)
OBJS = main.o subject.o weather.o viewer.o database.o

all: main.o $(OBJS)
	$(CC) $(LFLAGS) -o weatherview $(OBJS)

%.o : %.cc
	$(CC) $(CFLAGS) -o $@ $<

clean:
	\rm *.o *.*~ weatherview
