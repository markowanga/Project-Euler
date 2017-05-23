import java.math.BigInteger;

/**
 * Created by Marcin on 2015-11-27.
 */
public class Euler055 {
    boolean ifPali(BigInteger A) {
        String str = A.toString();
        for (int a = 0; a < str.length(); a++)
            if (str.charAt(a) != str.charAt(str.length() - a - 1))
                return false;
        return true;
    }

    String reverse(String A) {
        String B = "";
        for (int a = A.length() - 1; a >= 0; a--)
            B += A.charAt(a);
        return B;
    }

    boolean check(int k) {
        BigInteger l = new BigInteger(String.valueOf(k));
        boolean w = false;
        for (int a = 0; a < 50 && !w; a++) {
            l = l.add(new BigInteger(reverse(l.toString())));
            w = ifPali(l);
        }
        return w;
    }

    int zadanie() {
        int licznik = 0;
        for (int a = 1; a < 10000; a++)
            if (!check(a))
                licznik++;
        return licznik;
    }

    public static void main(String[] args) {
        Euler055 ob = new Euler055();
        System.out.print(ob.zadanie());
    }
}
