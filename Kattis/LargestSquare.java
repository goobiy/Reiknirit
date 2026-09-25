package Kattis;

import java.util.Scanner;

public class LargestSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int bestArea = 0;
        int bestA = 0;
        int bestB = 0;

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a * b > bestArea && a == b) {
                bestArea = a * b;
                bestA = a;
                bestB = b;

            }
        }
        scanner.close();
        System.out.println(bestA + " " + bestB);
    }
}
