import java.math.BigInteger;

/**
 * Created by Marcin on 2015-12-02.
 */
public class Euler063 {
    int dl(BigInteger a) {
        return a.toString().length();
    }

    boolean spr(int pod, int pot) {
        return dl(new BigInteger(String.valueOf(pod)).pow(pot)) == pot;
    }

    int zadanie() {
        int licznik = 0;
        for (int a = 1; a < 10; a++) {
            int p = 1;
            while (spr(a, p)) {
                licznik++;
                p++;
            }
        }
        return licznik;
    }

    public static void main(String[] args) {
        Euler063 ob = new Euler063();
        System.out.print(ob.zadanie());
    }
}
