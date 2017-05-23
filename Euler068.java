import java.util.Arrays;

/**
 * Created by Marcin on 2015-12-04.
 */
public class Euler068 {
    long wynikOstateczny; // wynik koncowy
    int suma; // suma jednej prostej
    int[] tab = new int[10];
    boolean[] wolne = new boolean[10];

    int dl(long l) {
        int w = 1;
        while (l > 9) {
            w++;
            l /= 10;
        }
        return w;
    }

    long polocz(long first, long second) {
        return
                first * (long) Math.pow(10, dl(second)) + second;
    }

    long poloczenieJednejTrojki(int pocz) {
        if (pocz < 4)
            return polocz(tab[pocz], polocz(tab[pocz + 5], tab[pocz + 6]));
        return polocz(tab[4], polocz(tab[9], tab[5]));
    }

    int poczatekWyniku() {
        int w = 0;
        for (int a = 1; a < 5; a++)
            if (tab[w] > tab[a])
                w = a;
        return w;
    }

    long tworzLiczbeZWynikiem() {
        int pocz = poczatekWyniku();
        long p = poloczenieJednejTrojki(pocz);
        for (int a = 1; a < 5; a++)
            p = polocz(p, poloczenieJednejTrojki((pocz + a) % 5));
        return p;
    }

    void uzupelnij(int nr) {
        if (nr < 7) {
            for (int a = 1; a < 10; a++)
                if (wolne[a]) {
                    wolne[a] = false;
                    tab[nr] = a;
                    uzupelnij(nr + 1);
                    wolne[a] = true;
                }
        } else if (nr < 10) {
            if (nr == 7)
                suma = tab[0] + tab[5] + tab[6];
            int szukana = suma - tab[nr - 6] - tab[nr - 1];
            if (szukana > 0 && szukana < 10 && wolne[szukana]) {
                wolne[szukana] = false;
                tab[nr] = szukana;
                uzupelnij(nr + 1);
                wolne[szukana] = true;
            }
        } else if (suma == tab[4] + tab[9] + tab[5]) {
            // dobre wszystko
            long tym = tworzLiczbeZWynikiem();
            if (tym > wynikOstateczny)
                wynikOstateczny = tym;
        }
    }

    long zadanie() {
        wynikOstateczny = 0;
        tab[0] = 10;
        Arrays.fill(wolne, true);
        uzupelnij(1);
        return wynikOstateczny;
    }

    public static void main(String[] args) {
        Euler068 ob = new Euler068();
        System.out.print(ob.zadanie());
    }
}
