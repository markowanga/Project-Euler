import java.math.BigInteger;

/**
 * Created by Marcin on 2015-12-03.
 */
public class Euler066 {
    int wylicz(int x, int y, int d) {
        BigInteger X = new BigInteger(String.valueOf(x));
        BigInteger Y = new BigInteger(String.valueOf(y));
        BigInteger D = new BigInteger(String.valueOf(d));
        System.out.print(X.pow(2).subtract(D.multiply(Y.pow(2))) + " ");
        return BigInteger.ONE.compareTo(X.pow(2).subtract(D.multiply(Y.pow(2))));
    }

    int znajdzRozw(int d) {
        System.out.println();
        System.out.print(d + ": ");
        int x = 1, y = 1;
        int p = wylicz(x, y, d);
        while (p != 0) {
            if (p == 1)
                x++;
            else y++;
            System.out.print("(" + x + "," + y + ") ");
            p = wylicz(x, y, d);
        }
        return x;
    }

    int zadanie() {
        int wyn = 0;
        int d = 0;
        int p;
        for (int a = 3; a <= 1000; a++)
            if (Math.sqrt(a) != (int) Math.sqrt(a)) {
                p = znajdzRozw(a);
                System.out.print(a + " ");
                if (p > wyn) {
                    p = wyn;
                    d = a;
                }
            }
        return d;
    }

    public static void main(String[] args) {
        Euler066 ob = new Euler066();
        System.out.print(ob.zadanie());
    }
}
