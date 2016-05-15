/**
 * 
 */
package net.ambulando.pathfinder;

import java.util.Iterator;

import net.ambulando.pathfinder.grid.GridNode;
import net.ambulando.pathfinder.nodes.Node;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author massi
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PathTest {

    Path path;
    
    @Mock
    Node node;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        path = new Path();
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.Path#addNode(net.ambulando.pathfinder.nodes.Node)}.
     */
    @Test
    public void testAddNode() {
        path.addNode(node);
        Iterator<Node> iterator = path.iterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertFalse(iterator.hasNext());
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.Path#iterator()}.
     */
    @Test
    public void testIterator() {
        path.addNode(node);
        path.addNode(node);
        Iterator<Node> iterator = path.iterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void testToString() {
        path.addNode(new GridNode(0, 0));
        path.addNode(new GridNode(10, 10));
        Assert.assertEquals("Path([GridNode(0, 0), GridNode(10, 10)])", path.toString());
    }

    @Test
    public void testReverse() {
        path.addNode(new GridNode(0, 0));
        path.addNode(new GridNode(10, 10));
        Path reverse = path.reverse();
        Assert.assertEquals("Path([GridNode(10, 10), GridNode(0, 0)])", reverse.toString());
    }

}
