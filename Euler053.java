import java.math.BigInteger;

/**
 * Created by Marcin on 2015-11-27.
 */
public class Euler053 {
    BigInteger silnia(BigInteger x) {
        if (x.equals(new BigInteger("0")))
            return new BigInteger("1");
        else
            return x.multiply(silnia(x.subtract(new BigInteger("1"))));
    }

    BigInteger C(int k, int n) {
        return silnia(new BigInteger(String.valueOf(n)))
                .divide(silnia(new BigInteger(String.valueOf(k)))
                        .multiply(silnia(new BigInteger(String.valueOf(n - k)))));
    }

    int zadanie() {
        int w = 0;
        for (int a = 1; a <= 100; a++)
            for (int b = 0; b <= a; b++)
                if (C(b, a).compareTo(new BigInteger("1000000")) == 1)
                    w++;
        return w;
    }

    public static void main(String[] args) {
        Euler053 ob = new Euler053();
        System.out.print(ob.zadanie());
    }
}
