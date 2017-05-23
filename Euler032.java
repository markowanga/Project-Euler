import java.util.HashSet;
import java.util.Set;

/**
 * Created by Marcin on 2015-11-25.
 */
public class Euler032 {
    int il(long l) {
        int w = 1;
        while (l > 9) {
            w++;
            l /= 10;
        }
        return w;
    }

    boolean czyOk(long l1, long l2, long l3) {
        boolean[] tab = new boolean[10];
        for (int a = 0; a < 10; a++)
            tab[a] = false;
        int l = 0;
        while (l1 > 0) {
            if (tab[(int) (l1 % 10)] || l1 % 10 == 0)
                return false;
            tab[(int) (l1 % 10)] = true;
            l++;
            l1 /= 10;
        }
        while (l2 > 0) {
            if (tab[(int) (l2 % 10)] || l2 % 10 == 0)
                return false;
            tab[(int) (l2 % 10)] = true;
            l++;
            l2 /= 10;
        }
        while (l3 > 0) {
            if (tab[(int) (l3 % 10)] || l3 % 10 == 0)
                return false;
            tab[(int) (l3 % 10)] = true;
            l++;
            l3 /= 10;
        }
        return l == 9;
    }

    long zadanie() {
        Set<Long> Zb = new HashSet<>();
        long suma = 0;
        for (long a = 1; a < 10000; a++)
            for (long b = 1; il(a) + il(b) + il(a * b) <= 9; b++)
                if (czyOk(a, b, a * b) && Zb.add(a * b))
                    suma += a * b;
        return suma;

    }

    public static void main(String[] args) {
        Euler032 ob = new Euler032();
        System.out.print(ob.zadanie());
    }
}
