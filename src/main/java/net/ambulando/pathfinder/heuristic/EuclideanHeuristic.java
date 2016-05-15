package net.ambulando.pathfinder.heuristic;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.ambulando.pathfinder.grid.GridNode;

@ToString(includeFieldNames=false)
@AllArgsConstructor
@NoArgsConstructor
public class EuclideanHeuristic implements Heuristic<GridNode> {

    private double cost = 1d;

    public Double calculateDistance(final GridNode start, final GridNode end) {
        final double dx = end.getX() - start.getX();
        final double dy = end.getY() - start.getY();
        return  cost * Math.sqrt(dx*dx + dy*dy);
    }

}
