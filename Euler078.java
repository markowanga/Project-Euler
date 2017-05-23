/**
 * Created by Marcin on 2016-02-07.
 */
public class Euler078 {
    int[][] tab;

    Euler078(int l) {
        tab = new int[l + 1][l + 1];
        for (int a = 1; a <= l; a++)
            for (int b = 0; b <= l; b++)
                tab[a][b] = f(a, b);
        System.out.println(tab[l - 1][l]);
        for (int a = 1; a < 10; a++)
            System.out.println(a + " " + tab[a][a]);
    }

    int f(int sMax, int number) {
        if (number == 0)
            return 1;
        if (sMax == 1)
            return 1;
        else if (sMax <= number)
            return tab[sMax - 1][number] + tab[sMax][number - sMax];
        else
            return tab[sMax - 1][number];
    }

    public static void main(String[] args) {
        Euler078 ob = new Euler078(55000);
    }
}