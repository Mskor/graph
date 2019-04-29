package graph;

import java.util.LinkedList;
import java.util.List;

public interface Graph<T> {

    // Adds a generic vertex to the graph
    public void addVertex(Vertex<T> vertex);

    // For convenience
    public Vertex<T> addVertex(T vertexBody);

    // Adds an edge between vertexes v1 and v2
    // If v1 and v2 belong to the same graph
    public void addEdge(Vertex<T> v1, Vertex<T> v2);

    // Get path between v1 and v2
    // If v1 and v2 belong to the same graph
    public List<Vertex<T>> getPath(Vertex<T> v1, Vertex<T> v2);

    public List<Vertex<T>> getVertices();
}
