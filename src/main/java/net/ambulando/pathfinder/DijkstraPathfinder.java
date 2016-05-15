/**
 *
 */
package net.ambulando.pathfinder;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.ToString;
import net.ambulando.pathfinder.heuristic.Heuristic;
import net.ambulando.pathfinder.nodes.Node;
import net.ambulando.pathfinder.nodes.Nodes;

/**
 * @author massi
 *
 */
@AllArgsConstructor
@ToString(includeFieldNames=false, of= {"heuristic"})
public class DijkstraPathfinder<T extends Node> implements Pathfinder<T> {

    Nodes<T> nodes;

    Heuristic<T> heuristic;

    /* (non-Javadoc)
     * @see net.ambulando.pathfinder.Pathfinder#findPath(net.ambulando.pathfinder.nodes.Node, net.ambulando.pathfinder.nodes.Node)
     */
    public Path findPath(final T start, final T end) {
        if (!nodes.contains(start)
          ||!nodes.contains(end)) {
            return null;
        }

        final PriorityQueue<T> queue = new PriorityQueue<T>(new Comparator<T>() {

            public int compare(final T o1, final T o2) {
                return o1.getCost().compareTo(o2.getCost());
            }
        });
        nodes.forEach(new Consumer<T>() {
            public void accept(final T t) {
                t.setCost(Double.MAX_VALUE);
            }
        });
        start.setCost(0d);
        queue.add(start);
        loop: while(!queue.isEmpty()) {
            final T node = queue.poll();
            final List<T> neighbours = nodes.neighbours(node);
            for (final T neighbour : neighbours) {
                final double cost = node.getCost() + heuristic.calculateDistance(node, neighbour);
                if (cost < neighbour.getCost()) {
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

}
