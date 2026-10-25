import java.util.ArrayList;
import java.util.List;

public class BreakingBad {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        List<List<Integer>> adjList = new ArrayList<>();

        int n = io.getInt(); // no. of items W and J want to buy

        for (int i = 0; i < n; i++) { // Filling the adjList with a list in each index
            adjList.add(new ArrayList<>());

            io.getWord(); // name of the item they want to buy

        }

    }
}
