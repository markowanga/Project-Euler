import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-11-29.
 */
// 0, 1, 4, 5, 3, 2
public class Euler061 {
    // tutaj przechowywane s? liczby odpowiednie
    Integer[][] numb = new Integer[6][];
    // tutaj przechowywana jest kolejno?? zbior?w
    int[] per = new int[6];
    // informacja czy dany zbi?r mo?e by? jeszcze wykorzystany w permutacji
    boolean[] czyDostepneWPer = new boolean[6];
    // suma ko?cowa, liczba pocz?tkowa
    int suma = -1, pocz;

    // Tworzy konkretne liczby
    int P(int k, int n) {
        switch (k) {
            case 3:
                return n * (n + 1) / 2;
            case 4:
                return n * n;
            case 5:
                return n * (3 * n - 1) / 2;
            case 6:
                return n * (2 * n - 1);
            case 7:
                return n * (5 * n - 3) / 2;
            case 8:
                return n * (3 * n - 2);
        }
        return -1;
    }

    void uzu(int a) { // nale?y poda? k od 3 do 8
        List<Integer> tym = new ArrayList<>();
        int n = 1;
        int w = P(a, n);
        while (w < 10000) {
            n++;
            w = P(a, n);
            if (w >= 1000 && w < 10000)
                tym.add(w);
        }
        numb[a - 3] = tym.toArray(new Integer[tym.size()]);
    }

    // sprawdza czy dana liczby mog? by? obok siebie
    boolean sprPare(int a, int b, int k) {
        return
                a % 100 == b / 100;
    }

    // przeszukamy z nawrotami i szulamy rozwi?zania
    int sprawdzanie(int krok, int w) {
        //System.out.print(krok);
        if (krok == 5) {
            if (sprPare(w, pocz, krok))
                return w;
            else return -1;
        }
        // jak id? dalej
        int wTymCzas = -1;
        for (int a = 0; a < numb[per[krok + 1]].length && wTymCzas == -1; a++) {
            if (sprPare(w, numb[per[krok + 1]][a], krok))
                wTymCzas = sprawdzanie(krok + 1, numb[per[krok + 1]][a]);
            if (wTymCzas > 0)
                wTymCzas += w;
        }
        return wTymCzas;
    }

    void permutacja(int nr) {
        if (suma != -1)
            return;
        if (nr == 6) {
            // instrukcje ?eby sprawdzi? zbiory
            for (int a = 0; a < numb[0].length && suma == -1; a++) {
                pocz = numb[0][a];
                suma = sprawdzanie(0, numb[0][a]);
            }
        }
        for (int a = 0; a < 6; a++)
            if (!czyDostepneWPer[a]) {
                czyDostepneWPer[a] = true;
                per[nr] = a;
                permutacja(nr + 1);
                if (suma != -1)
                    return;
                czyDostepneWPer[a] = false;
            }
    }

    int zadanie() {
        // uzupe?nienie list
        for (int a = 3; a <= 8; a++)
            uzu(a);
        // szukaj
        for (int a = 0; a < 6; a++)
            czyDostepneWPer[a] = false;
        per[0] = 0;
        czyDostepneWPer[0] = true;
        permutacja(1);

        return suma;
    }

    public static void main(String[] args) {
        Euler061 ob = new Euler061();
        System.out.print(ob.zadanie());
    }
}