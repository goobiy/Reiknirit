package Kattis;

import java.util.Scanner;

public class CreditCard {

    public static void main(String[] args) {
        int[] pay = { 500, 1000, 2000, 5000, 10000, 20000 };
        int[] get = { 500, 1000, 2000, 5250, 11000, 24000 };
        Scanner scanner = new Scanner(System.in);
        int cost = scanner.nextInt();
        for (int i = 0; i < get.length; i++) {
            if (get[i] >= cost) {
                System.out.println(pay[i]);
                break;
            }
        }
        scanner.close();
    }
}
