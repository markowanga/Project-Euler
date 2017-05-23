import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-11-27.
 */
public class Euler046 {
    List<Long> nPrime = new ArrayList<>();

    boolean ifPrime(Long l) {
        for (int a = 2; a * a <= l; a++)
            if (l % a == 0)
                return false;
        return true;
    }

    boolean ifNSquare(long l) {
        double s = Math.sqrt(l);
        return s == (long) s;
    }

    boolean czyRozkladalne(long l) {
        long p;
        for (int a = 0; a < nPrime.size(); a++) {
            p = l - nPrime.get(a);
            if (p % 2 == 0) {
                p /= 2;
                if (ifNSquare(p)) {
                    //System.out.println(l + " = " + nPrime.get(a) + " + 2*" + (int)Math.sqrt(p) + "^2");
                    return true;
                }
            }
        }
        return false;
    }

    long zadanie() {
        boolean znalazlem = false;
        long w = 1;
        while (!znalazlem) {
            w++;
            if (ifPrime(w))
                nPrime.add(w);
            else if (w % 2 == 1 && !czyRozkladalne(w))
                znalazlem = true;
            if (w == 6000)
                break;
        }
        return w;
    }

    public static void main(String[] args) {
        Euler046 ob = new Euler046();
        System.out.print(ob.zadanie());
    }
}
