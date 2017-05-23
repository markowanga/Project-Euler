/**
 * Created by Marcin on 2015-11-26.
 */
public class Euler043 {
    long w;

    void dodajCyfre(long l, int dl, boolean[] tab) {
        if (dl == 4 && (l % 1000) % 2 != 0)
            return;
        if (dl == 5 && (l % 1000) % 3 != 0)
            return;
        if (dl == 6 && (l % 1000) % 5 != 0)
            return;
        if (dl == 7 && (l % 1000) % 7 != 0)
            return;
        if (dl == 8 && (l % 1000) % 11 != 0)
            return;
        if (dl == 9 && (l % 1000) % 13 != 0)
            return;
        if (dl == 10 && (l % 1000) % 17 != 0)
            return;
        else if (dl == 10)
            w += l;
        long pom = l * 10;
        for (int a = 0; a < 10; a++)
            if (!tab[a]) {
                tab[a] = true;
                dodajCyfre(pom + a, dl + 1, tab);
                tab[a] = false;
            }
    }

    long zadanie() {
        w = 0;
        boolean[] tab = new boolean[10];
        for (int a = 0; a < 10; a++)
            tab[a] = false;

        for (int a = 1; a < 10; a++) {
            tab[a] = true;
            dodajCyfre(a, 1, tab);
            tab[a] = false;
        }
        return w;
    }

    public static void main(String[] args) {
        Euler043 ob = new Euler043();
        System.out.print(ob.zadanie());
    }
}
