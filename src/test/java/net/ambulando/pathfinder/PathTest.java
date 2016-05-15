/**
 *
 */
package net.ambulando.pathfinder;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.ambulando.pathfinder.graph.Vertex;
import net.ambulando.pathfinder.grid.GridNode;
import net.ambulando.pathfinder.nodes.Node;

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
        final Iterator<Node> iterator = path.iterator();
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
        final Iterator<Node> iterator = path.iterator();
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
        Assert.assertEquals("Path([(0, 0), (10, 10)])", path.toString());
    }

    @Test
    public void testReverse() {
        path.addNode(new GridNode(0, 0));
        path.addNode(new GridNode(10, 10));
        final Path reverse = path.reverse();
        Assert.assertEquals("Path([(10, 10), (0, 0)])", reverse.toString());
    }

    @Test
    public void testGetPath() {
        final Node a = new Vertex("a");
        final Node b = new Vertex("b");
        b.setPrevious(a);
        final Node c = new Vertex("c");
        c.setPrevious(b);
        final Node d = new Vertex("d");
        d.setPrevious(c);
        final Path path = Path.getPath(a, d);
        Assert.assertEquals("Path([a, b, c, d])", path.toString());
    }

    @Test
    public void testGetPathEmpty() {
        final Node a = new Vertex("a");
        final Node b = new Vertex("b");
        final Path path = Path.getPath(a, b);
        Assert.assertEquals("Path([])", path.toString());
    }

}
