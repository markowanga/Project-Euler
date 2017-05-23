import java.math.BigDecimal;

/**
 * Created by Marcin on 2016-02-14.
 */
public class Euler080 {
    BigDecimal mnoznik;

    Euler080() {
        mnoznik = new BigDecimal("0.1");
        int s = 0;
        for (int a = 1; a <= 100; a++)
            s += sumaNiew100(a);
        System.out.print(s);
    }

    int sumaCyfr(int l) {
        int s = 0;
        while (l > 0) {
            s += l % 10;
            l /= 10;
        }
        return s;
    }

    int sumaNiew100(int number) {
        int s = 0;
        if (Math.sqrt(number) != (int) Math.sqrt(number)) {
            s = sumaCyfr((int) Math.sqrt(number));
            BigDecimal l = new BigDecimal(((int) Math.sqrt(number)));
            BigDecimal wzor = new BigDecimal(number);
            BigDecimal m = new BigDecimal("0.1");

            for (int i = 1; i < 100; i++) {
                int lMax = 1;
                l = l.add(m);
                while (l.pow(2).compareTo(wzor) == -1) {
                    l = l.add(m);
                    lMax++;
                }
                l = l.subtract(m);
                s += lMax - 1;
                m = m.multiply(mnoznik);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        new Euler080();
    }
}
