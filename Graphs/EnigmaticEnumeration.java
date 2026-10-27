
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import edu.princeton.cs.algs4.Graph;

public class EnigmaticEnumeration {

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

        long total = 0;
        int k = girth / 2;
        boolean odd = girth % 2 == 1;

        for (int start = 0; start < n; start++) {
            bfs(net, start, dist);

            for (int u = 0; u < n; u++) {
                if (dist[u] != k) {
                    continue;
                }
                if (odd) {
                    for (int nb : net.adj(u)) {
                        if (dist[nb] == k && u < nb) {
                            total++;
                        }
                    }
                } else {
                    long p = 0;
                    for (int nb : net.adj(u)) {
                        if (dist[nb] == k - 1) {
                            p++;
                        }
                    }
                    total += p * (p - 1) / 2;
                }
            }
        }

        io.println(total / girth);
        io.close();
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