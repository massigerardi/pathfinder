/**
 *
 */
package net.ambulando.pathfinder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ambulando.pathfinder.graph.Graph;
import net.ambulando.pathfinder.graph.GraphHeuristic;
import net.ambulando.pathfinder.graph.Vertex;

/**
 * @author massi
 *
 */
public class PathfinderOnGraphTest {

    Graph graph;
    Vertex a = new Vertex("a");
    Vertex b = new Vertex("b");
    Vertex c = new Vertex("c");
    Vertex d = new Vertex("d");
    Vertex e = new Vertex("e");
    Vertex f = new Vertex("f");
    Vertex g = new Vertex("g");
    Vertex h = new Vertex("h");
    Vertex i = new Vertex("i");

    @Before
    public void setUp() {
        graph = new Graph();
        graph.add(i);
        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(b, g);
        graph.addEdge(b, d);
        graph.addEdge(c, f);
        graph.addEdge(c, g);
        graph.addEdge(e, g);
        graph.addEdge(e, h);
        graph.addEdge(f, h);
    }

    /**
     * Test method for {@link net.ambulando.pathfinder.Pathfinder#findPath(net.ambulando.pathfinder.nodes.Node, net.ambulando.pathfinder.nodes.Node)}.
     */
    @Test
    public void testPathfinderWithEuclideanHeuristic() {
        final DijkstraPathfinder<Vertex> dijkstraPathfinder = new DijkstraPathfinder<Vertex>(graph, new GraphHeuristic());
        final AStarPathfinder<Vertex> aStarPathfinder = new AStarPathfinder<Vertex>(graph, new GraphHeuristic());
        final Vertex start = a;
        Vertex end = b;
        checkPath(dijkstraPathfinder, start, end, 2);
        checkPath(aStarPathfinder, start, end, 2);
        end = c;
        checkPath(dijkstraPathfinder, start, end, 3);
        checkPath(aStarPathfinder, start, end, 3);
        end = h;
        checkPath(dijkstraPathfinder, start, end, 5);
        checkPath(aStarPathfinder, start, end, 5);
        end = i;
        checkPath(dijkstraPathfinder, start, end, 0);
        checkPath(aStarPathfinder, start, end, 0);
    }

    private void checkPath(final Pathfinder<Vertex> pathfinder, final Vertex start, final Vertex end, final int expectedPath) {
        final Path result = pathfinder.findPath(start, end);
        Assert.assertEquals(expectedPath, result.size());
    }
}
