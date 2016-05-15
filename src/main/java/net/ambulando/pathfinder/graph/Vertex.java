/**
 * 
 */
package net.ambulando.pathfinder.graph;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import net.ambulando.pathfinder.nodes.ANode;

import com.google.common.collect.Lists;

/**
 * @author massi
 *
 */
@Getter
@RequiredArgsConstructor
@ToString(includeFieldNames=false, of= {"name"}, doNotUseGetters = true, callSuper=false)
@EqualsAndHashCode(of= {"name"}, callSuper=false)
public class Vertex extends ANode {
    
    @NonNull
    private String name;
    
    private List<Vertex> neighbours = Lists.newArrayList();

    public void addNeighbour(Vertex neighbour) {
        if (!this.near(neighbour)) {
            this.neighbours.add(neighbour);
        }
    }
    
    public Boolean near(Vertex b) {
        return this.neighbours.contains(b);
    }

}
