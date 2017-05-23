/**
 * Created by Marcin on 2016-02-09.
 */
public class Euler092 {
    int[] t = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
    int licznik = 0;

    Euler092() {
        int tym;
        for (int a = 1; a <= 10000000; a++) {
            tym = a;
            while (tym != 1 && tym != 89) {
                tym = s(tym);
            }
            if (tym == 89)
                licznik++;
        }
        System.out.print(licznik);
    }

    int s(int i) {
        int w = 0;
        while (i > 0) {
            w += t[i % 10];
            i /= 10;
        }
        return w;
    }

    public static void main(String[] args) {
        Euler092 ob = new Euler092();
    }
}
