package net.ambulando.pathfinder;

import lombok.Getter;

import net.ambulando.pathfinder.grid.GridNode;

/**
 * @author massi
 *
 */
@Getter
public class DijkstraPathfinderOnGridEuclideanTest extends PathfinderTest {

    DijkstraPathfinder<GridNode> pathfinder = new DijkstraPathfinder<GridNode>();

    private TestConfiguration configuration = new TestGridDijkstraEuclidean();
}
