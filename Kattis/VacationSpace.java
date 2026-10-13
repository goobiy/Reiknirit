package Kattis;

import Kattis.House;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// StdIn.readInt()
// StdIn.readString()
// StdIn.readLine()
// StdIn.isEmpty()

public class VacationSpace {

    public static void main(String[] args) {
        int n = StdIn.readInt(); // How many houses

        House[] houses = new House[n];

        for (int i = 0; i < n; i++) {
            int pos = StdIn.readInt();
            houses[i] = new House(pos, i + 1); // Filling up houses with the House obj that inc their pos and idx
        }

        Arrays.sort(houses);

        int min = 0;
        for (int i = 0; i < houses.length - 1; i++) {
            if (i > 0) {
                int leftgap = houses[i].pos - houses[i - 1].pos;
                int rightgap = houses[i + 1].pos - houses[i].pos;
                int lessergap = Math.min(leftgap, rightgap);
                if (lessergap < min) {
                    min = lessergap;
                }
            }
        }

    }
}