package net.ambulando.pathfinder;

import lombok.Getter;
import net.ambulando.pathfinder.nodes.Node;

/**
 * @author massi
 *
 */
@Getter
public class AStarPathfinderOnGridEuclideanTest extends PathfinderTest {

    AStarPathfinder<Node> pathfinder = new AStarPathfinder<>();

    private TestConfiguration configuration = new TestGridAStarEuclidean();
}
