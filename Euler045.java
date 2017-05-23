/**
 * Created by Marcin on 2015-11-27.
 */
public class Euler045 {
    int h = 143;
    int p = 165;
    int t = 285;

    long nextHex() {
        h++;
        return (long) h * (2 * h - 1);
    }

    long nextPen() {
        p++;
        return (long) p * (3 * p - 1) / 2;
    }

    long nextTri() {
        t++;
        return (long) t * (t + 1) / 2;
    }

    long zadanie() {
        long H = nextHex(), P = nextPen(), T = nextTri();
        while (H != P || P != T) {
            if (H > P) {
                if (T > P)
                    P = nextPen();
                else T = nextTri();
            } else if (T > H)
                H = nextHex();
            else T = nextTri();
        }
        return H;
    }

    public static void main(String[] args) {
        Euler045 ob = new Euler045();
        System.out.print(ob.zadanie());
    }
}
