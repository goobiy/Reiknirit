package Kattis;

import java.util.Scanner;

public class LargestSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int max = 0;

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a*b > max){
                max = a, b;
            }
        }
        System.out.println(max);
    }
}
