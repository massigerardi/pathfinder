package net.ambulando.pathfinder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
public class AStarPathfinder<T extends Node> implements Pathfinder<T> {

    public Path findPath(final T start, final T end, Nodes<T> nodes, Heuristic<T> heuristic) {
        final List<Node> visited = new ArrayList<>();
        final PriorityQueue<T> queue = new PriorityQueue<>();

        start.setCost(0d);
        start.setCost(heuristic.calculateDistance(start, end));
        queue.add(start);
        loop: while(!queue.isEmpty()) {
           final T node = queue.poll();
           visited.add(node);
           final List<T> neighbours = nodes.neighbours(node);
           for (final T neighbour : neighbours) {
               if (visited.contains(neighbour)) {
                   continue;
               }
               final Double estimatedCost = node.getCost()+heuristic.calculateDistance(node, neighbour);
               if (!queue.contains(neighbour)
                       || estimatedCost < neighbour.getCost()) {
                   neighbour.setPrevious(node);
                   if (neighbour.equals(end)) {
                       break loop;
                   }
                   neighbour.setCost(estimatedCost);
                   neighbour.setEstimatedCost(estimatedCost+heuristic.calculateDistance(neighbour, end));
                   if (!queue.contains(neighbour)) {
                       queue.add(neighbour);
                   }
               }
           }
        }
        return Path.getPath(start, end);
    }

    @Override
    public String getName() {
        return "AStar";
    }


}
