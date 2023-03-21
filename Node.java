import java.util.ArrayList;

public class Node {

    private int data;
    private int weight;
    private boolean visited;
    private ArrayList<Node> nextNodes;

    public Node() {
        data = 0;
        weight = 1; //this is where we set the weights, usually we can do this in textReader, but as it happens we have unweighted, so all can be done as 999999, to emulate infinity
        visited = false; //just to help with the prims and such
        nextNodes = new ArrayList<>();
    }

    public Node(int data) {
        this.data = data;
        nextNodes = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ArrayList getNext() {
        return nextNodes;
    }

    public void printConnections() {
        System.out.print("Connected to ");
        for (Node node : nextNodes) {
            System.out.print(node.getData() + ", ");
        }
        System.out.println();
    }

    public void setNext(Node next) {
        nextNodes.add(next);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArrayList<Node> getNextNodes() {
        return nextNodes;
    }

    public void setNextNodes(ArrayList<Node> nextNodes) {
        this.nextNodes = nextNodes;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
