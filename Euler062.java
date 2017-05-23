import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Marcin on 2015-12-02.
 */
public class Euler062 {
    int naj = 0;
    List<Integer[]> tab = new ArrayList<>();

    Integer[] zamianaLongTab(long l) {
        Integer[] t = new Integer[10];
        Arrays.fill(t, 0);
        while (l > 0) {
            t[(int) (l % 10)]++;
            l /= 10;
        }
        return t;
    }

    void dodaj() {
        int liczba = tab.size();
        tab.add(zamianaLongTab((long) Math.pow(liczba, 3)));
    }

    boolean porTab(Integer[] t1, Integer[] t2) {
        for (int a = 0; a < 10; a++)
            if (t1[a] != t2[a])
                return false;
        return true;
    }

    int ilePer() {
        int w = 0;
        for (int a = tab.size() - 2; a >= 0; a--)
            if (porTab(tab.get(a), tab.get(tab.size() - 1))) {
                w++;
                naj = a;
            }
        return w;
    }

    long zadanie() {
        dodaj();
        int l = 0;
        int k = 0;
        while (l != 4) {
            dodaj();
            k++;
            l = ilePer();
        }
        return (long) Math.pow(naj, 3);
    }

    public static void main(String[] args) {
        Euler062 ob = new Euler062();
        System.out.print(ob.zadanie());
    }
}
