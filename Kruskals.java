import java.io.IOException;
import java.util.ArrayList;

public class Kruskals {

    public void kruskalsMST(ArrayList<Edges> edgesArrayList, Graph graph) throws IOException {

        textReader reader = new textReader();

        Graph mst = new Graph(); //mst graph store

        mst.initializeForEdges(graph.getNodelist().length); // create nodes in the graph, for the number of edges

        for (int i = 0; i < graph.getNodelist().length; i++) { //for every node in the og graph
//            System.out.println(graph.getNodelist()[i].getData()); //check what data is being given here (its unique)
            if (edgesArrayList.get(i).getFirst() != graph.getNodelist()[i].getData()) { //does the first index match?
//                System.out.println(edgesArrayList.get(i).getFirst()); //this is basically the edge connections for all nodes
//                System.out.println(edgesArrayList.get(i).getSecond()); //then what the frik is this? the other edge
                mst.getNodelist()[i] = new Node(graph.getNodelist()[i].getData());//might this be the problem? we store the edge connections
//                System.out.println(mst.getNodelist()[i].getData());
//                for (int j = 0; j < graph.getNodelist().length; j++) { //changing this just to see what happens
                    if (graph.getNodelist()[i].getData() != edgesArrayList.get(i).getFirst()) {
                        if (!graph.getNodelist()[i].getNextNodes().contains(edgesArrayList.get(i).getSecond())) {
//                        mst.getNodelist()[i] = new Node(edgesArrayList.get(i).getFirst());
                            mst.addEdges(edgesArrayList.get(i).getFirst(), edgesArrayList.get(i).getSecond());
//                            break; //also comment this out
                        }
                    }
//                }
            }
        }

        reader.writeReadGraph(mst, "src/minKruskal.txt");
        mst.printGraph();

        //works ^^
//        for (int i = 0; (i < edgesArrayList.size()); i++) { //for every edge in the edge array list
//
//
//
//            //amke syre tht only the first is chosen, by checking too see if its there, and only moving forward when its there, if it doesnt exist then continue
//
//
//
//
////            graph.getNodelist()[i] = new Node(edgesArrayList.get(i).getFirst());
////            graph.getNodelist()[i + 1] = new Node(edgesArrayList.get(i).getSecond());
////
////            graph.getNodelist()[edgesArrayList.get(i).getFirst()] = new Node(edgesArrayList.get(i).getFirst());
////            for (Node node : graph.getNodelist()) {
////                if (/*edgesArrayList.get(i).getSecond() !=*/ !node.getNextNodes().contains(edgesArrayList.get(i).getSecond())) { //essentially checking to make it so that the first edge of a node is taken, if that makes a loop, the second, and so on
////                    graph.addEdges(edgesArrayList.get(i).getFirst(), edgesArrayList.get(i).getSecond());
////                    break;
////                }
////            }
//
//
//
////            boolean match = graph.foundInGraph(new Node(edgesArrayList.get(i).getSecond()));
////
////            System.out.println(match);
////
////            boolean loopFlag = false;
////
////            for (Node node : graph.getNodelist()) {
////                if (edgesArrayList.get(i).getSecond() == node.getData() || node.isVisited()) { //so far, there is a problem that the loops arent being detected
////                    System.out.println("Loop detected");
////                    loopFlag = true;
////                }
////                if (!loopFlag) {
////                    graph.addEdges(edgesArrayList.get(i).getFirst(), edgesArrayList.get(i).getSecond()); //make the connection b/w two nodes
////                    graph.getNodelist()[edgesArrayList.get(i).getFirst()].setVisited(true); //graph node [edge of i's first connection
////                    graph.getNodelist()[edgesArrayList.get(i).getSecond()].setVisited(true);
////                }
////            }
//
//
//
////            Edges edge = edgesArrayList.get(i); //make an object that reflects that specifc edge
////            if (edge.getFirst() != edge.getSecond()) { // make sure that the first edge and second edge are not equal
////                if (graph.getNodelist()[i].getData() != edge.getSecond()) { //make sure that data we're getting is not equal to second edge
////                    graph.addEdges(edge.getFirst(), edge.getSecond()); //add the edge
////                    System.out.println(edge.getFirst() + " - " + edge.getSecond()); //print out the thingsy
////                }
////            }
//        }
//
//        mst.printGraph();
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
////        graph.printGraph();
//
////        System.out.println(cost);
    }

}
