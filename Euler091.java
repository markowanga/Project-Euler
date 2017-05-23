import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Marcin on 2016-02-27.
 */
public class Euler091 {
    Euler091() {
        int licznik = 0;
        for (int a = 1; a < 2601; a++)
            for (int b = 1; b < a; b++)
                if (spr(a, b))
                    licznik++;
        System.out.print(licznik);
    }

    boolean spr(int a, int b) {
        int x1 = a / 51, x2 = b / 51, y1 = a % 51, y2 = b % 51;
        SortedSet<Integer> z = new TreeSet<>();
        z.add((int) Math.pow(x1, 2) + (int) Math.pow(y1, 2));
        z.add((int) Math.pow(x2, 2) + (int) Math.pow(y2, 2));
        z.add((int) Math.pow(x1 - x2, 2) + (int) Math.pow(y1 - y2, 2));
        int s = 0;
        for (Integer i : z)
            s += i;
        return !(s == 2 * z.last());
    }

    public static void main(String[] args) {
        new Euler091();
    }
}
