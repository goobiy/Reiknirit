
import java.util.LinkedList;

public class WeightedQuickFind {

    private int[] id;
    private int[] size;
    private LinkedList<Integer>[] members;

    @SuppressWarnings("unchecked")
    public WeightedQuickFind(int N) {
        id = new int[N];
        size = new int[N];
        members = (LinkedList<Integer>[]) new LinkedList[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
            members[i] = new LinkedList<>();
            members[i].add(i);
        }
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public int size(int rootId) {
        return size[rootId];
    }

    public LinkedList<Integer> members(int rootId) {
        return members[rootId];
    }

    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];

        if (pId == qId)
            return;

        int smaller, bigger;

        if (size[pId] < size[qId]) {
            smaller = pId;
            bigger = qId;
        } else {
            smaller = qId;
            bigger = pId;
        }

        for (int x : members[smaller]) {
            id[x] = bigger;

        }
        members[bigger].addAll(members(smaller));
        size[bigger] = size[smaller] + size[bigger];

        size[smaller] = 0;
        members[smaller].clear();
    }

    public static void main(String[] args) {
        WeightedQuickFind uf = new WeightedQuickFind(6);
        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(4, 5);
        uf.union(0, 2);
        uf.union(0, 4);
        System.out.println(uf.connected(1, 5)); // should print true
        System.out.println(uf.size(uf.find(0))); // should print 6
    }
}
