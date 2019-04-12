package net.ambulando.pathfinder;

import net.ambulando.pathfinder.nodes.Node;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author massi
 *
 */
public abstract class PathfinderTest {

    public abstract Pathfinder<? extends Node> getPathfinder();

    public abstract TestConfiguration getConfiguration();

    @Test
    public void testDijkstraPathfinderA2B() {
        checkPath(getPathfinder(), getConfiguration().getCases().get(0));
    }

    @Test
    public void testDijkstraPathfinderA2C() {
        checkPath(getPathfinder(), getConfiguration().getCases().get(1));
    }

    @Test
    public void testDijkstraPathfinderA2H() {
        checkPath(getPathfinder(), getConfiguration().getCases().get(2));
    }

    @Test
    public void testDijkstraPathfinderA2I() {
        checkPath(getPathfinder(), getConfiguration().getCases().get(3));
    }


    protected <T extends Node> void checkPath(final Pathfinder pathfinder, TestCase testCase) {
        final Path result = pathfinder.findPath(testCase.getStart(), testCase.getEnd(), getConfiguration().getNodes(), getConfiguration().getHeuristic());
        Assert.assertEquals(testCase.getExpectedPath(), result.toString());
    }

}
