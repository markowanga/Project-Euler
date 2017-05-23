import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Marcin on 2015-11-27.
 */
public class Euler054 {
    Scanner sc;
    CardKomp cardKomp = new CardKomp();
    Para p1 = new Para(), p2 = new Para();
    SortedSet<String> t1 = new TreeSet<>(new CardKomp()), t2 = new TreeSet<>(new CardKomp());

    void tworzStrumienOdczytu(String nazwa) throws IOException {
        sc = new Scanner(new FileReader(nazwa));
    }

    void odczytaj() {
        t1.clear();
        t2.clear();
        for (int a = 0; a < 5; a++)
            t1.add(sc.next());
        for (int a = 0; a < 5; a++)
            t2.add(sc.next());
    }

    boolean ifRoyalFlush(SortedSet<String> zb, Para moc) {
        String[] tab = zb.toArray(new String[zb.size()]);
        if (ifStraightFlush(zb, false, moc) && tab[0].charAt(0) == 'A') {
            zb.clear();
            moc.first = 10;
            moc.second = 1;
            return true;
        }
        return false;
    }

    boolean ifStraightFlush(SortedSet<String> zb, boolean czyUsu, Para moc) {
        if (ifStraight(zb, false, moc) && ifFlush(zb, false, moc)) {
            moc.first = 9;
            moc.second = cardKomp.ustalenieWagi(zb.first());
            if (czyUsu)
                zb.clear();
            return true;
        }
        return false;
    }

    boolean ifFourOfAKind(SortedSet<String> zb, Para moc) {
        String[] tab = zb.toArray(new String[zb.size()]);
        if (cardKomp.ustalenieWagi(tab[0]) == cardKomp.ustalenieWagi(tab[3])) {
            moc.first = 8;
            moc.second = cardKomp.ustalenieWagi(tab[2]);
            for (int a = 0; a < 4; a++)
                zb.remove(tab[a]);
            return true;
        } else if (cardKomp.ustalenieWagi(tab[1]) == cardKomp.ustalenieWagi(tab[4])) {
            moc.first = 8;
            moc.second = cardKomp.ustalenieWagi(tab[2]);
            for (int a = 1; a < 5; a++)
                zb.remove(tab[a]);
            return true;
        }
        return false;
    }

    boolean ifFullHouse(SortedSet<String> zb, Para moc) {
        String[] tab = zb.toArray(new String[zb.size()]);
        if (tab[0].charAt(0) == tab[1].charAt(0) && tab[2].charAt(0) == tab[4].charAt(0)) {
            for (int a = 0; a < 4; a++)
                zb.remove(tab[a]);
            moc.first = 7;
            moc.second = cardKomp.ustalenieWagi(tab[2]) * 100 + cardKomp.ustalenieWagi(tab[0]);
            return true;
        } else if (tab[0].charAt(0) == tab[2].charAt(0) && tab[3].charAt(0) == tab[4].charAt(0)) {
            for (int a = 1; a < 5; a++)
                zb.remove(tab[a]);
            moc.first = 7;
            moc.second = cardKomp.ustalenieWagi(tab[2]) + cardKomp.ustalenieWagi(tab[0]) * 100;
            return true;
        }
        return false;
    }

    boolean ifFlush(SortedSet<String> zb, boolean czyUsu, Para moc) {
        String[] tab = zb.toArray(new String[zb.size()]);
        for (int a = 1; a < 5; a++)
            if (tab[0].charAt(1) != tab[a].charAt(1))
                return false;
        moc.first = 6;
        moc.second = cardKomp.ustalenieWagi(tab[0]);
        if (czyUsu)
            zb.clear();
        return true;
    }

    boolean ifStraight(SortedSet<String> zb, boolean czyUsu, Para moc) {
        String[] tab = zb.toArray(new String[zb.size()]);
        for (int a = 1; a < 5; a++)
            if (cardKomp.ustalenieWagi(tab[0]) - a != cardKomp.ustalenieWagi(tab[a]))
                return false;
        if (czyUsu)
            zb.clear();
        moc.first = 5;
        moc.second = cardKomp.ustalenieWagi(tab[0]);
        return true;
    }

    boolean ifThreeOfAKind(SortedSet<String> zb, Para moc) {
        String[] tab = zb.toArray(new String[zb.size()]);
        for (int a = 0; a < 3; a++)
            if (tab[a].charAt(0) == tab[a + 2].charAt(0)) {
                for (int b = 0; b < 3; b++)
                    zb.remove(tab[b + a]);
                moc.first = 4;
                moc.second = cardKomp.ustalenieWagi(tab[a]);
                return true;
            }
        return false;
    }

