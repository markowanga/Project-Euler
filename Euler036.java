/**
 * Created by Marcin on 2015-11-25.
 */
public class Euler036 {
    boolean ifPali(String A) {
        int d = A.length();
        for (int a = 0; a < d / 2; a++)
            if (A.charAt(a) != A.charAt(d - a - 1))
                return false;
        return true;
    }

    boolean ifBinPali(int l) {
        String A = "";
        if (l == 0)
            return true;
        while (l > 0) {
            if (l % 2 == 0)
                A += "0";
            else A += "1";
            l /= 2;
        }
        return ifPali(A);
    }

    int zadanie() {
        int s = 0;
        for (int a = 1; a < 1000000; a += 2)
            if (ifPali(String.valueOf(a)) && ifBinPali(a))
                s += a;
        return s;
    }

    public static void main(String[] args) {
        Euler036 ob = new Euler036();
        System.out.print(ob.zadanie());
    }

}
