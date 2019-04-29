package graph;

import java.util.ArrayList;
import java.util.List;

public class IndirectedVertex<T> extends Vertex<T> {

    private List<Vertex<T>> neighbors = new ArrayList<>();

    public IndirectedVertex(T body) {
        super(body);
    }

    public boolean isDirected() {
        return false;
    }

    @Override
    public void addNeighbor(Vertex<T> v, Vertex.DIRECTION direction) {
        if(v.isDirected() == isDirected() && direction == null) {
            neighbors.add(v);
        } else {
            // TODO: throw an exception
        }
    }

    @Override
    public boolean isIsolated() {
        return neighbors.isEmpty();
    }

    // For undirected graph this is the same
    @Override
    public List<Vertex<T>> getInboundNeighbors() {
        return neighbors;
    }

    @Override
    public List<Vertex<T>> getOutboundNeighbors() {
        return neighbors;
    }
}
