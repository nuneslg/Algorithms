package graphs.algorithms;

public record Triple(Integer predecessor, Integer vertex, Integer distance) implements Comparable<Triple> {
    @Override
    public int compareTo(Triple o) {
        return this.distance.compareTo(o.distance);
    }
}
