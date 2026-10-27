
import edu.princeton.cs.algs4.Graph;

public class EnigmaticEnumeration {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt(); // No. of vertacies
        int m = io.getInt(); // No. of edges

        Graph net = new Graph(n);

        for (int i = 0; i < m; i++) {
            int e1 = io.getInt();
            int e2 = io.getInt();

            net.addEdge(e1, e2); // Adding the connections between edges
            ;
        }

    }
}