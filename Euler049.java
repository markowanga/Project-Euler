import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Marcin on 2015-11-27.
 */
public class Euler049 {
    List<Integer> nPrime = new ArrayList<>();
    Set<Integer> zb = new HashSet<>();

    boolean ifPrimeI(int l) {
        for (int a = 2; a * a <= l; a++)
            if (l % a == 0)
                return false;
        return true;
    }

    void uzuNPrime() {
        for (int a = 1000; a < 10000; a++)
            if (ifPrimeI(a)) {
                nPrime.add(a);
                zb.add(a);
            }
    }

    boolean ifPer(int a, int b) {
        int[] A = new int[10];
        int[] B = new int[10];
        for (int i = 0; i < 10; i++) {
            A[i] = 0;
            B[i] = 0;
        }
        while (a > 0) {
            A[a % 10]++;
            a /= 10;
            B[b % 10]++;
            b /= 10;
        }
        for (int i = 0; i < 10; i++)
            if (A[i] != B[i])
                return false;
        return true;
    }

    long zadanie() {
        uzuNPrime();
        zb.remove(1487);
        zb.remove(4817);
        zb.remove(8147);
        int l;
        for (l = 0; l < nPrime.size(); l++)
            if (zb.contains((nPrime.get(l) + 3330) % 10000)
                    && zb.contains((nPrime.get(l) + 6660) % 10000)
                    && ifPer(nPrime.get(l), nPrime.get(l) + 3330)
                    && ifPer(nPrime.get(l), nPrime.get(l) + 6660))
                return nPrime.get(l) * 100000000L + (nPrime.get(l) + 3330) * 10000 + nPrime.get(l) + 6660;
        return -1;
    }

    public static void main(String[] args) {
        Euler049 ob = new Euler049();
        System.out.print(ob.zadanie());
    }
}
