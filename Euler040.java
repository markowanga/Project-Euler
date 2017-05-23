/**
 * Created by Marcin on 2015-11-25.
 */
public class Euler040 {
    int zadanie() {
        // niezoptymalizowany
        String str = "";
        int l = 1;
        while (str.length() < 1000000) {
            str += String.valueOf(l);
            l++;
            System.out.println(str.length());
        }
        return ((int) str.charAt(0) - 48) * ((int) str.charAt(9) - 48) * ((int) str.charAt(99) - 48)
                * ((int) str.charAt(999) - 48) * ((int) str.charAt(9999) - 48)
                * ((int) str.charAt(99999) - 48) * ((int) str.charAt(999999) - 48);
    }

    int dl(int a) {
        int w = 1;
        while (a > 9) {
            a /= 10;
            w++;
        }
        return w;
    }

    public static void main(String[] args) {
        Euler040 ob = new Euler040();
        System.out.print(ob.zadanie());
    }
}