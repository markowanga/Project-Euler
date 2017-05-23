#include <iostream>
#include <vector>

using namespace std;
#define ll long long

ll ile_dzielnikow(ll l) {
    ll w = 0;
    ll a;
    for (a = 1; a * a < l; a++)
        if (l % a == 0)
            w += 2;
    if (a * a == l)
        w++;
    return w;
}

int main() {
    ll liczba = 1;
    ll p, max = 0;
    for (ll a = 1; true; a++, liczba += a) {
        p = ile_dzielnikow(liczba);
        if (p >= 500)
            break;
        if (max < p) {
            max = p;
            cout << liczba << ": " << max << endl;
        }
    }
    cout << liczba << endl;

    system("PAUSE");
    return 0;
}
