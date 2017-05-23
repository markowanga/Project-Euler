#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> V;
    V.push_back(1);
    V.push_back(2);
    while (V[V.size() - 1] + V[V.size() - 2] < 4000000)
        V.push_back(V[V.size() - 1] + V[V.size() - 2]);
    int S = 0;
    for (int a = 0; a < V.size(); a++)
        if (V[a] % 2 == 0)
            S += V[a];
    cout << S << endl;

    system("PAUSE");
    return 0;
}