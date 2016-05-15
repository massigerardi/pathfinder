/**
 * 
 */
package net.ambulando.pathfinder.grid;

import net.ambulando.pathfinder.nodes.Node;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author massi
 *
 */
public class GridNodeTest {

    Node node;

    Grid grid = new Grid(0, 0, 10, 10);

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        node = new GridNode(5, 5);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.grid.GridNode#toString()}.
     */
    @Test
    public void testToString() {
        Assert.assertEquals("GridNode(5, 5)", node.toString());
    }

}
