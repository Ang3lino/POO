
#include <stdio.h>

int nextInt (void) {
    char str[10];
    fgets(str, 10, stdin);
    int n;
    sscanf(str, "%d", &n);
    return n;
}

int main (void) {
    int hr, min, seg, total;
    printf ("Horas: ");
    hr = nextInt();
    printf ("Minutos: ");
    min = nextInt();
    printf ("Segundos: ");
    seg = nextInt();
    total = hr * 3600 + min * 60 + seg;
    printf ("Segundos netos: %d \n", total);
    return 0;
}
