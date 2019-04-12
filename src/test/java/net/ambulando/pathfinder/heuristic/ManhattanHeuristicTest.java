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
public class ManhattanHeuristicTest {

    Heuristic<GridNode> defaultHeuristic;
    Heuristic<GridNode> halfDistanceHeuristic;
    Heuristic<GridNode> doubleDistanceHeuristic;

    @Mock
    GridNode start;
    @Mock
    GridNode end;

    @Before
    public void setUp() {
        defaultHeuristic = new ManhattanHeuristic();
        halfDistanceHeuristic = new ManhattanHeuristic(0.5);
        doubleDistanceHeuristic = new ManhattanHeuristic(2.0);
        Mockito.when(start.getX()).thenReturn(1);
        Mockito.when(start.getY()).thenReturn(1);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.ManhattanHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}..
     */
    @Test
    public void testCalculateDistanceZero() {
        Mockito.when(end.getX()).thenReturn(1);
        Mockito.when(end.getY()).thenReturn(1);
        Assert.assertEquals(0, defaultHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(0, halfDistanceHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(0, doubleDistanceHeuristic.calculateDistance(start, end), 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.ManhattanHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}..
     */
    @Test
    public void testCalculateDistanceMinimum() {
        Mockito.when(end.getX()).thenReturn(1);
        Mockito.when(end.getY()).thenReturn(2);
        Assert.assertEquals(1, defaultHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(0.5, halfDistanceHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(2, doubleDistanceHeuristic.calculateDistance(start, end), 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.ManhattanHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}..
     */
    @Test
    public void testCalculateDistanceDiagonal() {
        Mockito.when(end.getX()).thenReturn(2);
        Mockito.when(end.getY()).thenReturn(2);
        Assert.assertEquals(2, defaultHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(1, halfDistanceHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(4, doubleDistanceHeuristic.calculateDistance(start, end), 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.ManhattanHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}..
     */
    @Test
    public void testCalculateDistanceExact() {
        Mockito.when(end.getX()).thenReturn(5);
        Mockito.when(end.getY()).thenReturn(4);
        Assert.assertEquals(7, defaultHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(3.5, halfDistanceHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(14, doubleDistanceHeuristic.calculateDistance(start, end), 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.ManhattanHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}..
     */
    @Test
    public void testCalculateDistanceTwo() {
        Mockito.when(end.getX()).thenReturn(0);
        Mockito.when(end.getY()).thenReturn(0);
        Assert.assertEquals(2, defaultHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(1, halfDistanceHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(4, doubleDistanceHeuristic.calculateDistance(start, end), 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.ManhattanHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}..
     */
    @Test
    public void testCalculateDistanceExactDouble() {
        Mockito.when(end.getX()).thenReturn(9);
        Mockito.when(end.getY()).thenReturn(7);
        Assert.assertEquals(14, defaultHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(7, halfDistanceHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(28, doubleDistanceHeuristic.calculateDistance(start, end), 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.ManhattanHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}..
     */
    @Test
    public void testCalculateDistanceExactOtherWay() {
        Mockito.when(end.getX()).thenReturn(-3);
        Mockito.when(end.getY()).thenReturn(-2);
        Assert.assertEquals(7, defaultHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(3.5, halfDistanceHeuristic.calculateDistance(start, end), 0.0);
        Assert.assertEquals(14, doubleDistanceHeuristic.calculateDistance(start, end), 0.0);
    }

}
