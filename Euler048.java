/**
 * Created by Marcin on 2015-11-27.
 */
public class Euler048 {
    long ost10(long l) {
        long w = 1;
        for (int a = 0; a < l; a++)
            w = (w * l) % 10000000000L;
        return w;
    }

    long zadanie() {
        long w = 0;
        for (long a = 1; a <= 1000; a++)
            w += ost10(a);
        return w % 10000000000L;
    }

    public static void main(String[] args) {
        Euler048 ob = new Euler048();
        System.out.print(ob.zadanie());
    }
}
