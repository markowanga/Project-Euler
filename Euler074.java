import java.util.HashSet;
import java.util.Set;

/**
 * Created by Marcin on 2016-02-07.
 */
public class Euler074 {
    int[] S = new int[10];

    Euler074() {
        S[0] = 1;
        for (int a = 1; a < 10; a++)
            S[a] = S[a - 1] * a;
    }

    int SS(int l) {
        int s = 0;
        while (l > 0) {
            s += S[l % 10];
            l /= 10;
        }
        return s;
    }

    int sprawdzIle(int l) {
        Set<Integer> zb = new HashSet<>();
        while (zb.add(l))
            l = SS(l);
        return zb.size();
    }

    public static void main(String[] args) {
        Euler074 ob = new Euler074();
        int licznik = 0;
        for (int a = 2; a <= 1000000; a++)
            if (ob.sprawdzIle(a) == 60)
                licznik++;
        System.out.print(licznik);
    }
}
