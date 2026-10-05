package Kattis;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// StdIn.readInt()
// StdIn.readString()
// StdIn.readLine()
// StdIn.isEmpty()

public class SortofSorting {

    public static void main(String[] args) {
        while (true) {
            int n = StdIn.readInt(); // reads the int n
            if (n == 0) {
                break;
            }
            String[] names = new String[n]; // List of strings, of size n

            for (int i = 0; i < n; i++) {
                names[i] = StdIn.readString(); // add the names to the list
            }
            sort(names);
            for (int i = 0; i < n; i++) {
                StdOut.println(names[i]);
            }

        }
    }

    private static void sort(String[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                } else
                    break;
            }
        }
    }

    private static boolean less(String a, String b) {

        // If the first two letters of a, compared to b's first two letters, is less,
        // then return true
        if (a.substring(0, 2).compareTo(b.substring(0, 2)) < 0) {
            return true;
        } else
            return false;

    }

    private static void exch(String[] a, int i, int j) {
        String swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}