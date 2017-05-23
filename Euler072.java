import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Marcin on 2016-02-07.
 */
public class Euler072 {
    List<Integer> lPrim = new ArrayList<>();

    Euler072() {
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


    public static void main(String[] args) {
        Euler072 ob = new Euler072();
        long licznik = 0;
        for (int a = 2; a <= 1000000; a++)
            licznik += ob.rozklad(a);
        System.out.print(licznik);
    }
}
