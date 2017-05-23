import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Marcin on 2015-11-24.
 */
public class Euler029 {
    BigInteger pot(BigInteger l, int n) {
        BigInteger w = new BigInteger("1");
        while (n > 0) {
            if (n % 2 != 0)
                w = w.multiply(l);
            l = l.multiply(l);
            n /= 2;
        }
        return w;
    }

    int zadanie() {
        Set<BigInteger> Z = new HashSet<>();
        for (int a = 2; a <= 100; a++)
            for (int b = 2; b <= 100; b++)
                Z.add(pot(new BigInteger(String.valueOf(a)), b));
        return Z.size();
    }

    public static void main(String[] args) {
        Euler029 ob = new Euler029();
        System.out.print(ob.zadanie());
    }
}
