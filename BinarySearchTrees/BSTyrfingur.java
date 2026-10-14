package BinarySearchTrees;

import java.io.IOException;

public class BSTyrfingur {

    private static Kattio io = new Kattio(System.in, System.out);

    public static void main(String[] args) {
        Runnable task = () -> {
            visit();
            io.println('!');
            io.flush();
            io.close();
        };
        new Thread(null, task, "main", 1 << 26).start();

    }

    private static void visit() {

        if (ask('<') == 1) {
            visit();
        }
        if (ask('p') == 0) {
            System.exit(0);
        }
        if (ask('>') == 1) {
            visit();
        }
        ask('^');

    }

    private static int ask(char op) {
        io.println(op);
        io.flush();
        return io.getInt();
    }

}