    boolean ifTwoPairs(SortedSet<String> zb, Para moc) {
        String[] tab = zb.toArray(new String[zb.size()]);
        String[] t = zb.toArray(new String[zb.size()]);
        SortedSet<Integer> zz = new TreeSet<>();
        int m1 = 0, m2 = 0;
        for (int a = 0; a < 4; a++)
            if (tab[a].charAt(0) == tab[a + 1].charAt(0)) {
                zz.add(a);
                zz.add(a + 1);
                m1 = cardKomp.ustalenieWagi(tab[a]);
                tab[a] = "pp";
                tab[a + 1] = "kk";
                break;
            }
        for (int a = 0; a < 4; a++)
            if (tab[a].charAt(0) == tab[a + 1].charAt(0)) {
                zz.add(a);
                zz.add(a + 1);
                m2 = cardKomp.ustalenieWagi(tab[a]);
                for (Integer p : zz)
                    zb.remove(t[p]);
                if (m2 > m1)
                    moc.second = m2 * 100 + m1;
                else
                    moc.second = m1 * 100 + m2;
                moc.first = 3;
                return true;
            }
        return false;
    }

    boolean ifPair(SortedSet<String> zb, Para moc) {
        String[] tab = zb.toArray(new String[zb.size()]);
        for (int a = 0; a < 4; a++)
            if (tab[a].charAt(0) == tab[a + 1].charAt(0)) {
                for (int b = 0; b < 2; b++)
                    zb.remove(tab[a + b]);
                moc.first = 2;
                moc.second = cardKomp.ustalenieWagi(tab[a]);
                return true;
            }
        return false;
    }

    void mocRozdania(SortedSet<String> zb, Para moc) {
        if (ifRoyalFlush(zb, moc)) return;
        if (ifStraightFlush(zb, true, moc)) return;
        if (ifFourOfAKind(zb, moc)) return;
        if (ifFullHouse(zb, moc)) return;
        if (ifFlush(zb, true, moc)) return;
        if (ifStraight(zb, true, moc)) return;
        if (ifThreeOfAKind(zb, moc)) return;
        if (ifTwoPairs(zb, moc)) return;
        if (ifPair(zb, moc)) return;
        moc.first = 1;
        moc.second = 1;
        return;
    }

    boolean czyWygralPl1() {
        mocRozdania(t1, p1);
        mocRozdania(t2, p2);
        if (!p1.equals(p2))
            return p1.first > p2.first || (p1.first == p2.first && p1.second > p2.second);
        else { // szukamy najmocniejszej karty
            while (!t1.isEmpty() && !t2.isEmpty()) {
                if (cardKomp.ustalenieWagi(t1.first()) != cardKomp.ustalenieWagi(t2.first()))
                    return cardKomp.ustalenieWagi(t1.first()) > cardKomp.ustalenieWagi(t2.first());
                t1.remove(t1.first());
                t2.remove(t2.first());
            }
        }
        return false;
    }

    int zadanie() throws IOException {
        tworzStrumienOdczytu("poker.txt");
        int licznik = 0;
        for (int a = 0; a < 1000; a++) {
            odczytaj();
            if (czyWygralPl1())
                licznik++;
        }
        return licznik;
    }

    public class CardKomp implements Comparator<String> {
        int ustalenieWagi(String k) {
            int lk = 0;
            if ((int) k.charAt(0) >= 50 && (int) k.charAt(0) < 58)
                lk = (int) k.charAt(0) - 48;
            else if (k.charAt(0) == 'T')
                lk = 10;
            else if (k.charAt(0) == 'J')
                lk = 11;
            else if (k.charAt(0) == 'Q')
                lk = 12;
            else if (k.charAt(0) == 'K')
                lk = 13;
            else if (k.charAt(0) == 'A')
                lk = 14;
            if (lk == 0)
                System.out.println("Error: " + k);
            return lk;
        }

        public int compare(String k1, String k2) {
            if (k1.charAt(0) != k2.charAt(0))
                return ustalenieWagi(k1) > ustalenieWagi(k2) ? -1 : 1;
            else return k1.compareTo(k2);
        }
    }

    public class Para {
        int first;
        int second;

        Para() {
        }

        Para(int a, int b) {
            first = a;
            second = b;
        }

        void wys() {
            System.out.print("(" + first + ", " + second + ") ");
        }

        boolean equals(Para p) {
            return p.first == first && p.second == second;
        }
    }


    public static void main(String args[]) throws IOException {
        Euler054 ob = new Euler054();
        System.out.print(ob.zadanie());
    }
}