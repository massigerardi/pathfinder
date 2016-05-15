/**
 *
 */
package net.ambulando.pathfinder.heuristic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import net.ambulando.pathfinder.grid.GridNode;

/**
 * @author massi
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class EuclideanHeuristicTest {

    Heuristic<GridNode> heuristic;

    @Mock
    GridNode start;
    @Mock
    GridNode end;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        heuristic = new EuclideanHeuristic();
        Mockito.when(start.getX()).thenReturn(1);
        Mockito.when(start.getY()).thenReturn(1);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.EuclideanHeuristic#calculateDistance(net.ambulando.pathfinder.nodes.Node, net.ambulando.pathfinder.nodes.Node)}.
     */
    @Test
    public void testCalculateDistanceZero() {
        Mockito.when(end.getX()).thenReturn(1);
        Mockito.when(end.getY()).thenReturn(1);
        final double distance = heuristic.calculateDistance(start, end);
        Assert.assertEquals(0, distance, 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.EuclideanHeuristic#calculateDistance(net.ambulando.pathfinder.nodes.Node, net.ambulando.pathfinder.nodes.Node)}.
     */
    @Test
    public void testCalculateDistanceExact() {
        Mockito.when(end.getX()).thenReturn(5);
        Mockito.when(end.getY()).thenReturn(4);
        final double distance = heuristic.calculateDistance(start, end);
        Assert.assertEquals(5, distance, 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.EuclideanHeuristic#calculateDistance(net.ambulando.pathfinder.nodes.Node, net.ambulando.pathfinder.nodes.Node)}.
     */
    @Test
    public void testCalculateDistanceDiagonal() {
        Mockito.when(end.getX()).thenReturn(0);
        Mockito.when(end.getY()).thenReturn(0);
        final double distance = heuristic.calculateDistance(start, end);
        Assert.assertEquals(Math.sqrt(2), distance, 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.EuclideanHeuristic#calculateDistance(net.ambulando.pathfinder.nodes.Node, net.ambulando.pathfinder.nodes.Node)}.
     */
    @Test
    public void testCalculateDistanceMinimum() {
        Mockito.when(end.getX()).thenReturn(1);
        Mockito.when(end.getY()).thenReturn(2);
        final double distance = heuristic.calculateDistance(start, end);
        Assert.assertEquals(1, distance, 0.0);
    }


    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.EuclideanHeuristic#calculateDistance(net.ambulando.pathfinder.nodes.Node, net.ambulando.pathfinder.nodes.Node)}.
     */
    @Test
    public void testCalculateDistanceExactDouble() {
        Mockito.when(end.getX()).thenReturn(9);
        Mockito.when(end.getY()).thenReturn(7);
        final double distance = heuristic.calculateDistance(start, end);
        Assert.assertEquals(10, distance, 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.EuclideanHeuristic#calculateDistance(net.ambulando.pathfinder.nodes.Node, net.ambulando.pathfinder.nodes.Node)}.
     */
    @Test
    public void testCalculateDistanceExactOtherWay() {
        Mockito.when(end.getX()).thenReturn(-3);
        Mockito.when(end.getY()).thenReturn(-2);
        final double distance = heuristic.calculateDistance(start, end);
        Assert.assertEquals(5, distance, 0.0);
    }

}
