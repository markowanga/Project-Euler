import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-11-27.
 */
public class Euler050 {
    List<Long> nPrime = new ArrayList<>();
    List<Long> P = new ArrayList<>();

    boolean ifPrime(long l) {
        for (long a = 2; a * a <= l; a++)
            if (l % a == 0)
                return false;
        return true;
    }

    void genPrimes() {
        nPrime.add(0L);
        for (long a = 2; a < 1000000; a++)
            if (ifPrime(a))
                nPrime.add(a);
    }

    void makeNPrimesSum() {
        P.add(0L);
        for (int a = 1; a < nPrime.size(); a++)
            P.add(nPrime.get(a) + P.get(a - 1));
    }

    long zadanie() {
        genPrimes();
        makeNPrimesSum();
        int r = 0;
        long l = 0;
        for (int a = 1; a < P.size(); a++)
            for (int b = a - (r + 1); b >= 0 && P.get(a) - P.get(b) < 1000000; b--)
                if (ifPrime(P.get(a) - P.get(b))) {
                    r = a - b;
                    l = P.get(a) - P.get(b);
                }
        return l;
    }

    public static void main(String[] args) {
        Euler050 ob = new Euler050();
        System.out.print(ob.zadanie());
    }
}
