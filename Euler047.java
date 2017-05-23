import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-11-27.
 */
public class Euler047 {
    List<Integer> nPrime = new ArrayList<>();

    boolean ifPrime(int l) {
        for (int a = 2; a * a <= l; a++)
            if (l % a == 0)
                return false;
        return true;
    }

    boolean rozklad(int l) {
        int licznik = 0;
        int ind = 0;
        while (l > 1 && licznik < 5) {
            if (l % nPrime.get(ind) == 0) {
                licznik++;
                while (l % nPrime.get(ind) == 0 && l > 1)
                    l /= nPrime.get(ind);
            }
            ind++;
        }
        return licznik == 4;
    }

    int zadanie() {
        int liczba = 1;
        int zRzedu = 0;
        while (zRzedu != 4) {
            liczba++;
            if (ifPrime(liczba)) {
                nPrime.add(liczba);
                zRzedu = 0;
            } else if (rozklad(liczba))
                zRzedu++;
            else
                zRzedu = 0;
        }
        return liczba - 3;
    }

    public static void main(String[] args) {
        Euler047 ob = new Euler047();
        System.out.print(ob.zadanie());
    }
}
