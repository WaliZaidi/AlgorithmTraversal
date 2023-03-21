import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class textReader {

    public Graph readingFile(Graph graph) {
        File file = new File("src/Slashdot0811.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            int max = 0;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split("\n");

                for (int i = 0; i < strings.length; i++) {
                    String[] links = strings[i].split("\t");

                    if (Integer.parseInt(links[0]) > max) {
                        max = Integer.parseInt(links[0]);
                    }
                    if (Integer.parseInt(links[1]) > max) {
                        max = Integer.parseInt(links[1]);
                    }
                }
            }

            max = max + 1;

            //we can now create the graph

            graph.initialize(max);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader brf = new BufferedReader(new FileReader(file))) {

            String line2;

            while ((line2 = brf.readLine()) != null) {
                String[] strings = line2.split("\n");

                for (String string : strings) {
                    String[] links = string.split("\t");
//                    System.out.println(links[0] + " " + links[1]);
                    graph.addEdges(Integer.parseInt(links[0]), Integer.parseInt(links[1]));
                }
            }

        } catch (Exception ef) {
            ef.printStackTrace();
        }

//        graph.printGraph();
        return graph;
    }

    public ArrayList<Edges> readingFileWithEdge(ArrayList<Edges> edges) {
        File file = new File("src/Slashdot0811.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            int max = 0;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split("\n");

                for (int i = 0; i < strings.length; i++) {
                    String[] links = strings[i].split("\t");

                    if (Integer.parseInt(links[0]) > max) {
                        max = Integer.parseInt(links[0]);
                    }
                    if (Integer.parseInt(links[1]) > max) {
                        max = Integer.parseInt(links[1]);
                    }
                }
            }

            max = max + 1;

            //we can now create the graph

            edges = new ArrayList<>(max);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader brf = new BufferedReader(new FileReader(file))) {

            String line2;

            while ((line2 = brf.readLine()) != null) {
                String[] strings = line2.split("\n");

                for (String string : strings) {
                    String[] links = string.split("\t");
//                    System.out.println(links[0] + " " + links[1]);
                    edges.add(new Edges(Integer.parseInt(links[0]), Integer.parseInt(links[1])));
                }
            }

        } catch (Exception ef) {
            ef.printStackTrace();
        }

//        for (Edges edge : edges) {
//            System.out.println("Edge 1 : " + edge.getFirst() + " | Edge 2 : " + edge.getSecond());
//        }
        return edges;
    }

    public void writeReadGraph(Graph graph, String filename) throws IOException{
        createFile(filename);
        try {
            FileWriter writer = new FileWriter(filename);
            for (Node node : graph.getNodelist()) {
                writer.write("Node " + Integer.toString(node.getData()) + " -- ");
                for (Node node1 : node.getNextNodes()) {
                    writer.append(Integer.toString(node1.getData()) + ", ");
                }
                writer.write("\n");
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeAverageDegree(float graphDeg, String filename) throws IOException {
        createFile(filename);
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("The average degree of the graph is : " + Float.toString(graphDeg));

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeExecutionTime(long time, String filename) throws IOException {
        createFile(filename);
        try {
            FileWriter writer = new FileWriter(filename, true);

            writer.write("-- \n");
            writer.write("Execution time for function is : " + Long.toString(time) + " nanoseconds \n");

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createFile(String filename) throws IOException {
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
