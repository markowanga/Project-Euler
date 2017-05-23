/**
 * Created by Marcin on 2015-11-25.
 */
public class Euler034 {
    int silnia(int l) {
        if (l == 0) return 1;
        return l * silnia(l - 1);
    }

    int sumaSil(int l) {
        int s = 0;
        while (l > 0) {
            s += silnia(l % 10);
            l /= 10;
        }
        return s;
    }

    int zadanie() {
        int s = 0;
        for (int a = 3; a < 1000000; a++)
            if (sumaSil(a) == a) {
                s += a;
                System.out.println(a);
            }
        return s;
    }

    public static void main(String[] args) {
        Euler034 ob = new Euler034();
        System.out.print(ob.zadanie());
    }
}
