import java.math.BigInteger;

/**
 * Created by Marcin on 2015-11-27.
 */
public class Euler056 {
    int sumDig(String A) {
        int s = 0;
        for (int a = 0; a < A.length(); a++)
            s += (int) A.charAt(a) - 48;
        return s;
    }

    int max(int a, int b) {
        if (a > b)
            return a;
        else return b;
    }

    int dlaPodst(int l) {
        int w = 0;
        BigInteger A = new BigInteger(String.valueOf(l)), P = new BigInteger(String.valueOf(l));
        for (int a = 1; a <= 100; a++) {
            w = max(sumDig(A.toString()), w);
            A = A.multiply(P);
        }
        return w;
    }

    int zadanie() {
        int w = 0;
        for (int a = 1; a <= 100; a++)
            w = max(w, dlaPodst(a));
        return w;
    }

    public static void main(String[] args) {
        Euler056 ob = new Euler056();
        System.out.print(ob.zadanie());
    }
}
