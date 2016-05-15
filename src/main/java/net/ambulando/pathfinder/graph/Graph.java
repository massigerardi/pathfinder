/**
 * 
 */
package net.ambulando.pathfinder.graph;

import java.util.List;

import net.ambulando.pathfinder.nodes.Nodes;

/**
 * @author massi
 *
 */
public class Graph extends Nodes<Vertex>{

    public void addEdge(Vertex a, Vertex b) {
        if (!contains(a)) {
            add(a);
        }
        if (!contains(b)) {
            add(b);
        }
        a.addNeighbour(b);
        b.addNeighbour(a);
    }
    
    
    @Override
    public boolean contains(Vertex node) {
        return getNodes().contains(node);
    }

    @Override
    public List<Vertex> neighbours(Vertex node) {
        return node.getNeighbours();
    }
    
    
}
