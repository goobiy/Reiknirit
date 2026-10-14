package Kattis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LowSkillDecks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> trash = new ArrayList<>();

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String stock = scanner.nextLine();
            trash.add(stock);
        }

        int m = scanner.nextInt();
        scanner.nextLine();

        for (int j = 0; j < m; j++) {
            boolean flag = false;
            for (int k = 0; k < 6; k++) {
                String deck = scanner.nextLine();
                if (trash.contains(deck)) {
                    flag = true;
                }
            }
            if (flag) {
                System.out.println("Hæfileikalaust Drasl");
            } else {
                System.out.println("Fínn Stokkur");
            }

        }
        scanner.close();

    }
}
