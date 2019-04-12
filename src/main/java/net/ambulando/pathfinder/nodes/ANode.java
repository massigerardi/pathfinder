package net.ambulando.pathfinder.nodes;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class ANode implements Node {

    @Setter
    private Node previous;
    
    @Setter
    private double cost;

    @Setter
    private double estimatedCost;


    @Override
    public int compareTo(Node that) {
        return Double.compare(this.getCost(), that.getCost());
    }
}
