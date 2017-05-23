/**
 * Created by Marcin on 2015-11-27.
 */
public class Euler052 {
    int[] wTab(int l) {
        int[] tab = new int[10];
        for (int b = 0; b < 10; b++)
            tab[b] = 0;
        while (l > 0) {
            tab[l % 10]++;
            l /= 10;
        }
        return tab;
    }

    boolean chcek(int l) {
        int[] T = new int[10], P = new int[10];
        T = wTab(l);
        for (int a = 2; a <= 6; a++) {
            P = wTab(l * a);
            for (int b = 0; b < 10; b++)
                if (P[b] != T[b])
                    return false;
        }
        return true;
    }

    int zadanie() {
        int w = -1;
        int mn = 1;
        while (w == -1) {
            for (int l = mn; l < mn * 2 && w == -1; l++)
                if (chcek(l))
                    w = l;
            mn *= 10;
        }
        return w;
    }

    public static void main(String[] args) {
        Euler052 ob = new Euler052();
        System.out.print(ob.zadanie());
    }
}