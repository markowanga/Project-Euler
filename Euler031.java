/**
 * Created by Marcin on 2015-11-24.
 */
public class Euler031 {
    int[] tab = {1, 2, 5, 10, 20, 50, 100, 200};
    int licznik = 0;

    void nas(int dotychczas, int maxInd) {
        for (int a = 0; a <= maxInd; a++) {
            if (dotychczas + tab[a] == 200)
                licznik++;
            else if (dotychczas + tab[a] < 200)
                nas(dotychczas + tab[a], a);
        }
    }

    public static void main(String[] args) {
        Euler031 ob = new Euler031();
        ob.nas(0, 7);
        System.out.print(ob.licznik);
    }
}
