import graph.DirectedGraph;
import graph.IndirectedGraph;
import graph.Vertex;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class GraphTest {

    private DirectedGraph<Integer> directedGraph;
    private IndirectedGraph<Integer> indirectedGraph;

    private LinkedList<Vertex<Integer>> indirectedTestPath17;
    private LinkedList<Vertex<Integer>> directedTestPath16;

    @Before
    public void init() {
        indirectedGraph = new IndirectedGraph<>();

        Vertex<Integer> v1 = indirectedGraph.addVertex(1);
        Vertex<Integer> v2 = indirectedGraph.addVertex(2);
        Vertex<Integer> v3 = indirectedGraph.addVertex(3);
        Vertex<Integer> v4 = indirectedGraph.addVertex(4);
        Vertex<Integer> v5 = indirectedGraph.addVertex(5);
        Vertex<Integer> v6 = indirectedGraph.addVertex(6);
        Vertex<Integer> v7 = indirectedGraph.addVertex(7);
        Vertex<Integer> v8 = indirectedGraph.addVertex(8);

        indirectedGraph.addEdge(v1, v2);
        indirectedGraph.addEdge(v1, v3);
        indirectedGraph.addEdge(v2, v4);
        indirectedGraph.addEdge(v4, v5);
        indirectedGraph.addEdge(v3, v5);
        indirectedGraph.addEdge(v3, v8);
        indirectedGraph.addEdge(v3, v6);
        indirectedGraph.addEdge(v6, v7);

        indirectedTestPath17 = new LinkedList<>();
        indirectedTestPath17.add(v1);
        indirectedTestPath17.add(v2);
        indirectedTestPath17.add(v4);
        indirectedTestPath17.add(v5);
        indirectedTestPath17.add(v3);
        indirectedTestPath17.add(v6);
        indirectedTestPath17.add(v7);

        directedGraph = new DirectedGraph<>();

        Vertex<Integer> vo1 = directedGraph.addVertex(1);
        Vertex<Integer> vo2 = directedGraph.addVertex(2);
        Vertex<Integer> vo3 = directedGraph.addVertex(3);
        Vertex<Integer> vo4 = directedGraph.addVertex(4);
        Vertex<Integer> vo5 = directedGraph.addVertex(5);
        Vertex<Integer> vo6 = directedGraph.addVertex(6);

        directedGraph.addEdge(vo1, vo2);
        directedGraph.addEdge(vo1, vo3);
        directedGraph.addEdge(vo2, vo4);
        directedGraph.addEdge(vo2, vo5);
        directedGraph.addEdge(vo5, vo6);

        directedTestPath16 = new LinkedList<>();

        directedTestPath16.add(vo1);
        directedTestPath16.add(vo2);
        directedTestPath16.add(vo5);
        directedTestPath16.add(vo6);
    }

    @After
    public void destroy() {
        directedGraph = null;
        indirectedGraph = null;
    }

    @Test
    public void randomPathTest() {
        List<Vertex<Integer>> vertices = indirectedGraph.getVertices();

        Random random = new Random();

        Vertex<Integer> v1 = vertices.get(random.nextInt(vertices.size()));
        Vertex<Integer> v2 = vertices.get(random.nextInt(vertices.size()));

        System.out.println("Indirected random path test: " + v1 + " -> " + v2);

        List<Vertex<Integer>> path = indirectedGraph.getPath(v1, v2);
        // Path should always exist since test graph is connected
        Assert.assertNotNull(path);
        System.out.println("Random path test; indirected graph path found: " + path);

        vertices = directedGraph.getVertices();

        v1 = vertices.get(random.nextInt(vertices.size()));
        v2 = vertices.get(random.nextInt(vertices.size()));

        System.out.println("Directed random path test: " + v1 + " -> " + v2);

        List<Vertex<Integer>> path1 = directedGraph.getPath(v1, v2);
        System.out.println("Random path test; indirected graph path: " + (path1.isEmpty() ? "is not found" : path1));
    }

    @Test
    public void specificPathTest() {
        List<Vertex<Integer>> vertices = indirectedGraph.getVertices();

        Vertex<Integer> v1 = vertices.get(0);
        Vertex<Integer> v2 = vertices.get(6);

        List<Vertex<Integer>> path = indirectedGraph.getPath(v1, v2);
        System.out.println("resulting path v1 -> v7: " + path);
        System.out.println("True path: " + indirectedTestPath17);
        Assert.assertEquals(path, indirectedTestPath17);

        vertices = directedGraph.getVertices();

        v1 = vertices.get(0);
        v2 = vertices.get(5);

        path = directedGraph.getPath(v1, v2);
        System.out.println("resulting path v1 -> v6: " + path);
        System.out.println("True path: " + directedTestPath16);
        Assert.assertEquals(path, directedTestPath16);
    }
}
