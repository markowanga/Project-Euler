#include <iostream>
#include <string>
#include <vector>
#include <utility>

using namespace std;
#define sh short int

sh S[9][9];
bool czy_zajete[9][9];
vector<pair<sh, sh> > puste;
bool wie[9][10], kol[9][10], kw[9][10];
bool czy_koniec = false;

sh jaki_kw(sh a, sh b) {
    return (a / 3) * 3 + b / 3;
}

void odczyt() {
    for (sh a = 0; a < 9; a++)
        for (sh b = 1; b <= 9; b++) {
            wie[a][b] = false;
            kol[a][b] = false;
            kw[a][b] = false;
        }
    char p;
    for (sh a = 0; a < 9; a++)
        for (sh b = 0; b < 9; b++) {
            cin >> p;
            S[a][b] = (int) p - 48;
            if (S[a][b] == 0)
                czy_zajete[a][b] = false;
            else {
                czy_zajete[a][b] = true;
                wie[a][S[a][b]] = true;
                kol[b][S[a][b]] = true;
                kw[jaki_kw(a, b)][S[a][b]] = true;
            }
        }
}

void wyswietl() {
    for (sh a = 0; a < 9; a++) {
        for (sh b = 0; b < 9; b++)
            cout << S[a][b];
        cout << endl;
    }
}

void wyszukaj_puste_pola() {
    for (int a = 0; a < 9; a++)
        for (int b = 0; b < 9; b++)
            if (S[a][b] == 0)
                puste.push_back(make_pair(a, b));
}

void szukaj(int n) {
    sh kwadrat = jaki_kw(puste[n].first, puste[n].second);
    for (sh a = 1; a <= 9; a++)
        if (kw[kwadrat][a] == false
            && wie[puste[n].first][a] == false
            && kol[puste[n].second][a] == false) {
            kw[kwadrat][a] = true;
            wie[puste[n].first][a] = true;
            kol[puste[n].second][a] = true;
            if (n != puste.size() - 1) {
                szukaj(n + 1);
                kw[kwadrat][a] = false;
                wie[puste[n].first][a] = false;
                kol[puste[n].second][a] = false;
                if (czy_koniec == true) {
                    S[puste[n].first][puste[n].second] = a;
                    return;
                }
            } else {
                czy_koniec = true;
                S[puste[n].first][puste[n].second] = a;
                return;
            }
        }
}

bool szukaj_pewniakow() {
    bool czy_nowe = false, czy_ostatnio_pewniak = true;
    bool pom[9][9];
    while (czy_ostatnio_pewniak == true) {
        czy_ostatnio_pewniak = false;
        // pewniaki przez wiersze i kolumny w kwadracie
        for (int l = 1; l <= 9; l++) {
            // kopiowanie do pom
            for (int a = 0; a < 9; a++)
                for (int b = 0; b < 9; b++)
                    pom[a][b] = czy_zajete[a][b];
            // zape�nienie wierszy
            for (int a = 0; a < 9; a++)
                if (wie[a][l] == true) {
                    for (int b = 0; b < 9; b++)
                        pom[a][b] = true;
                }
            // zape�nianie kolumn
            for (int b = 0; b < 9; b++)
                if (kol[b][l] == true) {
                    for (int a = 0; a < 9; a++)
                        pom[a][b] = true;
                }

            // sprawdzanie poszczeg�lnych kwadrat�w
            // czy nie jest wolne jedno miejsce
            for (int i = 0; i < 9; i++)
                if (kw[i][l] == false) {
                    sh K = i % 3 * 3, W = i / 3 * 3; // kolumna wiersz
                    pair<sh, sh> wsp;
                    sh licznik = 0;
                    for (sh l1 = 0; l1 < 3; l1++)
                        for (sh l2 = 0; l2 < 3; l2++)
                            if (pom[l1 + W][l2 + K] == false) {
                                licznik++;
                                wsp = make_pair(l1 + W, l2 + K);
                            }
                    if (licznik == 1) {
                        //cout << "pewniak" << endl;
                        S[wsp.first][wsp.second] = l;
                        czy_zajete[wsp.first][wsp.second] = true;
                        wie[wsp.first][l] = true;
                        kol[wsp.second][l] = true;
                        kw[i][l] = true;
                        czy_nowe = true;
                        czy_ostatnio_pewniak = true;
                    }
                }
        }

    }
    return czy_nowe;
}

void rozwiaz_sudoku() {
    czy_koniec = false;
    vector<pair<sh, sh> > pp;
    puste = pp;
    szukaj_pewniakow();
    wyszukaj_puste_pola();
    if (puste.size() != 0)
        szukaj(0);
}

int main() {
    int W = 0;
    string pom;
    for (int a = 0; a < 50; a++) {
        cin >> pom;
        cin >> pom;
        odczyt();
        rozwiaz_sudoku();
        wyswietl();
        cout << S[0][0] * 100 + S[0][1] * 10 + S[0][2] << endl;
        W += S[0][0] * 100 + S[0][1] * 10 + S[0][2];
    }
    cout << W << endl;

    system("PAUSE");
    return 0;
}