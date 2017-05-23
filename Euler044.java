/**
 * Created by Marcin on 2015-11-27.
 */
public class Euler044 {
    boolean ifPentagonal(int l) {
        double x = (Math.sqrt(24 * l + 1.0) + 1) / 6;
        return x == (int) x;
    }

    int pentagonal(int l) {
        return l * (3 * l - 1) / 2;
    }

    int zadanie() {
        boolean ifIsIt = false;
        int k = 1, p1, p2 = 0;
        int r = 0;
        while (!ifIsIt || pentagonal(k) - pentagonal(k - 1) > r) {
            k++;
            p1 = pentagonal(k);
            for (int l = k - 1; (!ifIsIt && l > 0) || p1 - (p2 = pentagonal(l)) < r; l--) {
                if (!ifIsIt)
                    p2 = pentagonal(l);
                if (ifPentagonal(p1 - p2) && ifPentagonal(p2 + p1)) {
                    r = p1 - p2;
                    ifIsIt = true;
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Euler044 ob = new Euler044();
        System.out.print(ob.zadanie());
    }
}
