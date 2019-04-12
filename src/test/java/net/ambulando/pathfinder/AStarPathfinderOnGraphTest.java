package net.ambulando.pathfinder;

import lombok.Getter;
import net.ambulando.pathfinder.nodes.Node;
import net.ambulando.pathfinder.nodes.Nodes;
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
@Getter
public class AStarPathfinderOnGraphTest extends PathfinderTest {

    AStarPathfinder<Node> pathfinder = new AStarPathfinder<>();

    private TestConfiguration configuration = new TestGraph();
}
