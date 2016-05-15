/**
 *
 */
package net.ambulando.pathfinder;

import org.junit.Before;
import org.junit.Test;

import net.ambulando.pathfinder.grid.Grid;
import net.ambulando.pathfinder.grid.GridNode;
import net.ambulando.pathfinder.heuristic.ChebyshevHeuristic;
import net.ambulando.pathfinder.heuristic.EuclideanHeuristic;
import net.ambulando.pathfinder.heuristic.ManhattanHeuristic;

/**
 * @author massi
 *
 */
public class PathfinderOnGridTest {

    Grid grid;

    @Before
    public void setUp() {
        grid = new Grid(0, 0, 10, 10);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.Pathfinder#findPath(net.ambulando.pathfinder.nodes.Node, net.ambulando.pathfinder.nodes.Node)}.
     */
    @Test
    public void testPathfinderWithEuclideanHeuristic() {
        final GridNode start = grid.getNode(0, 0);
        final DijkstraPathfinder<GridNode> dijkstraPathfinder = new DijkstraPathfinder<GridNode>(grid, new EuclideanHeuristic());
        final AStarPathfinder<GridNode> aStarPathfinder = new AStarPathfinder<GridNode>(grid, new EuclideanHeuristic());
        GridNode end = grid.getNode(3, 5);
        checkPath(dijkstraPathfinder, start, end, null);
        checkPath(aStarPathfinder, start, end, null);
        end = grid.getNode(10, 10);
        checkPath(dijkstraPathfinder, start, end, null);
        checkPath(aStarPathfinder, start, end, null);
        end = grid.getNode(10, 5);
        checkPath(dijkstraPathfinder, start, end, null);
        checkPath(aStarPathfinder, start, end, null);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.Pathfinder#findPath(net.ambulando.pathfinder.nodes.Node, net.ambulando.pathfinder.nodes.Node)}.
     */
    @Test
    public void testPathfinderWithManhattanHeuristic() {
        final GridNode start = grid.getNode(0, 0);
        final DijkstraPathfinder<GridNode> dijkstraPathfinder = new DijkstraPathfinder<GridNode>(grid, new ManhattanHeuristic());
        final AStarPathfinder<GridNode> aStarPathfinder = new AStarPathfinder<GridNode>(grid, new ManhattanHeuristic());
        GridNode end = grid.getNode(3, 5);
        checkPath(dijkstraPathfinder, start, end, null);
        checkPath(aStarPathfinder, start, end, null);
        end = grid.getNode(10, 10);
        checkPath(dijkstraPathfinder, start, end, null);
        checkPath(aStarPathfinder, start, end, null);
        end = grid.getNode(10, 5);
        checkPath(dijkstraPathfinder, start, end, null);
        checkPath(aStarPathfinder, start, end, null);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.Pathfinder#findPath(net.ambulando.pathfinder.nodes.Node, net.ambulando.pathfinder.nodes.Node)}.
     */
    @Test
    public void testPathfinderWithChebyshevHeuristic() {
        final GridNode start = grid.getNode(0, 0);
        final DijkstraPathfinder<GridNode> dijkstraPathfinder = new DijkstraPathfinder<GridNode>(grid, new ChebyshevHeuristic());
        final AStarPathfinder<GridNode> aStarPathfinder = new AStarPathfinder<GridNode>(grid, new ChebyshevHeuristic());
        GridNode end = grid.getNode(3, 5);
        checkPath(dijkstraPathfinder, start, end, null);
        checkPath(aStarPathfinder, start, end, null);
        end = grid.getNode(10, 10);
        checkPath(dijkstraPathfinder, start, end, null);
        checkPath(aStarPathfinder, start, end, null);
        end = grid.getNode(10, 5);
        checkPath(dijkstraPathfinder, start, end, null);
        checkPath(aStarPathfinder, start, end, null);
    }

    private void checkPath(final Pathfinder<GridNode> pathfinder, final GridNode start, final GridNode end, final Path expectedPath) {
        final Path result = pathfinder.findPath(start, end);
        System.out.println(" found "+result.size()+" nodes: "+result);
    }
}
