import java.util.*;

/**
 * Created by Marcin on 2015-12-19.
 */
public class Euler069 {
    List<Integer> lPrim = new ArrayList<>();

    Euler069() {
        genPrim();
    }

    void genPrim() {
        boolean[] tab = new boolean[1000001];
        Arrays.fill(tab, true);
        for (int a = 2; a <= 1000000; a++)
            if (tab[a]) {
                lPrim.add(a);
                for (int b = a * 2; b <= 1000000; b += a)
                    tab[b] = false;
            }
    }

    int rozklad(int l) {
        int w = 1;
        int licznik = 0;
        while (l != 1) {
            if (l % lPrim.get(licznik) == 0) {
                int i = 0;
                while (l % lPrim.get(licznik) == 0) {
                    l /= lPrim.get(licznik);
                    i++;
                }
                w *= Math.pow(lPrim.get(licznik), i - 1) * (lPrim.get(licznik) - 1);
            }
            licznik++;
        }
        return w;
    }

    public static void main(String args[]) {
        Euler069 ob = new Euler069();
        double l = 1, p;
        int n = 1;
        for (int a = 2; a < 1000000; a++) {
            p = ob.rozklad(a);
            p = a / p;
            if (p > l) {
                l = p;
                n = a;
            }
        }
        System.out.print(n);
    }
}
