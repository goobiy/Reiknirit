
import java.util.PriorityQueue;

public class BankClosing {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt(); // customers
        int k = io.getInt(); // queues

        PriorityQueue<Customer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));

        for (int i = 0; i < k; i++) {
            Customer customer = new Customer(io.getInt(), i + 1);
            minHeap.add(customer);
        }

        for (int i = 0; i < n; i++) {
            Customer longest = minHeap.poll();
            int longestIdx = longest.idx;

            io.println(longestIdx);
            io.flush();
            String judge = io.getWord();

            if (!judge.equals("DONE")) {
                int time = Integer.parseInt(judge);
                Customer customer = new Customer(time, longestIdx);
                minHeap.add(customer);
            }
        }
        io.println("DONE");
        io.flush();
    }

    static class Customer {
        int time;
        int idx;

        Customer(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }
    }
}
