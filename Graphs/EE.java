
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import edu.princeton.cs.algs4.Graph;

public class EE {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt(); // No. of vertacies
        int m = io.getInt(); // No. of edges

        Graph net = new Graph(n);
        int[] dist = new int[n];

        for (int i = 0; i < m; i++) {
            int e1 = io.getInt();
            int e2 = io.getInt();

            net.addEdge(e1 - 1, e2 - 1); // Adding the connections between edges

        }

        int girth = Integer.MAX_VALUE;
        for (int source = 0; source < n; source++) {
            bfs(net, source, dist);

            for (int u = 0; u < n; u++) {
                if (dist[u] == -1) { // Other component
                    continue;
                }
                int even_neighbours = 0;
                for (int nb : net.adj(u)) {
                    if (dist[nb] == -1) {
                        continue;
                    }
                    if (dist[nb] == dist[u]) {
                        girth = Math.min(girth, 2 * dist[u] + 1); // Odd candidate
                    }
                    if (dist[nb] == dist[u] - 1) {
                        even_neighbours++;
                    }
                }
                if (even_neighbours >= 2) {
                    girth = Math.min(girth, 2 * dist[u]); // Even candidate
                }
            }
        }
        io.println(girth);
        io.flush();

    }

    private static void bfs(Graph net, int start, int[] dist) {
        Deque<Integer> queue = new ArrayDeque<>();
        Arrays.fill(dist, -1);
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) { // BFS implementation to find the shortest path
            int current = queue.poll();

            for (int neighbour : net.adj(current)) {
                if (dist[neighbour] == -1) {
                    dist[neighbour] = dist[current] + 1;
                    queue.add(neighbour);
                }
            }
        }

    }
}