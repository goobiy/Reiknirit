package Kattis;

public class House implements Comparable<House> {

    public int pos;
    public int idx;

    public House(int pos, int idx) {
        this.pos = pos;
        this.idx = idx;
    }

    public int compareTo(House other) {
        return Integer.compare(this.pos, other.pos);
    }
}