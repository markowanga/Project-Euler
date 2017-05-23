#include <iostream>

using namespace std;

int main() {
    int S = 0;
    for (int a = 1; a < 1000; a++)
        if (a % 3 == 0 || a % 5 == 0)
            S += a;
    cout << S << endl;

    system("PAUSE");
    return 0;
}