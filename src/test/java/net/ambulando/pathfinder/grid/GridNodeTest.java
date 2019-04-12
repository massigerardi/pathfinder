package net.ambulando.pathfinder.grid;

import net.ambulando.pathfinder.nodes.Node;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author massi
 *
 */
public class GridNodeTest {

    /**
     * Test method for {@link net.ambulando.pathfinder.grid.GridNode#toString()}.
     */
    @Test
    public void testToString() {
        Assert.assertEquals("(5,5)", new GridNode(5, 5).toString());
    }

    @Test
    public void testNodeOrder(){
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        Node node = new GridNode(5, 5);
        node.setCost(10d);
        nodes.add(node);
        node = new GridNode(2, 3);
        node.setCost(5d);
        nodes.add(node);
        node = new GridNode(1, 2);
        node.setCost(3d);
        nodes.add(node);
        Assert.assertEquals(3d, nodes.poll().getCost(), 0.0d);
        Assert.assertEquals(5d, nodes.poll().getCost(), 0.0d);
        Assert.assertEquals(10d, nodes.poll().getCost(), 0.0d);
    }


}
