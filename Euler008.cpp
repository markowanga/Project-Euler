#include <iostream>
#include <vector>

using namespace std;

int main() {
    int tab[1000];
    char pom;
    for (int a = 0; a < 1000; a++) {
        cin >> pom;
        tab[a] = (int) pom - 48;
    }
    long long max = 0, pp;
    for (int a = 0; a < 1000 - 13; a++) {
        pp = 1;
        for (int b = 0; b < 13; b++)
            pp *= tab[a + b];
        if (pp > max)
            max = pp;
    }
    cout << max << endl;

    system("PAUSE");
    return 0;
}