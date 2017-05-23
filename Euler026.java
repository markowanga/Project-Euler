import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marcin on 2015-11-24.
 */
public class Euler026 {
    int liczOk(int d) {
        Map<Integer, Integer> map = new HashMap<>();
        int licznik = 0;
        int dzielna = 1;
        while (!map.containsKey(dzielna)) {
            map.put(dzielna, licznik);
            dzielna %= d;
            dzielna *= 10;
            licznik++;
        }
        if (dzielna == 0)
            return 0;
        else return licznik - map.get(dzielna);
    }

    public static void main(String[] args) {
        Euler026 ob = new Euler026();
        int max = 1;
        for (int a = 1; a < 1000; a++)
            if (ob.liczOk(max) < ob.liczOk(a))
                max = a;
        System.out.print(max);
    }
}
