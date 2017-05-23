/**
 * Created by Marcin on 2015-11-23.
 */
public class Euler021 {
    int sumaDziel(int l) {

        int s = 1;
        int a;
        for (a = 2; a * a < l; a++)
            if (l % a == 0) {
                s += a + l / a;
            }
        if (a * a == l)
            s += a;
        return s;
    }

    boolean czyAmicable(int a, int b) {
        return (sumaDziel(a) == b) && (sumaDziel(b) == a) && (a != b) && (a < 10000) && (b < 10000);
    }

    public static void main(String[] args) {
        Euler021 ob = new Euler021();
        int w = 0;
        for (int a = 1; a <= 10000; a++) {
            if (ob.czyAmicable(a, ob.sumaDziel(a)))
                w += a + ob.sumaDziel(a);
        }
        System.out.print(w / 2);
    }
}
