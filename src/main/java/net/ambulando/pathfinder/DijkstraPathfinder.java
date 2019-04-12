package net.ambulando.pathfinder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.ToString;
import net.ambulando.pathfinder.heuristic.Heuristic;
import net.ambulando.pathfinder.nodes.Node;
import net.ambulando.pathfinder.nodes.Nodes;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author massi
 *
 */
public class DijkstraPathfinder<T extends Node> implements Pathfinder<T> {

    public Path findPath(final T start, final T end, Nodes<T> nodes, Heuristic<T> heuristic) {
        if (!nodes.contains(start)
          ||!nodes.contains(end)) {
            return null;
        }
        final PriorityQueue<T> queue = new PriorityQueue<>();
        List<T> visited = newArrayList();
        queue.add(start);
        loop: while(!queue.isEmpty()) {
            final T node = queue.poll();
            final List<T> neighbours = nodes.neighbours(node);
            visited.add(node);
            for (final T neighbour : neighbours) {
                if (visited.contains(neighbour)) {
                    continue;
                }
                final double cost = node.getCost() + heuristic.calculateDistance(node, neighbour);
                if (neighbour.getCost() == 0 || cost < neighbour.getCost()) {
                    neighbour.setCost(cost);
                    queue.add(neighbour);
                    neighbour.setPrevious(node);
                    if (neighbour.equals(end)) {
                        break loop;
                    }
                }
            }
        }
        return Path.getPath(start, end);
    }

    @Override
    public String getName() {
        return "Dijkstra";
    }

}
