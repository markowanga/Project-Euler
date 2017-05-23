import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-11-28.
 */
public class Euler060 {
    List<Integer> nPrimes = new ArrayList<>();
    List<Integer> tymCzas = new ArrayList<>();
    int[] tab = new int[8];

    boolean ifPrime(long l) {
        if (l % 2 == 0 || l % 3 == 0)
            return false;
        long a;
        for (a = 6; a * a <= l; a += 6) {
            if (l % (a - 1) == 0)
                return false;
            if (l % (a + 1) == 0)
                return false;
        }
        return l % (a - 1) != 0;
    }

    int dl(int a) {
        int w = 1;
        while (a > 9) {
            w++;
            a /= 10;
        }
        return w;
    }

    long sklej(int m, int n) {
        return
                m * (long) Math.pow(10, dl(n)) + n;
    }

    boolean check(int a, int b) {
        return ifPrime(sklej(a, b))
                && ifPrime(sklej(b, a));
    }

    void nextPrime() {
        int l = nPrimes.get(nPrimes.size() - 1) + 1;
        while (!ifPrime(l))
            l++;
        nPrimes.add(l);
    }

    boolean spr(int il) {
        for (int a = 0; a < il; a++)
            if (!check(tab[a], tab[il]))
                return false;
        return true;
    }

    int dodajDoTablicy(int pocz, int nr) {
        if (pocz == tymCzas.size())
            return -1;
        tab[nr] = tymCzas.get(pocz);
        if (spr(nr)) {
            //System.out.print("ok");
            if (nr == 3)
                return tab[0] + tab[1] + tab[2] + tab[3];
            int p = dodajDoTablicy(pocz + 1, nr + 1);
            if (p != -1)
                return p;
        }
        return dodajDoTablicy(pocz + 1, nr);
    }

    int zadanie() {
        nPrimes.add(2);
        nPrimes.add(3);
        nPrimes.add(5);
        nPrimes.add(7);
        nPrimes.add(11);
        int suma = -1;
        int l;
        while (suma == -1 || nPrimes.get(nPrimes.size() - 1) < suma) {
            nextPrime();
            l = nPrimes.get(nPrimes.size() - 1);
            tymCzas.clear();
            // dodanie wszystkich kandydat�w dla liczby ostatniej na li�cie
            for (int a = 0; a < nPrimes.size() - 1; a++)
                if (check(nPrimes.get(a), l))
                    tymCzas.add(nPrimes.get(a));
            // sprawdzenie czy istnieje grupa 4 kandydat�w mo�liwych
            int p = dodajDoTablicy(0, 0);
            if (p != -1) {
                if (suma == -1 || suma > p + l)
                    suma = p + l;
            }
        }
        return suma;
    }

    public static void main(String[] args) {
        Euler060 ob = new Euler060();
        System.out.print(ob.zadanie());
    }
}
