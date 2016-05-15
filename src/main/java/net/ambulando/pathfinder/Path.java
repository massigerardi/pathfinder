/**
 *
 */
package net.ambulando.pathfinder;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.ambulando.pathfinder.nodes.Node;

/**
 * @author massi
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames=false)
public class Path implements Iterable<Node>{

    private List<Node> nodes = Lists.newArrayList();

    public void addNode(final Node node) {
        nodes.add(node);
    }

    public Iterator<Node> iterator() {
        return nodes.iterator();
    }

    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    public int size() {
        return nodes.size();
    }

    public Path reverse() {
        final List<Node> reverse = Lists.reverse(nodes);
        return new Path(reverse);
    }

    public static <T extends Node> Path getPath(final T start, final T end) {
        final Path path = new Path();
        Node p = end;
        while(p.getPrevious()!=null) {
            path.addNode(p);
            p = p.getPrevious();
        }
        if (!path.isEmpty()) {
            path.addNode(start);
        }
        return path.reverse();
    }

 }
