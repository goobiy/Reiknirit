import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BreakingBad {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        HashMap<String, Integer> items = new HashMap<>(); // name of a product and an id
        List<List<Integer>> adjList = new ArrayList<>();

        int n = io.getInt(); // no. of items W and J want to buy

        String[] products = new String[n]; // To get the ID's of the products

        for (int i = 0; i < n; i++) {

            String p = io.getWord(); // name of the item they want to buy
            products[i] = p;
            items.put(p, i);
        }

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>()); // Filling up the sus list
        }

        int m = io.getInt(); // no. of pairs of items that are sus

        for (int j = 0; j < m; j++) { // The sus declarations
            String p1 = io.getWord();
            String p2 = io.getWord();

            int a = items.get(p1); // What ID is the item
            int b = items.get(p2);

            adjList.get(a).add(b); // Now there is a edge between the sus pair
            adjList.get(b).add(a);
        }
    }
}
