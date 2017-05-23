/**
 * Created by Marcin on 2015-11-27.
 */
public class Euler051 {
    /*
    jak true to liczba sie zmienia
    jak false to zostaje
     */
    boolean ifPrime(int l) {
        if (l < 2)
            return false;
        for (int a = 2; a * a <= l; a++)
            if (l % a == 0)
                return false;
        return true;
    }

    int numberDig(int l) {
        int w = 1;
        while (l > 9) {
            w++;
            l /= 10;
        }
        return w;
    }

    boolean[] zamienNaBin(int l, int dl) {
        // 1 - true, 0 - false
        boolean[] tab = new boolean[dl];
        dl--;
        while (dl >= 0) {
            tab[dl] = (l % 2 == 1);
            l /= 2;
            dl--;
        }
        return tab;
    }

    int ileCyfr(boolean[] tab) {
        int w = 0;
        for (int a = 0; a < tab.length; a++)
            if (!tab[a])
                w++;
        return w;
    }

    int warunek(boolean[] tab, int l) {
        int[] T = new int[tab.length];
        for (int a = T.length - 1; a >= 0; a--) {
            if (!tab[a]) {
                T[a] = l % 10;
                l /= 10;
            }
        }
        int ileZlych;
        int w = -1;
        if (tab[0]) { // jak nie sprawdzamy 0
            ileZlych = 1;
            for (int a = 1; a < 10 && ileZlych < 3; a++) {
                for (int b = 0; b < T.length; b++)
                    if (tab[b])
                        T[b] = a;
                int k = 0;
                int mn = 1;
                for (int b = T.length - 1; b >= 0; b--) {
                    k += T[b] * mn;
                    mn *= 10;
                }
                if (ifPrime(k)) {
                    if (w == -1)
                        w = k;
                } else ileZlych++;
            }
        } else {
            ileZlych = 0;
            for (int a = 0; a < 10 && ileZlych < 3; a++) {
                for (int b = 0; b < T.length; b++)
                    if (tab[b])
                        T[b] = a;
                int k = 0;
                int mn = 1;
                for (int b = T.length - 1; b >= 0; b--) {
                    k += T[b] * mn;
                    mn *= 10;
                }
                if (ifPrime(k)) {
                    if (w == -1)
                        w = k;
                } else ileZlych++;
            }
        }
        if (ileZlych == 2)
            return w;
        return -1;
    }

    int zadanie() {
        boolean[] tab;
        int l = -1;
        int dl = 2;
        int gran = 4;
        int pom;
        boolean itIs = false; //  czy znalazlem liczb
        while (!itIs) {
            for (int a = 1; a < gran; a++) {
                tab = zamienNaBin(a, dl);
                int d = (int) Math.pow(10, ileCyfr(tab));
                for (int b = d / 10; b < d; b++) {
                    if ((warunek(tab, b)) != -1)
                        if (!itIs || warunek(tab, b) < l) {
                            itIs = true;
                            l = warunek(tab, b);
                        }
                }
            }
            gran *= 2;
            dl++;
        }
        return l;
    }

    public static void main(String[] args) {
        Euler051 ob = new Euler051();
        System.out.print(ob.zadanie());
    }
}
