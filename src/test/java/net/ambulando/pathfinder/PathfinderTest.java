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
    public void testPathfinderZero() {
        checkPath(getPathfinder(), getConfiguration().getCases().get(0));
    }

    @Test
    public void testPathfinderOne() {
        checkPath(getPathfinder(), getConfiguration().getCases().get(1));
    }

    @Test
    public void testPathfinderTwo() {
        checkPath(getPathfinder(), getConfiguration().getCases().get(2));
    }

    @Test
    public void testPathfinderThree() {
        checkPath(getPathfinder(), getConfiguration().getCases().get(3));
    }


    protected <T extends Node> void checkPath(final Pathfinder pathfinder, TestCase testCase) {
        final Path result = pathfinder.findPath(testCase.getStart(), testCase.getEnd(), getConfiguration().getNodes(), getConfiguration().getHeuristic());
        Assert.assertEquals(testCase.getExpectedPath(), result.toString());
    }

}
