import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.*;

/**
 * Created by Marcin on 2016-02-25.
 */
public class Euler083 {
    int[][] mac;

    Euler083() {
        mac = new int[80][80];
        odczyt();
        System.out.print(minimalnaSuma());
    }

    void odczyt() {
        try {
            StreamTokenizer tok = new StreamTokenizer(new FileReader("matrix83.txt"));
            tok.ordinaryChar(',');
            tok.ordinaryChar('\n');
            for (int a = 0; a < 80; a++)
                for (int b = 0; b < 80; b++) {
                    tok.nextToken();
                    tok.nextToken();
                    mac[a][b] = (int) tok.nval;
                }
        } catch (FileNotFoundException e) {
            System.out.println(e + "\n Błąd odczytu");
        } catch (IOException e) {
            System.out.println(e + "\nBłąd odczytu z tokenizera");
        }
    }

    int minimalnaSuma() {
        int[][] pom = new int[80][80];
        // przygotowanie pom
        pom[0][0] = mac[0][0];
        for (int a = 1; a < 80; a++) {
            pom[0][a] = mac[0][a] + pom[0][a - 1];
            pom[a][0] = mac[a][0] + pom[a - 1][0];
        }
        for (int a = 1; a < 80; a++)
            for (int b = 1; b < 80; b++)
                pom[a][b] = mac[a][b] + Math.min(pom[a - 1][b], pom[a][b - 1]);

        // aktualizowanie
        SortedSet<Integer> set = new TreeSet<>();
        for (int a = 0; a < 80; a++)
            for (int b = 0; b < 80; b++)
                if (aktualizujPole(pom, a, b))
                    set.add(a * 80 + b);
        while (!set.isEmpty()) {
            int p = set.first();
            if (p / 80 != 0)
                if (aktualizujPole(pom, p / 80 - 1, p % 80))
                    set.add(p - 80);
            if (p / 80 != 79)
                if (aktualizujPole(pom, p / 80 + 1, p % 80))
                    set.add(p + 80);
            if (p % 80 != 0)
                if (aktualizujPole(pom, p / 80, p % 80 - 1))
                    set.add(p - 1);
            if (p % 80 != 79)
                if (aktualizujPole(pom, p / 80, p % 80 + 1))
                    set.add(p + 1);
            set.remove(p);
        }

        return pom[79][79];
    }

    boolean aktualizujPole(int[][] tab, int w, int k) {
        boolean czyAkt = false;
        if (w != 0 && tab[w - 1][k] + mac[w][k] < tab[w][k]) {
            tab[w][k] = tab[w - 1][k] + mac[w][k];
            czyAkt = true;
        }
        if (w != 79 && tab[w + 1][k] + mac[w][k] < tab[w][k]) {
            tab[w][k] = tab[w + 1][k] + mac[w][k];
            czyAkt = true;
        }
        if (k != 0 && tab[w][k - 1] + mac[w][k] < tab[w][k]) {
            tab[w][k] = tab[w][k - 1] + mac[w][k];
            czyAkt = true;
        }
        if (k != 79 && tab[w][k + 1] + mac[w][k] < tab[w][k]) {
            tab[w][k] = tab[w][k + 1] + mac[w][k];
            czyAkt = true;
        }
        return czyAkt;
    }

    public static void main(String[] args) {
        new Euler083();
    }
}
