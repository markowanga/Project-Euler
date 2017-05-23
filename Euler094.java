/**
 * Created by Marcin on 2016-03-05.
 */
public class Euler094 {
    private long suma;

    public Euler094() {
        suma = 0;
        for (int a = 2; 3 * a + 1 < 1000000000; a++) {
            if (a % 10000000 == 0)
                System.out.println(a);
            sprPola(a);
        }
        System.out.println(suma);
    }

    private boolean ifInteger(double a) {
        return a == (int) a;
    }

    private void sprPola(int a) {
        double p = 3 * a * a - 2 * a;
        double p1 = Math.sqrt(p - 1) / 4, p2 = Math.sqrt(p + 1) / 4;
        if (ifInteger(p1))
            suma += 3 * a - 1;
        if (ifInteger(p2))
            suma += 3 * a + 1;
    }

    public static void main(String[] args) {
        new Euler094();
    }
}
