/**
 * Created by Marcin on 2016-02-25.
 */
public class Euler085 {
    int[] tab;

    Euler085() {
        tab = new int[2001];
        tab[1] = 1;
        for (int a = 2; a < 2001; a++)
            tab[a] = tab[a - 1] + a;

        // Można szukać binarnie
        int rozw = 1;
        int il = 1;

        for (int a = 1; a <= 1000; a++)
            for (int b = 0; b <= 2000; b++)
                if (Math.abs(rozw - 2000000) > Math.abs(tab[a] * tab[b] - 2000000)) {
                    rozw = Math.abs(tab[a] * tab[b]);
                    il = a * b;
                }
        System.out.print(il);
    }

    public static void main(String[] args) {
        new Euler085();
    }
}
