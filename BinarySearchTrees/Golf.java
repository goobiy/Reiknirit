import edu.princeton.cs.algs4.RedBlackBST;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Golf {

    static class Pair implements Comparable<Pair> {
        long score;
        String name;

        Pair(long score, String name) {
            this.score = score;
            this.name = name;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.score != other.score) {
                return Long.compare(this.score, other.score);
            }
            return this.name.compareTo(other.name);
        }
    }

    public static void main(String[] args) {
        HashMap<String, Long> players = new HashMap<>(); // Player and score
        RedBlackBST<Pair, Integer> scores = new RedBlackBST<>(); // tuple with (score, name) and value

        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt(); // No. of participants
        int q = io.getInt(); // No. of queries

        for (int i = 0; i < n; i++) {
            String player = io.getWord();

            Pair tuple = new Pair(0, player);

            players.put(player, 0L);
            scores.put(tuple, 0);
        }

        for (int i = 0; i < q; i++) {

            String line = io.getWord();

            if (line.charAt(0) == '!') {
                int k = io.getInt();

                for (int j = 0; j < k; j++) {

                    String name = io.getWord(); // name of the player
                    long score = io.getLong(); // their score on the hole

                    long oldScore = players.get(name);
                    scores.delete(new Pair(oldScore, name)); // delete the old score

                    long newscore = oldScore + score;
                    Pair tuple = new Pair(newscore, name);

                    players.put(name, newscore);
                    scores.put(tuple, 0);
                }

            } else if (line.charAt(0) == '?') {
                String name = io.getWord();
                long score = players.get(name);

                int temp = scores.rank(new Pair(score, "")); // temp so the same scores dont count again

                // int rank = scores.rank(new Pair(score, name));

                io.println(temp + 1 + " " + score);
                io.flush();
            }
        }
        io.close();

    }
}