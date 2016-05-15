/**
 * 
 */
package net.ambulando.pathfinder.grid;


import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author massi
 *
 */
public class GridTest {

    Grid grid;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        grid = new Grid(0, 0, 10, 10);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.nodes.Grid#contains(java.lang.Integer, java.lang.Integer)}.
     */
    @Test
    public void testContains() {
        Assert.assertTrue(grid.contains(5, 5));
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.nodes.Grid#contains(java.lang.Integer, java.lang.Integer)}.
     */
    @Test
    public void testContainsNot() {
        Assert.assertFalse("grid.contains(15,15)", grid.contains(15, 15));
        Assert.assertFalse("grid.contains(-5,5)", grid.contains(-5, 5));
        Assert.assertFalse("grid.contains(5,-5)", grid.contains(5, -5));
        Assert.assertFalse("grid.contains(-5,-5)", grid.contains(-5, -5));
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.nodes.Grid#contains(java.lang.Integer, java.lang.Integer)}.
     */
    @Test
    public void testContainsOrigin() {
        Assert.assertTrue(grid.contains(0, 0));
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.nodes.Grid#contains(java.lang.Integer, java.lang.Integer)}.
     */
    @Test
    public void testContainsLowerRight() {
        Assert.assertTrue(grid.contains(0, 0));
    }
    
    /**
     * Test method for {@link net.ambulando.pathfinder.nodes.Grid#size()}.
     */
    @Test
    public void testSize() {
        Assert.assertEquals(121, grid.size());
    }
    
    /**
     * Test method for {@link net.ambulando.pathfinder.nodes.Grid#iterator()}.
     */
    @Test
    public void testIterator() {
        Assert.assertNotNull(grid.iterator());
        Iterator<GridNode> iterator = grid.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertNotNull(iterator.next());
    }
    
    @Test
    public void testToString() {
        Assert.assertEquals("Grid(0, 0, 10, 10)", grid.toString());
    }

    @Test
    public void testNeighbours() {
        checkNode(5,5,8);
        checkNode(9,9,8);
        checkNode(1,1,8);
        checkNode(1,9,8);
        checkNode(9,1,8);
        checkNode(0,5,5);
        checkNode(5,0,5);
        checkNode(0,0,3);
        checkNode(10,10,3);
    }

    private void checkNode(int x, int y, int expected) {
        List<GridNode> nodes = grid.neighbours(new GridNode(x, y));
        Assert.assertEquals(expected, nodes.size());
        System.out.println(nodes);
    }

}
