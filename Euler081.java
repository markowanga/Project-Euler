import java.io.*;

/**
 * Created by Marcin on 2016-02-25.
 */
public class Euler081 {
    int[][] mac;

    Euler081() {
        mac = new int[80][80];
        odczyt();
        System.out.print(minimalnaSuma());
    }

    void odczyt() {
        try {
            StreamTokenizer tok = new StreamTokenizer(new FileReader("matrix81.txt"));
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
        pom[0][0] = mac[0][0];
        for (int a = 1; a < 80; a++) {
            pom[0][a] = mac[0][a] + pom[0][a - 1];
            pom[a][0] = mac[a][0] + pom[a - 1][0];
        }
        for (int a = 1; a < 80; a++)
            for (int b = 1; b < 80; b++)
                pom[a][b] = mac[a][b] + Math.min(pom[a - 1][b], pom[a][b - 1]);
        return pom[79][79];
    }

    public static void main(String[] args) {
        new Euler081();
    }
}
