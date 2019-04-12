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
public class OctileHeuristicTest {

    private Heuristic<GridNode> defaultHeuristic;

    @Mock
    GridNode start;
    @Mock
    GridNode end;

    @Before
    public void setUp()  {
        defaultHeuristic = new OctileHeuristic();
        Mockito.when(start.getX()).thenReturn(1);
        Mockito.when(start.getY()).thenReturn(1);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.OctileHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}.
     */
    @Test
    public void testCalculateDistanceZero() {
        Mockito.when(end.getX()).thenReturn(1);
        Mockito.when(end.getY()).thenReturn(1);
        assertEquals(0, defaultHeuristic.calculateDistance(start, end));
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.OctileHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}.
     */
    @Test
    public void testCalculateDistanceExact() {
        Mockito.when(end.getX()).thenReturn(5);
        Mockito.when(end.getY()).thenReturn(4);
        assertEquals(5.242, defaultHeuristic.calculateDistance(start, end));
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.OctileHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}.
     */
    @Test
    public void testCalculateDistanceTwo() {
        Mockito.when(end.getX()).thenReturn(0);
        Mockito.when(end.getY()).thenReturn(0);
        assertEquals(1.414, defaultHeuristic.calculateDistance(start, end));
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.OctileHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}.
     */
    @Test
    public void testCalculateDistanceExactDouble() {
        Mockito.when(end.getX()).thenReturn(9);
        Mockito.when(end.getY()).thenReturn(7);
        assertEquals(10.485, defaultHeuristic.calculateDistance(start, end));
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.heuristic.OctileHeuristic#calculateDistance(net.ambulando.pathfinder.grid.GridNode, net.ambulando.pathfinder.grid.GridNode)}.
     */
    @Test
    public void testCalculateDistanceExactOtherWay() {
        Mockito.when(end.getX()).thenReturn(-3);
        Mockito.when(end.getY()).thenReturn(-2);
        assertEquals(5.242, defaultHeuristic.calculateDistance(start, end));
    }

    private void assertEquals(final double expected, final Double calculateDistance) {
        Assert.assertEquals(expected, defaultHeuristic.calculateDistance(start, end), expected/1e-3);
    }

}
