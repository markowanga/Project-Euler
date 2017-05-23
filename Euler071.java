/**
 * Created by Marcin on 2016-02-07.
 */
public class Euler071 {
    double pocz = (3 * 1.0) / 7;
    double gran = (2 * 1.0) / 5;
    int numerator = 0;

    int nwd(int a, int b) {
        if (a % b == 0)
            return b;
        else return nwd(b, a % b);
    }

    void szukajdla(int n) {
        int p = (int) (pocz * n);
        while (((p * 1.0) / n) > gran) {
            if (nwd(p, n) == 1) {
                numerator = p;
                gran = (p * 1.0) / n;
            }
            p--;
        }
    }

    public static void main(String[] args) {
        Euler071 ob = new Euler071();
        for (int a = 8; a <= 1000000; a++)
            ob.szukajdla(a);
        System.out.print(ob.numerator);
    }
}
