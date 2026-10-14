
package Kattis;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;

public class ContinuousMedian {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int testcases = io.getInt();

        for (int i = 0; i < testcases; i++) {
            int n = io.getInt(); // how many ints in this testcase

            MaxPQ<Integer> lo = new MaxPQ<Integer>(); // lower half, largest on top
            MinPQ<Integer> hi = new MinPQ<Integer>(); // upper half, smallest on top

            long medianSum = 0;

            for (int j = 0; j < n; j++) {
                int val = io.getInt();

                if (lo.isEmpty() || val <= lo.max()) { // every elem of lo <= every elem in hi
                    lo.insert(val);
                } else {
                    hi.insert(val);
                }

                // rebalance the heap
                if (lo.size() > hi.size() + 1) {
                    hi.insert(lo.delMax());
                } else if (hi.size() > lo.size()) {
                    lo.insert(hi.delMin());
                }

                int median;
                if (lo.size() > hi.size()) {
                    median = lo.max();
                } else {
                    median = (int) (((long) lo.max() + hi.min()) / 2);
                }
                medianSum += median;
            }

            io.println(medianSum);
        }
        io.close();
    }
}