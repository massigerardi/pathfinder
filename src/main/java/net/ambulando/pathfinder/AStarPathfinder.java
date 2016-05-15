/**
 *
 */
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
@ToString(includeFieldNames=false, of= {"heuristic"})
public class AStarPathfinder<T extends Node> implements Pathfinder<T> {

    Nodes<T> nodes;

    Heuristic<T> heuristic;

    public Path findPath(final T start, final T end) {
        final List<Node> visited = new ArrayList<Node>();
        final PriorityQueue<T> queue = new PriorityQueue<T>(new Comparator<T>() {
            public int compare(final T o1, final T o2) {
                return o1.getEstimatedCost().compareTo(o2.getEstimatedCost());
            }
        });

        start.setCost(0d);
        start.setCost(heuristic.calculateDistance(start, end));
        queue.add(start);
        int c = 0;
        loop: while(!queue.isEmpty()) {
           c++;
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

        System.out.print("   "+this+"\tfrom "+start+" to "+end+" took in "+c+"\t");
        final Path path = new Path();
        Node p = end;
        while(p.getPrevious()!=null) {
            path.addNode(p);
            p = p.getPrevious();
        }
        return path.reverse();
    }

}
