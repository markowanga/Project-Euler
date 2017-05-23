import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Marcin on 2015-12-02.
 */
public class Euler064 {
    int licznik;
    int mianownik;

    boolean czyPier(int a) {
        return
                !(Math.sqrt(a) == (int) Math.sqrt(a));
    }

    int nwd(int a, int b) {
        int c;
        if (a < b) {
            c = a;
            a = b;
            b = c;
        }
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }

    int dlRozwiniecia(int l) {
        licznik = 1;
        mianownik = -(int) Math.sqrt(l);
        int mianTym;
        Set<Pair<Integer, Integer>> zb = new HashSet<>();
        while (!zb.contains(new Pair<>(licznik, mianownik))) {
            System.out.println(licznik + " " + mianownik);
            zb.add(new Pair<>(licznik, mianownik));
            mianTym = l - mianownik * mianownik;
            System.out.print("MianTym: " + mianTym + " ");
            int NWD = nwd(licznik, mianTym);
            System.out.print("NWD: " + NWD + " ");
            licznik /= NWD;
            licznik *= -mianownik;
            mianownik = mianTym / NWD;
            System.out.print("licz: " + licznik + " ");
            System.out.print("mian: " + mianownik + " ");
            licznik %= mianownik;
            if (licznik == 0)
                break;
            while (licznik > 0 || l - (licznik - mianownik) * (licznik - mianownik) > 0)
                licznik -= mianownik;
            System.out.print("licz po mod: " + licznik + " ");
            // zamiana miejscami
            int p = licznik;
            licznik = mianownik;
            mianownik = p;
            System.out.println();
        }
        return zb.size();
    }

    int zadanie() {
        int l = 0;
        for (int a = 1; a < 10000; a++)
            if (czyPier(a)) {
                licznik = 1;
                mianownik = -4;
            }
        return l;
    }

    public static void main(String[] args) {
        Euler064 ob = new Euler064();
        System.out.print(ob.dlRozwiniecia(6));
    }
}
