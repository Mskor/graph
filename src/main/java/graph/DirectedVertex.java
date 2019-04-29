package graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedVertex<T> extends Vertex<T> {

    private List<Vertex<T>> inboundNeighbors = new ArrayList<>();
    private List<Vertex<T>> outboundNeighbors = new ArrayList<>();

    public DirectedVertex(T body) {
        super(body);
    }

    public boolean isDirected() {
        return true;
    }

    public void addNeighbor(Vertex<T> v, DIRECTION direction) {
        if(v == null || direction == null) {
            return;
            // TODO: throw an exception
        }

        if (direction.equals(DIRECTION.INBOUND)) {
            inboundNeighbors.add(v);
        } else {
            outboundNeighbors.add(v);
        }
    }

    @Override
    public boolean isIsolated() {
        return outboundNeighbors.isEmpty() && inboundNeighbors.isEmpty();
    }

    @Override
    public List<Vertex<T>> getInboundNeighbors() {
        return inboundNeighbors;
    }

    @Override
    public List<Vertex<T>> getOutboundNeighbors() {
        return outboundNeighbors;
    }
}
