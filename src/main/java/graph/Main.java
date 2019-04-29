package graph;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = new IndirectedGraph<>();

        Vertex<Integer> v1 = graph.addVertex(1);
        Vertex<Integer> v2 = graph.addVertex(2);
        Vertex<Integer> v3 = graph.addVertex(3);
        Vertex<Integer> v4 = graph.addVertex(4);
        Vertex<Integer> v5 = graph.addVertex(5);
        Vertex<Integer> v6 = graph.addVertex(6);
        Vertex<Integer> v7 = graph.addVertex(7);
        Vertex<Integer> v8 = graph.addVertex(8);

        graph.addEdge(v1, v2);
        graph.addEdge(v1, v3);
        graph.addEdge(v2, v4);
        graph.addEdge(v4, v5);
        graph.addEdge(v3, v5);
        graph.addEdge(v3, v8);
        graph.addEdge(v3, v6);
        graph.addEdge(v6, v7);

        List<Vertex<Integer>> path = graph.getPath(v1, v7);
        System.out.println(path);


        Graph<Integer> graph1 = new DirectedGraph<>();

        Vertex<Integer> vo1 = graph1.addVertex(1);
        Vertex<Integer> vo2 = graph1.addVertex(2);

        graph.addEdge(vo1, vo2);

        List<Vertex<Integer>> path1 = graph1.getPath(v1, v2);
        List<Vertex<Integer>> path2 = graph1.getPath(v2, v3);
        System.out.println(path1);
    }
}
