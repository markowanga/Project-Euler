#include <iostream>
#include <vector>

using namespace std;

bool czy_pier(int l) {
    for (int a = 2; a * a <= l; a++)
        if (l % a == 0)
            return false;
    return true;
}

int main() {
    long long s = 0;
    for (int a = 2; a < 2000000; a++)
        if (czy_pier(a) == true)
            s += a;
    cout << s << endl;

    system("PAUSE");
    return 0;
}