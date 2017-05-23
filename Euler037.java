/**
 * Created by Marcin on 2015-11-25.
 */
public class Euler037 {
    boolean ifPrime(int l) {
        if (l < 2)
            return false;
        for (int a = 2; a * a <= l; a++)
            if (l % a == 0)
                return false;
        return true;
    }

    boolean fromLeft(int l) {
        int d = 1;
        while (l / d > 10)
            d *= 10;
        while (l > 0) {
            if (!ifPrime(l))
                return false;
            l %= d;
            d /= 10;
        }
        return true;
    }

    boolean formRight(int l) {
        while (l > 0) {
            if (!ifPrime(l))
                return false;
            l /= 10;
        }
        return true;
    }

    int zadanie() {
        int l = 0;
        int s = 0;
        for (int a = 10; l < 11; a++)
            if (formRight(a) && fromLeft(a)) {
                s += a;
                l++;
            }
        return s;
    }

    public static void main(String[] args) {
        Euler037 ob = new Euler037();
        System.out.print(ob.zadanie());
    }
}
