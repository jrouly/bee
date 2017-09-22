#include <signal.h>
#include <stdio.h>

static volatile int keepRunning = 1;

void beeHandler(int bee) {
  printf("🐝\n");
}

int main(void) {
  signal(SIGINT, beeHandler);
  while(1) ;
}
