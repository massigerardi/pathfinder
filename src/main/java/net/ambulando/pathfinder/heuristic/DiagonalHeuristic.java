package net.ambulando.pathfinder.heuristic;

import lombok.ToString;
import net.ambulando.pathfinder.grid.GridNode;

/**
 * @author massi
 *
 */
@ToString(includeFieldNames=false)
public abstract class DiagonalHeuristic implements Heuristic<GridNode> {

    /* (non-Javadoc)
     * @see net.ambulando.pathfinder.heuristic.Heuristic#calculateDistance(net.ambulando.pathfinder.nodes.Node, net.ambulando.pathfinder.nodes.Node)
     */
    public Double calculateDistance(final GridNode start, final GridNode end) {
        final double dx = Math.abs(end.getX() - start.getX());
        final double dy = Math.abs(end.getY() - start.getY());
        return getLinearCost() * (dx + dy) + (getDiagonalCost() - 2*getLinearCost())*Math.min(dx, dy);
    }

    protected abstract double getDiagonalCost();

    protected abstract double getLinearCost();

}
