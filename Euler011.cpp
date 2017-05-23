#include <iostream>
#include <vector>

using namespace std;

int main() {
    int tab[20][20];
    for (int a = 0; a < 20; a++)
        for (int b = 0; b < 20; b++)
            cin >> tab[a][b];
    long long max = 0, pom;
    // pionowo
    for (int a = 0; a < 20; a++)
        for (int b = 0; b < 17; b++) {
            pom = tab[a][b] * tab[a][b + 1] * tab[a][b + 2] * tab[a][b + 3];
            if (pom > max)
                max = pom;
        }
    // poziomo
    for (int a = 0; a < 20; a++)
        for (int b = 0; b < 17; b++) {
            pom = tab[b][a] * tab[b + 1][a] * tab[b + 2][a] * tab[b + 3][a];
            if (pom > max)
                max = pom;
        }
    // sko�nie -> jedziemy wiersze od 0 do <17
    for (int a = 0; a < 17; a++)
        for (int b = 0; b < 20; b++) {
            if (b > 2) {
                pom = tab[a][b] * tab[a + 1][b - 1] * tab[a + 2][b - 2] * tab[a + 3][b - 3];
                if (pom > max)
                    max = pom;
            }
            if (b < 17) {
                pom = tab[a][b] * tab[a + 1][b + 1] * tab[a + 2][b + 2] * tab[a + 3][b + 3];
                if (pom > max)
                    max = pom;
            }
        }
    cout << max;

    system("PAUSE");
    return 0;
}