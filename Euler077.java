import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Marcin on 2016-02-07.
 */
public class Euler077 {
    List<Integer> lPrim = new ArrayList<>();
    int[][] tab;

    Euler077() {
        // sprawdzam liczby do 1000, powinno starczyć - jak nie to zwiększę
        int l = 1000;
        genPrim(l);
        tab = new int[lPrim.size()][l + 1];
        for (int a = 0; a < lPrim.size(); a++)
            for (int b = 0; b <= l; b++)
                tab[a][b] = f(a, b);
        for (int a = 2; a < 1000; a++)
            if (tab[lPrim.size() - 1][a + 1] >= 5000) {
                System.out.println(a + 1);
                break;
            }
    }

    int f(int iMax, int number) {
        if (number == 0)
            return 1;
        if (iMax == 0)
            return 0;
        else if (lPrim.get(iMax) <= number)
            return tab[iMax - 1][number] + tab[iMax][number - lPrim.get(iMax)];
        else
            return tab[iMax - 1][number];
    }

    void genPrim(int n) {
        lPrim.add(0);
        boolean[] tab = new boolean[n + 1];
        Arrays.fill(tab, true);
        for (int a = 2; a <= n; a++)
            if (tab[a]) {
                lPrim.add(a);
                for (int b = a * 2; b <= n; b += a)
                    tab[b] = false;
            }
    }

    public static void main(String[] args) {
        Euler077 ob = new Euler077();
    }
}
