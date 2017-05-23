/**
 * Created by Marcin on 2015-11-26.
 */
public class Euler041 {
    boolean ifPrime(int l) {
        for (int a = 2; a * a <= l; a++)
            if (l % a == 0)
                return false;
        return true;
    }

    int d(int l) {
        int w = 0;
        while (l > 0) {
            w++;
            l /= 10;
        }
        return w;
    }

    boolean ifPanDigit(int l) {
        int dl = d(l);
        boolean[] tab = new boolean[dl + 1];
        for (int a = 0; a < dl + 1; a++)
            tab[a] = false;
        while (l > 0) {
            if (l % 10 == 0 || l % 10 > dl || tab[l % 10])
                return false;
            tab[l % 10] = true;
            l /= 10;
        }
        return true;
    }

    int zadanie() {
        int a;
        for (a = 987654321; a > 0; a--)
            if (ifPanDigit(a) && ifPrime(a))
                break;
        return a;
    }

    public static void main(String[] args) {
        Euler041 ob = new Euler041();
        System.out.print(ob.zadanie());
    }
}
