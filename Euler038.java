/**
 * Created by Marcin on 2015-11-25.
 */
public class Euler038 {
    boolean ifPanDigit(String A) {
        boolean[] tab = new boolean[10];
        for (int a = 0; a < 10; a++)
            tab[a] = false;
        for (int a = 0; a < 9; a++) {
            if (A.charAt(a) == '0' || tab[(int) A.charAt(a) - 48])
                return false;
            tab[(int) A.charAt(a) - 48] = true;
        }
        return A.length() == 9;
    }

    String makeNumber(int l) {
        String w = "";
        int mn = 1;
        while (w.length() < 9) {
            w += String.valueOf(mn * l);
            mn++;
        }
        return w;
    }

    boolean ifBigger(String A, String B) {
        for (int a = 0; a < 9; a++) {
            if (A.charAt(a) > B.charAt(a))
                return false;
            if (A.charAt(a) < B.charAt(a))
                return true;
        }
        return false;
    }

    String zadanie() {
        String max = "000000000";
        String tym;
        for (int a = 1; a < 100000; a++) {
            tym = makeNumber(a);
            if (ifPanDigit(tym) && ifBigger(max, tym))
                max = tym;
        }
        return max;
    }

    public static void main(String[] args) {
        Euler038 ob = new Euler038();
        System.out.print(ob.zadanie());
    }
}
