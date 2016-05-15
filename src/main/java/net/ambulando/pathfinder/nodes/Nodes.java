/**
 * 
 */
package net.ambulando.pathfinder.nodes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Getter;

/**
 * @author massi
 *
 */
public abstract class Nodes<T extends Node> implements Iterable<T> {
    
    @Getter
    private final List<T> nodes = new ArrayList<T>();
    
    public Boolean add(T node) {
        return nodes.add(node);
    }
    
    
    public Iterator<T> iterator() {
        return nodes.iterator();
    }
    
    public int size() {
        return nodes.size();
    }
    
    public abstract boolean contains(T node);
    
    public abstract List<T> neighbours(T node);
}
