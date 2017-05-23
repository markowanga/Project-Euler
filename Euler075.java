import java.util.Arrays;

/**
 * Created by Marcin on 2016-02-07.
 */
public class Euler075 {
    int[] tab = new int[1500001];
    int liczik = 0;

    Euler075() {
        int p, l;
        Arrays.fill(tab, 0);
        for (int a = 2; a < 1224; a++)
            for (int b = 1; b < a; b++) {
                if (nwd(a, b) == 1 && (a + b) % 2 == 1) {
                    p = w(a, b);
                    l = p;
                    while (p <= 1500000) {
                        tab[p]++;
                        p += l;
                    }
                }
            }
        for (int a = 0; a <= 1500000; a++)
            if (tab[a] == 1)
                liczik++;
    }

    int nwd(int a, int b) {
        if (a % b == 0)
            return b;
        else return nwd(b, a % b);
    }

    int w(int m, int n) {
        return 2 * m * (m + n);
    }

    public static void main(String[] args) {
        Euler075 ob = new Euler075();
        System.out.print(ob.liczik);
    }
}
