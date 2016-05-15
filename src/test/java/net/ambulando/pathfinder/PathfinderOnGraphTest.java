/**
 * 
 */
package net.ambulando.pathfinder;

import net.ambulando.pathfinder.graph.Graph;
import net.ambulando.pathfinder.graph.GraphHeuristic;
import net.ambulando.pathfinder.graph.Vertex;

import org.junit.Before;
import org.junit.Test;

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
        DijkstraPathfinder<Vertex> dijkstraPathfinder = new DijkstraPathfinder<Vertex>(graph, new GraphHeuristic());
        AStarPathfinder<Vertex> aStarPathfinder = new AStarPathfinder<Vertex>(graph, new GraphHeuristic());
        Vertex start = a;
        Vertex end = b;
        checkPath(dijkstraPathfinder, start, end, null);
        checkPath(aStarPathfinder, start, end, null);
        end = c;
        checkPath(dijkstraPathfinder, start, end, null);
        checkPath(aStarPathfinder, start, end, null);
        end = h;
        checkPath(dijkstraPathfinder, start, end, null);
        checkPath(aStarPathfinder, start, end, null);
        end = i;
        checkPath(dijkstraPathfinder, start, end, null);
        checkPath(aStarPathfinder, start, end, null);
    }

    private void checkPath(Pathfinder<Vertex> pathfinder, Vertex start, Vertex end, Path expectedPath) {
        Path result = pathfinder.findPath(start, end);
        System.out.println(" found "+result.size()+" nodes: "+result);
    }
}
