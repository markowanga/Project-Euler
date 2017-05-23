/**
 * Created by Marcin on 2015-11-24.
 */
public class Euler024 {
    boolean[] czyDostepne;
    String liczba;

    Euler024() {
        liczba = "";
        czyDostepne = new boolean[10];
        for (int a = 0; a < 10; a++)
            czyDostepne[a] = true;
    }

    int silnia(int a) {
        if (a == 0)
            return 1;
        else return a * silnia(a - 1);
    }

    void tworzLiczbe(int szukana, int stopien, int dotychczas) {
        int licznik = 1;
        while (!(dotychczas <= szukana && szukana < dotychczas + silnia(stopien))) {
            licznik++;
            dotychczas += silnia(stopien);
        }
        for (int a = 0; a < 10; a++)
            if (czyDostepne[a]) {
                licznik--;
                if (licznik == 0) {
                    liczba += (char) (a + 48);
                    czyDostepne[a] = false;
                    break;
                }
            }
        if (stopien != 0)
            tworzLiczbe(szukana, stopien - 1, dotychczas);
    }

    public static void main(String[] args) {
        Euler024 ob = new Euler024();
        ob.tworzLiczbe(1000000, 9, 1);
        System.out.print(ob.liczba);
    }
}
