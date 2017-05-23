#include <iostream>
#include <vector>

using namespace std;

int main() {
    long long l = 600851475143;
    for (int a = 2; a < l; a++)
        while (l > a) {
            if (l % a == 0)
                l /= a;
            else break;
        }
    cout << l << endl;

    system("PAUSE");
    return 0;
}