/**
 * 
 */
package net.ambulando.pathfinder;

import java.util.Iterator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.ambulando.pathfinder.nodes.Node;

import com.google.common.collect.Lists;

/**
 * @author massi
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames=false)
public class Path implements Iterable<Node>{

    private List<Node> nodes = Lists.newArrayList();
    
    public void addNode(Node node) {
        nodes.add(node);
    }

    public Iterator<Node> iterator() {
        return nodes.iterator();
    }

    public int size() {
        return nodes.size();
    }

    public Path reverse() {
        List<Node> reverse = Lists.reverse(nodes);
        return new Path(reverse);
    }

 }
