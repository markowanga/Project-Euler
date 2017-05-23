/**
 * Created by Marcin on 2015-11-25.
 */
public class Euler039 {
    int ilProsDlaOb(int l) {
        int licz = 0;
        int a = l / 2, b = 1;
        while (a > b) {
            if (a * a + b * b == (l - a - b) * (l - a - b)) {
                licz++;
                a--;
            } else if (a * a + b * b > (l - a - b) * (l - a - b))
                a--;
            else b++;
        }
        return licz;
    }

    int zadanie() {
        int max = 0;
        int w = 0, tym;
        for (int a = 3; a < 1000; a++) {
            tym = ilProsDlaOb(a);
            if (tym > max) {
                max = tym;
                w = a;
            }
        }
        return w;
    }

    public static void main(String[] args) {
        Euler039 ob = new Euler039();
        System.out.print(ob.zadanie());
    }
}
