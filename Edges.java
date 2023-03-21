public class Edges {

    private int first;
    private int second;
    private int weight = 1;

    public Edges() {
    }

    public Edges(int first, int second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    public Edges(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
