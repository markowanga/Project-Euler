/**
 * Created by Marcin on 2015-11-24.
 */
public class Euler030 {
    int sPotCyf(int l) {
        int s = 0;
        while (l > 0) {
            int p = l % 10;
            int pp = p * p;
            s += pp * pp * p;
            l /= 10;
        }
        return s;
    }

    int zadanie() {
        int s = 0;
        for (int a = 2; a <= 354294; a++)
            if (sPotCyf(a) == a)
                s += a;
        return s;
    }

    public static void main(String[] args) {
        Euler030 ob = new Euler030();
        System.out.print(ob.zadanie());
    }
}
