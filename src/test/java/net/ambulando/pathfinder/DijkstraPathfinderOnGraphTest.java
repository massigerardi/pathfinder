package net.ambulando.pathfinder;

import lombok.Getter;
import net.ambulando.pathfinder.graph.Vertex;
import net.ambulando.pathfinder.nodes.Node;

/**
 * @author massi
 *
 */
@Getter
public class DijkstraPathfinderOnGraphTest extends PathfinderTest {

  DijkstraPathfinder<Vertex> pathfinder = new DijkstraPathfinder<>();

  private TestConfiguration configuration = new TestGraph();

}
