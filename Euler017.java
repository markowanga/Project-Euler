/**
 * Created by Marcin on 2015-11-23.
 */
public class Euler017 {
    String[] tC = {"one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine"};
    String[] nas = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"};
    String[] dzies = {"ten", "twenty", "thirty", "forty", "fifty", "sixty",
            "seventy", "eighty", "ninety"};

    int ileZnakow(int l) {
        int w = 0;
        boolean czyAnd = false;
        if (l == 1000) {
            System.out.print("one thousand ");
            return 11;
        }
        if (l >= 100) {
            czyAnd = true;
            System.out.print(tC[l / 100 - 1] + " " + "hundred ");
            w += tC[l / 100 - 1].length() + 7;
            l %= 100;
        }
        if (l >= 20) {
            if (czyAnd) {
                System.out.print("and ");
                w += 3;
                czyAnd = false;
            }
            System.out.print(dzies[l / 10 - 1] + " ");
            w += dzies[l / 10 - 1].length();
            l %= 10;
        }
        if (l > 10) {
            if (czyAnd) {
                System.out.print("and ");
                w += 3;
                czyAnd = false;
            }
            System.out.print(nas[l - 11] + " ");
            w += nas[l - 11].length();
            l = 0;
        }
        if (l == 10) {
            if (czyAnd) {
                System.out.print("and ");
                w += 3;
                czyAnd = false;
            }
            System.out.print(dzies[0] + " ");
            w += dzies[0].length();
            l = 0;
        }
        if (l > 0) {
            if (czyAnd) {
                System.out.print("and ");
                w += 3;
            }
            System.out.print(tC[l - 1] + " ");
            w += tC[l - 1].length();
        }
        return w;
    }

    public static void main(String[] args) {
        Euler017 ob = new Euler017();
        int w = 0;
        for (int a = 1; a <= 1000; a++) {
            //w += ob.ileZnakow(a);
            System.out.print(a + ": ");
            System.out.println(w += ob.ileZnakow(a));
        }
        System.out.print(w);
    }
}
