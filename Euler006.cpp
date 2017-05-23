#include <iostream>
#include <vector>

using namespace std;

int main() {
    int S1 = 0, S2 = 0;
    for (int a = 1; a <= 100; a++)
        S1 += a * a;
    for (int a = 1; a <= 100; a++)
        S2 += a;
    S2 *= S2;
    cout << S2 - S1 << endl;

    system("PAUSE");
    return 0;
}