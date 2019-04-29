package graph;

import java.util.List;

public abstract class Vertex<T> {

    public enum DIRECTION {
        INBOUND, OUTBOUND
    }

    private T body;

    public Vertex(T body) {
        this.body = body;
    }

    public abstract boolean isDirected();

    public abstract void addNeighbor(Vertex<T> v, Vertex.DIRECTION direction);

    public abstract boolean isIsolated();

    public abstract List<Vertex<T>> getInboundNeighbors();

    public abstract List<Vertex<T>> getOutboundNeighbors();

    @Override
    public String toString() {
        return body.toString();
    }
}
