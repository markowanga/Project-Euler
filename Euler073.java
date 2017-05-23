/**
 * Created by Marcin on 2016-02-07.
 */
public class Euler073 {
    double pocz = (1.0) / 3;
    double gran = (1.0) / 2;
    int count = 0;

    int nwd(int a, int b) {
        if (a % b == 0)
            return b;
        else return nwd(b, a % b);
    }

    void szukajdla(int n) {
        int p = (int) (pocz * n) + 1;
        while (((p * 1.0) / n) < gran) {
            if (nwd(p, n) == 1)
                count++;
            p++;
        }
    }

    public static void main(String[] args) {
        Euler073 ob = new Euler073();
        for (int a = 2; a <= 12000; a++)
            ob.szukajdla(a);
        System.out.print(ob.count);
    }
}