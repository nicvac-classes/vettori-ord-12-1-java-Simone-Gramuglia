import java.util.Scanner;
import java.util.Random;

class Esercizio {
    private static Random random = new Random();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n, i, conf;

        System.out.println("Quanti numeri generare?");
        n = in.nextInt();
        int[] r = new int[n], v = new int[n];

        i = 0;
        while (i < n) {
            r[i] = random.nextInt(n * 10);
            System.out.println("Numero generato " + i + ": " + r[i]);
            i = i + 1;
        }
        copiaVettore(v, n, r);

        // ordinamento non ottimizzato
        conf = ordNonOtt(r, n);
        System.out.println("Ordinamento non ottimizzato (numero di confronti = " + conf + "):");
        i = 0;
        while (i < n) {
            System.out.println(r[i]);
            i = i + 1;
        }
        copiaVettore(r, n, v);

        // ordinamento ottimizzato sul numero di passi
        conf = ordOttPassi(r, n);
        System.out.println("Ordinamento ottimizzato sul numero di passi (numero di confronti = " + conf + "):");
        i = 0;
        while (i < n) {
            System.out.println(r[i]);
            i = i + 1;
        }
        copiaVettore(r, n, v);

        // ordinamento ottimizzato sulla sentinella di scambio
        conf = ordSentinella(r, n);
        System.out.println("Ordinamento ottmizzato sulla sentinella di scambio (numero di confronti = " + conf + "):");
        i = 0;
        while (i < n) {
            System.out.println(r[i]);
            i = i + 1;
        }
    }
    
    public static void copiaVettore(int[] v1, int n, int[] v2) {
        int i;

        i = 0;
        while (i <= n - 1) {
            v1[i] = v2[i];
            i = i + 1;
        }
    }
    
    public static int ordNonOtt(int[] r, int n) {
        int i, t, j, conf;

        conf = 1;
        i = 0;
        while (i <= n - 1) {
            j = 0;
            while (j <= n - 2) {
                conf = conf + 1;
                if (r[j] > r[j + 1]) {
                    t = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = t;
                }
                j = j + 1;
            }
            i = i + 1;
        }
        
        return conf;
    }
    
    public static int ordOttPassi(int[] r, int n) {
        int i, t, j, conf;

        conf = 0;
        i = 0;
        while (i <= n - 1) {
            j = 0;
            while (j <= n - 2 - i) {
                conf = conf + 1;
                if (r[j] > r[j + 1]) {
                    t = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = t;
                }
                j = j + 1;
            }
            i = i + 1;
        }
        
        return conf;
    }
    
    public static int ordSentinella(int[] r, int n) {
        int i, t, j, conf;

        conf = 0;
        boolean scambio;

        scambio = true;
        i = 0;
        while (i <= n - 1 && scambio == true) {
            scambio = false;
            j = 0;
            while (j <= n - 2) {
                conf = conf + 1;
                if (r[j] > r[j + 1]) {
                    t = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = t;
                    scambio = true;
                }
                j = j + 1;
            }
            i = i + 1;
        }
        
        return conf;
    }
}
