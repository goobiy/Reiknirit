import edu.princeton.cs.algs4.RedBlackBST;

public class Einkathjalfarinn {
    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> timeslots = new RedBlackBST<>();

        Kattio io = new Kattio(System.in, System.out);

        int q = io.getInt();

        for (int i = 0; i < q; i++) {
            String line = io.getWord().toLowerCase();

            if (line.charAt(0) == 'a') {
                int time = io.getInt();

                if (!timeslots.contains(time)) {
                    timeslots.put(time, time);
                } else
                    continue;

            } else if (line.charAt(0) == 'd') {
                int time = io.getInt();

                if (timeslots.contains(time)) {
                    timeslots.delete(time);
                } else
                    continue;

            } else if (line.charAt(0) == 'f') {
                int time1 = io.getInt();
                int time2 = io.getInt();

                int span = time2 - time1 + 1;
                int freetime = span - timeslots.size(time1, time2);
                io.println(freetime);
                io.flush();
            }

        }
        io.close();
    }
}