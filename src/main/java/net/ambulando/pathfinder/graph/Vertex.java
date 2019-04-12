package net.ambulando.pathfinder.graph;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ambulando.pathfinder.nodes.ANode;

/**
 * @author massi
 *
 */
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(of= {"name"}, callSuper=false)
public class Vertex extends ANode {

    @NonNull
    private final String name;

    private final List<Vertex> neighbours = Lists.newArrayList();

    public void addNeighbour(final Vertex neighbour) {
        if (!near(neighbour)) {
            neighbours.add(neighbour);
        }
    }

    public Boolean near(final Vertex b) {
        return neighbours.contains(b);
    }

    @Override
    public String toString() {
        return name;
    }

}
