#include <iostream>
#include <vector>

using namespace std;
#define ll long long

int rozklad(ll l) {
    int licznik = 0;
    while (l != 1) {
        licznik++;
        if (l % 2 == 0)
            l /= 2;
        else l = l * 3 + 1;
    }
    return licznik;
}

int main() {

    ll licznik, il_max = 0, w_max;
    for (ll a = 1; a < 1000000; a++) {
        licznik = rozklad(a);
        if (licznik > il_max) {
            il_max = licznik;
            w_max = a;
        }
    }
    cout << w_max << endl;

    system("PAUSE");
    return 0;
}
