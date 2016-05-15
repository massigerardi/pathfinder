package net.ambulando.pathfinder.nodes;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class ANode implements Node {

    @Setter
    private Node previous;
    
    @Setter
    private Double cost;

    @Setter
    private Double estimatedCost;

}
