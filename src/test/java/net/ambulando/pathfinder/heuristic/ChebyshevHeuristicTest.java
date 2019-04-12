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
public class ChebyshevHeuristicTest {

    Heuristic<GridNode> defaultHeuristic;

    @Mock
    GridNode start;
    @Mock
    GridNode end;

    @Before
    public void setUp() {
        defaultHeuristic = new ChebyshevHeuristic();
        Mockito.when(start.getX()).thenReturn(1);
        Mockito.when(start.getY()).thenReturn(1);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.ChebyshevHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}.
     */
    @Test
    public void testCalculateDistanceZero() {
        Mockito.when(end.getX()).thenReturn(1);
        Mockito.when(end.getY()).thenReturn(1);
        Assert.assertEquals(0, defaultHeuristic.calculateDistance(start, end), 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.ChebyshevHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}.
     */
    @Test
    public void testCalculateDistanceExact() {
        Mockito.when(end.getX()).thenReturn(5);
        Mockito.when(end.getY()).thenReturn(4);
        Assert.assertEquals(4, defaultHeuristic.calculateDistance(start, end), 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.ChebyshevHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}.
     */
    @Test
    public void testCalculateDistanceTwo() {
        Mockito.when(end.getX()).thenReturn(0);
        Mockito.when(end.getY()).thenReturn(0);
        Assert.assertEquals(1, defaultHeuristic.calculateDistance(start, end), 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.ChebyshevHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}.
     */
    @Test
    public void testCalculateDistanceExactDouble() {
        Mockito.when(end.getX()).thenReturn(9);
        Mockito.when(end.getY()).thenReturn(7);
        Assert.assertEquals(8, defaultHeuristic.calculateDistance(start, end), 0.0);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.ChebyshevHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}.
     */
    @Test
    public void testCalculateDistanceExactOtherWay() {
        Mockito.when(end.getX()).thenReturn(-3);
        Mockito.when(end.getY()).thenReturn(-2);
        Assert.assertEquals(4, defaultHeuristic.calculateDistance(start, end), 0.0);
    }

}
