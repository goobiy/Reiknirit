package Kattis;

import java.util.Scanner;

public class Toggi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long sec = scanner.nextLong();

        long high = 1;

        // Doubling until it's too much
        while (time(high) <= sec) {
            high = high * 2;
        }
        long low = high / 2;
        // Cutting the num down by half
        while (high - low > 1) {
            long mid = low + (high - low) / 2;

            if (time(mid) <= sec) {
                low = mid;
            } else {
                high = mid;
            }
        }
        scanner.close();
        System.out.println(low);

    }

    static double time(long n) {
        // The time formula
        double result = n * Math.log10(n);
        result = result / 1000000.0; // 10^6
        return result;
    }
}
