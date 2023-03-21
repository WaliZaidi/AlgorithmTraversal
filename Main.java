import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        textReader reader = new textReader();

        Graph graph = new Graph();
        Prims prims = new Prims();
        Kruskals kruskals = new Kruskals();
        AverageDegree degree = new AverageDegree();
        long start = 0;
        long end = 0;
        String executionFile = "src/ExecutionTimes.txt";

        start = System.nanoTime();
        graph = reader.readingFile(graph);
        end = System.nanoTime();

        System.out.println("Execution time is : " + (end-start));

        reader.writeExecutionTime((end-start), executionFile);

        graph.printGraph();

        System.out.println();

        ArrayList<Edges> edgesArrayList = new ArrayList<>();

        edgesArrayList = reader.readingFileWithEdge(edgesArrayList);

        start = System.nanoTime();
        kruskals.kruskalsMST(edgesArrayList, graph);
        end = System.nanoTime();

        reader.writeExecutionTime((end-start), executionFile);

        System.out.println();

        start = System.nanoTime();
        prims.primsGraphTraverse(graph);
        end = System.nanoTime();

        reader.writeExecutionTime((end-start), executionFile);

        reader.writeReadGraph(graph, "src/graphRead.txt");

        System.out.println();

        float GraphDeg = degree.findDegree(edgesArrayList, graph);

        reader.writeAverageDegree(GraphDeg, "src/AverageDegree.txt");

    }
}
