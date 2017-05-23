/**
 * Created by Marcin on 2015-11-28.
 */
public class Euler058 {
    boolean ifPrime(int l) {
        if (l < 2)
            return false;
        for (int a = 2; a * a <= l; a++)
            if (l % a == 0)
                return false;
        return true;
    }

    int zadanie() {
        int bok = 3;
        int licznik = 3;
        int mianownik = 5;
        int liczba = 9;
        int dodanie = 4;
        while (mianownik <= licznik * 10) {
            for (int a = 0; a < 4; a++) {
                liczba += dodanie;
                if (ifPrime(liczba))
                    licznik++;
            }
            bok += 2;
            mianownik += 4;
            dodanie += 2;
        }
        return bok;
    }

    public static void main(String[] args) {
        Euler058 ob = new Euler058();
        System.out.print(ob.zadanie());
    }
}
