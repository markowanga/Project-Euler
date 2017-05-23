import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 * Created by Marcin on 2016-02-25.
 */
public class Euler082 {
    int[][] mac;

    Euler082() {
        mac = new int[80][80];
        odczyt();
        System.out.print(minimalnaSuma());
    }

    void odczyt() {
        try {
            StreamTokenizer tok = new StreamTokenizer(new FileReader("matrix82.txt"));
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
        for (int a = 0; a < 80; a++)
            pom[a][0] = mac[a][0];
        for (int a = 1; a < 79; a++) {
            // normlalne zaktualizowanie w wierszu
            for (int b = 0; b < 80; b++)
                pom[b][a] = pom[b][a - 1] + mac[b][a];

            // szukanie przez sąsiednie wiersze
            boolean czyByloPrzes = true;
            while (czyByloPrzes) {
                czyByloPrzes = false;
                for (int b = 1; b < 80; b++)
                    if (pom[b][a] > pom[b - 1][a] && pom[b][a] > pom[b - 1][a] + mac[b][a]) {
                        czyByloPrzes = true;
                        pom[b][a] = pom[b - 1][a] + mac[b][a];
                    }

                for (int b = 78; b >= 0; b--)
                    if (pom[b][a] > pom[b + 1][a] && pom[b][a] > pom[b + 1][a] + mac[b][a]) {
                        czyByloPrzes = true;
                        pom[b][a] = pom[b + 1][a] + mac[b][a];
                    }
            }
        }
        // zaktuyalizowanie ostatniej kolumny
        for (int a = 0; a < 80; a++)
            pom[a][79] = mac[a][79] + pom[a][78];

        int min = pom[0][79];
        for (int a = 1; a < 80; a++)
            min = Math.min(min, pom[a][79]);
        return min;
    }

    public static void main(String[] args) {
        new Euler082();
    }
}
