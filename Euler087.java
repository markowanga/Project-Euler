import java.util.*;

/**
 * Created by Marcin on 2016-02-26.
 */
public class Euler087 {
    List<Integer> p, p2, p3, p4;

    Euler087() {
        uzupelniejStrukturyLP();
        System.out.print(oblicz());
    }

    void uzupelniejStrukturyLP() { // <7071
        boolean[] B = new boolean[7200];
        Arrays.fill(B, true);
        B[0] = false;
        B[1] = false;
        for (int a = 2; a < 7200; a++)
            for (int b = a * 2; b < 7200; b += a)
                B[b] = false;


        p = new ArrayList<>();
        for (int a = 0; a < 7200; a++)
            if (B[a])
                p.add(a);

        p2 = new ArrayList<>();
        for (int a = 0; p.get(a) <= 7071; a++)
            p2.add((int) Math.pow(p.get(a), 2));

        p3 = new ArrayList<>();
        for (int a = 0; p.get(a) <= 368; a++)
            p3.add((int) Math.pow(p.get(a), 3));

        p4 = new ArrayList<>();
        for (int a = 0; p.get(a) <= 84; a++)
            p4.add((int) Math.pow(p.get(a), 4));

        p.clear();
    }

    int oblicz() {
        Set<Integer> z3i4 = new HashSet<>(), z = new HashSet<>();
        for (Integer i1 : p4)
            for (Integer i2 : p3)
                if (i1 + i2 < 50000000)
                    z3i4.add(i1 + i2);
        for (Integer i1 : p2)
            for (Integer i2 : z3i4)
                if (i1 + i2 < 50000000)
                    z.add(i1 + i2);

        return z.size();
    }

    public static void main(String[] args) {
        new Euler087();
    }
}
