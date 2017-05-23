import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Marcin on 2016-02-07.
 */
public class Euler070 {
    List<Integer> lPrim = new ArrayList<>();
    int[] PHI = new int[10000001];

    Euler070() {
        genPrim();
        PHI[1] = 1;
    }

    void genPrim() {
        boolean[] tab = new boolean[4001];
        Arrays.fill(tab, true);
        for (int a = 2; a <= 4000; a++)
            if (tab[a]) {
                lPrim.add(a);
                for (int b = a * 2; b <= 4000; b += a)
                    tab[b] = false;
            }
    }

    int rozklad(int l) {
        int w = 1;
        int licznik = 0;
        while (l != 1 && licznik < 550) {
            if (l % lPrim.get(licznik) == 0) {
                int i = 0;
                while (l % lPrim.get(licznik) == 0) {
                    l /= lPrim.get(licznik);
                    i++;
                }
                w *= Math.pow(lPrim.get(licznik), i - 1) * (lPrim.get(licznik) - 1) * PHI[l];
                l = 1;
            }
            licznik++;
        }
        if (licznik == 500)
            w = l - 1;
        return w;
    }

    boolean isPerm(int a, int b) {
        int[][] l = new int[2][10];
        Arrays.fill(l[0], 0);
        Arrays.fill(l[1], 0);
        while (a > 0) {
            l[0][a % 10]++;
            a /= 10;
        }
        while (b > 0) {
            l[1][b % 10]++;
            b /= 10;
        }

        boolean perm = true;
        for (a = 0; perm && a < 10; a++)
            if (l[0][a] != l[1][a])
                perm = false;
        return perm;
    }

    public static void main(String args[]) {
        Euler070 ob = new Euler070();
        double l = 10000000000L, p;
        int n = 1, pom;
        for (int a = 2; a <= 10000000; a++) {
            pom = ob.rozklad(a);
            ob.PHI[a] = pom;
            if (ob.isPerm(a, pom))
                if (a / (pom * 1.0) < l) {
                    l = a / (pom * 1.0);
                    n = a;
                }
        }
        System.out.print(n);
    }
}