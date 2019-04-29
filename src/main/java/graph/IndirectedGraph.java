package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IndirectedGraph<T> implements Graph<T> {

    protected List<Vertex<T>> vertices = new ArrayList<>();

    public void addVertex(Vertex<T> vertex) {
        if (vertex.isDirected() == false && vertex != null) {
            vertices.add(vertex);
        }
    }

    public Vertex<T> addVertex(T vertexBody) {
        IndirectedVertex<T> v = null;

        if (vertexBody != null) {
            v = new IndirectedVertex<T>(vertexBody);
            vertices.add(v);
        }

        return v;
    }

    public void addEdge(Vertex<T> v1, Vertex<T> v2) {

        if (!isValidVertex(v1) || !isValidVertex(v2)) {
            // TODO: log and throw an exception
            return;
        }

        v1.addNeighbor(v2, null);
        v2.addNeighbor(v1, null);
    }

    public List<Vertex<T>> getPath(Vertex<T> source, Vertex<T> destination) {

        if (!isValidVertex(source) || !isValidVertex(destination)) {
            // TODO: log and throw an exception
            return null;
        }

        if (source.isIsolated() || destination.isIsolated()) {
            // No path available
            return null;
        }

        // Create
        LinkedList<Vertex<T>> path = new LinkedList<>();
        path.add(source);

        if (source == destination) {
            return path;
        }

        return traverse(path, destination);
    }

    public LinkedList<Vertex<T>> traverse(LinkedList<Vertex<T>> path, Vertex<T> destination) {

        System.out.println(path);

        if (path.contains(destination)) {
            return path;
        }

        // Find all neighbors that aren't already part of the path
        List<Vertex<T>> steps = path.getLast().getOutboundNeighbors();
        steps.removeAll(path);

        if (steps.isEmpty()) {
            path.removeLast();
            return path;
        }

        LinkedList<Vertex<T>> nPath = new LinkedList<Vertex<T>>(path);

        // Traverse recursively for each new step
        for (Vertex<T> step : steps) {
            nPath.add(step);
            nPath = traverse(nPath, destination);
            if (nPath != null && nPath.contains(destination)) {
                break;
            }
        }

        return nPath;
    }

    @Override
    public List<Vertex<T>> getVertices() {
        return vertices;
    }

    protected boolean isValidVertex(Vertex<T> vertex) {
        return (vertex != null && vertices.contains(vertex));
    }
}
