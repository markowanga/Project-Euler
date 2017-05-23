import java.math.BigInteger;

/**
 * Created by Marcin on 2015-11-29.
 */
public class Euler057 {
    BigInteger licznik;
    BigInteger mianownik;

    void plusJeden() {
        licznik = licznik.add(mianownik);
    }

    void plusDwa() {
        plusJeden();
        plusJeden();
    }

    void jedenPrzez() {
        BigInteger n = mianownik;
        mianownik = licznik;
        licznik = n;
    }

    int dl(long a) {
        int w = 1;
        while (a > 9) {
            w++;
            a /= 10;
        }
        return w;
    }

    void rozwiniecie(int n) {
        licznik = new BigInteger("1");
        mianownik = new BigInteger("2");
        for (int a = 0; a < n - 1; a++) {
            plusDwa();
            jedenPrzez();
        }
        plusJeden();
    }

    int zadanie() {
        int w = 0;
        for (int a = 1; a <= 1000; a++) {
            rozwiniecie(a);
            if (mianownik.toString().length() < licznik.toString().length())
                w++;
        }
        return w;
    }

    public static void main(String[] args) {
        Euler057 ob = new Euler057();
        System.out.print(ob.zadanie());
    }
}