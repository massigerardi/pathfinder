package net.ambulando.pathfinder;

import lombok.AllArgsConstructor;
import net.ambulando.pathfinder.heuristic.Heuristic;
import net.ambulando.pathfinder.nodes.Node;
import net.ambulando.pathfinder.nodes.Nodes;

import java.util.List;
import java.util.PriorityQueue;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author massi
 *
 */
@AllArgsConstructor
public class AStarPathfinder<T extends Node> implements Pathfinder<T> {

    public Path findPath(final T start, final T end, Nodes<T> nodes, Heuristic<T> heuristic) {
        List<T> visited = newArrayList();
        PriorityQueue<T> visiting = new PriorityQueue<>((n1, n2) -> Double.compare(n1.getEstimatedCost(), n2.getEstimatedCost()));
        start.setCost(0d);
        start.setEstimatedCost(heuristic.calculateDistance(start, end));

        visiting.add(start);

        while (!visiting.isEmpty()) {
            T current = visiting.poll();
            if (current == end) {
                return Path.getPath(start, end);
            }
            visited.add(current);
            for (T n : nodes.neighbours(current)) {
                if (visited.contains(n)) {
                    continue;
                }
                double cost = current.getCost()+heuristic.calculateDistance(current, n);
                if (!visiting.contains(n)) {
                    visiting.add(n);
                } else if (cost > n.getCost()) {
                    continue;
                }
                n.setPrevious(current);
                n.setCost(cost);
                n.setEstimatedCost(n.getCost() + heuristic.calculateDistance(n, end));
            }
        }

        return Path.getPath(start, end);
    }

    @Override
    public String getName() {
        return "AStar";
    }


}
