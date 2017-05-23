/**
 * Created by Marcin on 2015-11-24.
 */
public class Euler023 {
    boolean[] tab;

    boolean czyAbaudant(int l) {
        int s = 1;
        int a;
        for (a = 2; a * a < l; a++)
            if (l % a == 0)
                s += a + l / a;
        if (a * a == l)
            s += a;
        return s > l;
    }

    Euler023() {
        tab = new boolean[30000];
        tab[0] = false;
        for (int a = 1; a < 30000; a++)
            tab[a] = czyAbaudant(a);
    }

    public static void main(String[] args) {
        Euler023 ob = new Euler023();
        int s = 0;
        for (int a = 1; a < 30000; a++) {
            for (int b = 1; b < a; b++)
                if (ob.tab[b] && ob.tab[a - b]) {
                    s += a;
                    break;
                }
        }
        System.out.print(15000 * 29999 - s);
    }
}
