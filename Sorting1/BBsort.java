package Kattis;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

// StdIn.readInt()
// StdIn.readString()
// StdIn.readLine()
// StdIn.isEmpty()

public class BBsort {

    public static void main(String[] args) {
        int n = StdIn.readInt(); // n Bubbles in a row
        int k = StdIn.readInt(); // k many comparisons at a time

        int[] bubbles = new int[n];

        for (int i = 0; i < n; i++) {
            bubbles[i] = StdIn.readInt(); // Filling the bubbles list with i many ints
        }

        int[] goal = Arrays.copyOf(bubbles, n);
        Arrays.sort(goal);

        int hours = 0;
        while (true) {
            if (Arrays.equals(bubbles, goal)) {
                break;
            }
            for (int i = 0; i + k - 1 <= n - 1; i++) {

                Arrays.sort(bubbles, i, i + k);

            }
            hours += 1;
        }
        System.out.println(hours);
    }
}
