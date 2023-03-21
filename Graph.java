import java.sql.Array;
import java.util.ArrayList;

public class Graph {

    private Node[] nodelist;

    public Graph() {}

    public void initialize(int max) {
        nodelist = new Node[max];

        for (int i = 0; i < nodelist.length; i++) {
            nodelist[i] = new Node();
            nodelist[i].setData(i);
        }
    }

    public void addEdges(int node1, int node2) {
        this.nodelist[node1].getNext().add(new Node(node2));
    }

    public void removeEdges(int node1, int node2) {
        this.nodelist[node1].getNext().remove(node2);
    }

    public Graph(Node[] nodelist) {
        this.nodelist = nodelist;
    }

    public void printGraph() {
        for (int i = 0; i < nodelist.length; i++) {
            System.out.println("Node : " + nodelist[i].getData());
            nodelist[i].printConnections();
        }
    }

    public int minimumAdjacent(int nodeIndex) {
        int min = 99999;
        int minIndex = 0;
        ArrayList<Node> adjNodes = nodelist[nodeIndex].getNextNodes();
        if (adjNodes.size() != 0) { //might want to check this one chief
            for (Node node : adjNodes) {
                if (node.getWeight() <= min) {
                    min = node.getWeight();
                    minIndex = node.getData();
                }
            }
        }
        return minIndex;
    }

    public void initializeForEdges(int max) {
        nodelist = new Node[max];
        for (int i = 0; i < nodelist.length; i++) {
            nodelist[i] = new Node();
        }
    }

    public boolean foundInGraph(Node node) {
        for (int i = 0; i < nodelist.length; i++) {
            if (nodelist[i].getNextNodes().contains(node)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public int minimunAdjacentUnweighted(int nodeIndex) {
        ArrayList<Node> adjNodes = nodelist[nodeIndex].getNextNodes();

        return adjNodes.get(0).getData();
    }

    public void setWeight(int node) {
        nodelist[node].setWeight(1); //for unweighted, if there is a weight then we can simply add in some extra things in the reader as well as here
    }

    public Node[] getNodelist() {
        return nodelist;
    }

    public void setNodelist(Node[] nodelist) {
        this.nodelist = nodelist;
    }
}
