import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BreakingBad {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        HashMap<String, Integer> suspair = new HashMap<>(); // name of a product and an id

        int n = io.getInt(); // no. of items W and J want to buy

        String[] products = new String[n];

        for (int i = 0; i < n; i++) {

            String p = io.getWord(); // name of the item they want to buy
            products[i] = p;
        }

        int m = io.getInt(); // no. of pairs of items that are sus

        for (int j = 0; j < m; j++) {
            String p1 = io.getWord();
            String p2 = io.getWord();

        }
    }
}
