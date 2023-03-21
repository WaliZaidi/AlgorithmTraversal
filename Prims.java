import java.io.IOException;

class Prims {

    public void primsGraphTraverse(Graph graph) throws IOException { //this is going to be our min heap, sort of

        textReader reader = new textReader();

        Graph minSpan = new Graph();

        minSpan.initialize(graph.getNodelist().length); //n times

        minSpan.getNodelist()[0] = new Node(0); //sets the entry point in the prims

        //this works
        for (int i = 0; i < minSpan.getNodelist().length; i++) { //for every node in the min spanning tree //n times
            if (minSpan.getNodelist()[i] != null && !minSpan.getNodelist()[i].isVisited()) {
                int minIndex = findMinimum(graph.getNodelist()[i]); //find the minimum node that's connected to it
                minSpan.addEdges(minSpan.getNodelist()[i].getData(), minIndex); //add an edge
                minSpan.getNodelist()[i].setVisited(true); //mark the node as visited so that it doesnt cause issues
            }
        }

        for (Node node : minSpan.getNodelist()) { //n times
            System.out.println("Node : " + node.getData() + " - ");
            node.printConnections();
        }

        reader.writeReadGraph(minSpan, "src/minPrims.txt");
    }

    public int findMinimum(Node node) {
        int min = 99999;
        int minIndex = -1;
        for (Node nodeNext : node.getNextNodes()) {
            if (node.getWeight() < min) {
                min = node.getWeight();
                minIndex = nodeNext.getData();
            }
        }

        return minIndex;
    }
}
