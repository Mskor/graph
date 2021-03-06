package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DirectedGraph<T> extends IndirectedGraph<T> {

    @Override
    public void addVertex(Vertex<T> vertex) {
        if (vertex.isDirected() == false) {
            vertices.add(vertex);
        }
    }

    @Override
    public Vertex<T> addVertex(T vertexBody) {
        DirectedVertex<T> v = new DirectedVertex<T>(vertexBody);
        vertices.add(v);
        return v;
    }

    // v1 -> v2
    @Override
    public void addEdge(Vertex<T> v1, Vertex<T> v2) {
        if (!isValidVertex(v1) || !isValidVertex(v2)) {
            System.out.println("addEdge: Invalid vertexes: " + v1 + ", " + v2);
            return;
        }

        v1.addNeighbor(v2, Vertex.DIRECTION.OUTBOUND);
        v2.addNeighbor(v1, Vertex.DIRECTION.INBOUND);
    }

    @Override
    public List<Vertex<T>> getPath(Vertex<T> source, Vertex<T> destination) {

        if (!isValidVertex(source) || !isValidVertex(destination)) {
            System.out.println("getPath: Incorrect arguments: " + source + ", " + destination);
            return null;
        }

        if (source.isIsolated() || destination.isIsolated()) {
            // No path available
            return null;
        }

        LinkedList<Vertex<T>> path = new LinkedList<>();
        path.add(source);

        List<Vertex<T>> deadEndVertices = new ArrayList<>();

        LinkedList<Vertex<T>> result = traverse(path, destination, deadEndVertices);

        // For directed graph any path should be at least
        // 2 vertices long. 1 means no path.
        if(result.size() == 1) {
            return new LinkedList<>();
        } else {
            return result;
        }

    }
}
