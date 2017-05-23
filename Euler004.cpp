#include <iostream>
#include <vector>

using namespace std;

bool czy_pali(int l) {
    vector<int> tab;
    while (l > 0) {
        tab.push_back(l % 10);
        l /= 10;
    }
    for (int a = 0; a < tab.size() / 2; a++)
        if (tab[a] != tab[tab.size() - a - 1])
            return false;
    return true;
}

int main() {
    int L = 0;
    for (int a = 100; a < 1000; a++)
        for (int b = 100; b < 1000; b++)
            if (czy_pali(a * b) == true)
                if (a * b > L)
                    L = a * b;
    cout << L << endl;

    system("PAUSE");
    return 0;
}