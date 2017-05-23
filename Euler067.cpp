#include <iostream>
#include <vector>

using namespace std;
#define ll long long

int max(int a, int b) {
    if (a > b)
        return a;
    return b;
}

int main() {
    int tab[100][100];
    for (int a = 0; a < 100; a++)
        for (int b = 0; b <= a; b++)
            cin >> tab[a][b];
    for (int a = 98; a >= 0; a--)
        for (int b = 0; b <= a; b++)
            tab[a][b] += max(tab[a + 1][b], tab[a + 1][b + 1]);
    cout << tab[0][0] << endl;

    system("PAUSE");
    return 0;
}
