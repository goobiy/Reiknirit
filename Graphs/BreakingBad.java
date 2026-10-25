import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
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

        int[] colour = new int[n];
        Arrays.fill(colour, -1);
        boolean possible = true;

        for (int start = 0; start < n && possible; start++) { // visiting every vertex
            if (colour[start] != -1) {
                continue;
            }

            colour[start] = 0;
            Deque<Integer> queue = new ArrayDeque<>(); // for each vertex we visit all its connected verticies
            queue.add(start);

            while (!queue.isEmpty()) { // BFS implementation
                int current = queue.poll();

                for (int neighbour : adjList.get(current)) { // colours are 0 and 1
                    if (colour[neighbour] == -1) { // If not visited
                        colour[neighbour] = 1 - colour[current]; // Either 1-0 or 1-1 so it won't become the same color
                                                                 // as curr
                        queue.add(neighbour);
                    } else if (colour[neighbour] == colour[current]) {
                        possible = false;
                    }
                }
                if (!possible) {
                    io.println("impossible");
                    io.flush();
                    return;
                }

            }
        }
        StringBuilder walter = new StringBuilder();
        StringBuilder jesse = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (colour[i] == 0) {
                if (walter.length() > 0) {
                    walter.append(" ");
                }
                walter.append(products[i]);
            } else {
                if (jesse.length() > 0) {
                    jesse.append(" ");
                }
                jesse.append(products[i]);
            }
        }
        io.println(walter.toString());
        io.println(jesse.toString());
        io.flush();
    }
}
