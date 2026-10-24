
import java.util.ArrayList;
import java.util.List;

public class InterplanetaryTunnels {
    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt(); // no. of planets connected to the hyper tunnel system
        int m = io.getInt(); // no. of hyper tunnels

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int pa = io.getInt(); // planet A where Alice starts at
        int pb = io.getInt(); // planet B where Bob starts at

        for (int i = 0; i < m; i++) { // establishing which planets are connected with a hyper tunnel
            int p1 = io.getInt();
            int p2 = io.getInt();

            adjList.get(p1).add(p2); // adding p2 to the inner list of p1

        }

    }
}
