import java.util.Scanner;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// StdIn.readInt()
// StdIn.readString()
// StdIn.readLine()
// StdIn.isEmpty()

public class Planetaris {
    public static void main(String[] args) {

        int n = StdIn.readInt(); // no. of solar systems Atli will visit
        int a = StdIn.readInt(); // no. of ships Atli has

        int[] e = new int[n]; // the defences of each solar system total n

        for (int i = 0; i < n; i++) {
            e[i] = StdIn.readInt(); // Filling the defences (e) with ships
        }
        int[] aux = new int[n];
        sort(e, aux, 0, e.length - 1);

        int total_planets = 0;

        for (int i = 0; i < n; i++) {

            if (a - (e[i] + 1) >= 0) {
                a = a - (e[i] + 1);
                total_planets += 1;
            }
        }
        System.out.println(total_planets);
    }

    public static void merge(int[] e, int[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = e[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                e[k] = aux[j++]; // aux[j++] evaluates j's current value and then increments it, j = j + 1

            else if (j > hi)
                e[k] = aux[i++];

            else if (less(aux[j], aux[i]))
                e[k] = aux[j++];

            else
                e[k] = aux[i++];
        }

    }

    public static void sort(int[] e, int[] aux, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;

        sort(e, aux, lo, mid); // sort the first half
        sort(e, aux, mid + 1, hi); // sort the second half

        merge(e, aux, lo, mid, hi); // merge halfs
    }

    public static boolean less(int a, int b) {
        return a < b;
    }
}
