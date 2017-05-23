/**
 * Created by Marcin on 2015-11-24.
 */
public class Euler027 {
    boolean czPier(int l) {
        if (l < 2)
            return false;
        for (int a = 2; a * a <= l; a++)
            if (l % a == 0)
                return false;
        return true;
    }

    int iloscPier(int a, int b) {
        int n = 0;
        while (czPier(n * n + a * n + b))
            n++;
        return n;
    }

    int zad() {
        int max = 0, w = 0;
        for (int a = -999; a < 1000; a++)
            for (int b = -999; b < 1000; b++)
                if (iloscPier(a, b) > max) {
                    max = iloscPier(a, b);
                    w = a * b;
                }
        return w;
    }

    public static void main(String[] args) {
        Euler027 ob = new Euler027();
        System.out.print(ob.zad());
    }
}
