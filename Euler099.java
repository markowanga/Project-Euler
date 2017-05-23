import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Marcin on 2016-02-08.
 */
public class Euler099 {
    List<Para> zb = new ArrayList<>();

    Euler099() {
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(new File("base_exp.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: Nie ma takiego pliku");
        }
        while (sc.hasNext()) {
            StringTokenizer t = new StringTokenizer(sc.next());
            zb.add(new Para(Double.valueOf(t.nextToken(",")), Integer.valueOf(t.nextToken())));
        }
        int max = 0;
        for (int a = 0; a < 1000; a++)
            if (porownaj(zb.get(max), zb.get(a)) == -1)
                max = a;
        System.out.println(max + 1);
    }

    int porownaj(Para l1, Para l2) {
        while (l1.i > 1 && l2.i > 1) {
            if (l1.i > l2.i) {
                l1 = new Para(l1.d, l1.i - l2.i);
                l2 = new Para(l2.d / l1.d, l2.i);
            } else {
                l2 = new Para(l2.d, l2.i - l1.i);
                l1 = new Para(l1.d / l2.d, l1.i);
            }
        }
        return Math.pow(l1.d, l1.i) > Math.pow(l2.d, l2.i) ? 1 : -1;
    }

    public class Para {
        double d;
        int i;

        Para(double a, int b) {
            d = a;
            i = b;
        }

        public String toString() {
            return "" + d + " " + i;
        }
    }


    public static void main(String[] args) {
        Euler099 ob = new Euler099();
    }
}
