/**
 * Created by Marcin on 2016-02-27.
 */
public class Euler086 {
    Euler086() {
        int liczba = 0, nr = 0;
        while (liczba <= 1000000) {
            nr++;
            for (int b = 1; b <= nr; b++)
                for (int c = 1; c <= b; c++)
                    if (ifInt(minBok(nr, b, c)))
                        liczba++;
        }
        System.out.print(nr);
    }

    double minBok(int a, int b, int c) {
        int w1 = (int) Math.pow(a + b, 2) + c * c;
        int w2 = (int) Math.pow(a + c, 2) + b * b;
        int w3 = (int) Math.pow(c + b, 2) + a * a;
        if (w1 > w2)
            w1 = w2;
        if (w1 > w3)
            w1 = w3;
        return Math.sqrt(w1);
    }

    boolean ifInt(double a) {
        return a == (int) a;
    }

    public static void main(String[] args) {
        new Euler086();
    }
}