#include <iostream>
#include <vector>

using namespace std;

int main() {
    int a;
    for (int c = 1000; c > 0; c--)
        for (int b = 1000 - c; b > 0; b--) {
            a = 1000 - c - b;
            if (a * a + b * b == c * c) {
                cout << a * b * c << endl;
                cout << a << " " << b << " " << c << endl;
                break;
            }
        }

    system("PAUSE");
    return 0;
}