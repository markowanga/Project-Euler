import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-11-29.
 */
public class Euler033 {
    boolean czyOk(double l, double m) {
        if (l / m >= 1)
            return false;
        double l1 = (int) l / 10;
        double l2 = (int) l % 10;
        if (l1 == 0 || l2 == 0)
            return false;
        double m1 = (int) m / 10;
        double m2 = (int) m % 10;
        if (l2 == m2 && l / m == l1 / m1)
            return true;
        if (l1 == m2 && l / m == l2 / m1)
            return true;
        if (m2 != 0 && (l1 == m1 && l / m == l2 / m2))
            return true;
        if (m2 != 0 && (l2 == m1 && l / m == l1 / m2))
            return true;
        return false;
    }

    int NWD(int a, int b) {
        int c;
        if (a < b) {
            c = a;
            a = b;
            b = c;
        }
        while (a % b != 0) {
            c = b;
            b = a % b;
            a = c;
        }
        return b;
    }

    int zadanie() {
        int licz = 1;
        int mian = 1;
        for (int l = 10; l < 100; l++)
            for (int m = 10; m < 100; m++)
                if (czyOk(l, m)) {
                    licz *= l;
                    mian *= m;
                }
        return mian / NWD(mian, licz);
    }

    public static void main(String[] args) {
        Euler033 ob = new Euler033();
        System.out.print(ob.zadanie());
    }
}
