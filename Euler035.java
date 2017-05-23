/**
 * Created by Marcin on 2015-11-25.
 */
public class Euler035 {
    int il(int l) {
        int w = 1;
        while (l > 9) {
            w++;
            l /= 10;
        }
        return w;
    }

    boolean ifPrime(int l) {
        for (int a = 2; a * a <= l; a++)
            if (l % a == 0)
                return false;
        return true;
    }

    boolean ifCircularPrime(int l) {
        int mnPierCyf = 1;
        while (l / mnPierCyf > 10)
            mnPierCyf *= 10;
        int dl = il(l), p;
        for (int a = 0; a < dl; a++) {
            if (!ifPrime(l))
                return false;
            if (a < dl - 1) {
                p = l / mnPierCyf;
                l = l % mnPierCyf * 10 + p;
            }
        }
        return true;
    }

    int zadanie() {
        int s = 1;
        for (int a = 3; a < 1000000; a += 2) {
            if (ifCircularPrime(a))
                s++;
        }
        return s;
    }

    public static void main(String[] args) {
        Euler035 ob = new Euler035();
        System.out.print(ob.zadanie());
    }
}
