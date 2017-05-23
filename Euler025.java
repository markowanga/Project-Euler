import java.math.BigInteger;

/**
 * Created by Marcin on 2015-11-24.
 */
public class Euler025 {
    BigInteger l1, l2;
    int licznik = 2;

    Euler025() {
        l1 = new BigInteger("1");
        l2 = new BigInteger("1");
    }

    void nasFib() {
        BigInteger l3 = l2;
        l2 = l1;
        l1 = l2.add(l3);
        licznik++;
    }

    public static void main(String[] args) {
        Euler025 ob = new Euler025();
        BigInteger por = new BigInteger("1");
        for (int a = 0; a < 999; a++)
            por = por.multiply(new BigInteger("10"));
        while (ob.l1.compareTo(por) == -1)
            ob.nasFib();
        System.out.print(ob.licznik);
    }
}
