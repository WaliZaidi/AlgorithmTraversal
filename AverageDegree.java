import java.util.ArrayList;

public class AverageDegree {

    public float findDegree(ArrayList<Edges> edges, Graph graph) {
        float degree = edges.size() / graph.getNodelist().length;
        System.out.println("Degree of graph is " + degree);
        return degree;
    }

}
