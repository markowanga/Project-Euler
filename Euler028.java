/**
 * Created by Marcin on 2015-11-24.
 */
public class Euler028 {
    int zad() {
        int bok = 1001;
        int tab[][] = new int[bok][bok];
        // 0 - prawo, 1 - dol, 2 - lewo, 3 - gora
        for (int a = 0; a < bok; a++)
            for (int b = 0; b < bok; b++)
                tab[a][b] = 0;
        int kol = bok / 2, wie = bok / 2, pop = 1, k = 3;
        tab[wie][kol] = pop++;
        while (wie != 0 || kol != bok - 1) {
            if (k == 0) // kierunek w prawo ale trzeba sprawdzi� czy mo�na skr�ci�
            {
                if (tab[wie + 1][kol] == 0) {
                    k = 1;
                    wie++;
                } else kol++;
            } else if (k == 1) {
                if (tab[wie][kol - 1] == 0) {
                    k = 2;
                    kol--;
                } else wie++;
            } else if (k == 2) {
                if (tab[wie - 1][kol] == 0) {
                    k = 3;
                    wie--;
                } else kol--;
            } else if (k == 3) {
                if (tab[wie][kol + 1] == 0) {
                    k = 0;
                    kol++;
                } else wie--;
            }
            tab[wie][kol] = pop++;
        }
        // suma przek
        int s = -1;
        for (int a = 0; a < bok; a++)
            s += tab[a][a] + tab[a][bok - a - 1];
        return s;
    }

    public static void main(String[] args) {
        Euler028 ob = new Euler028();
        System.out.print(ob.zad());
    }
}
