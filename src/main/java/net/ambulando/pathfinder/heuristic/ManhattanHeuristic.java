/**
 *
 */
package net.ambulando.pathfinder.heuristic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author massi
 *
 */
@ToString(includeFieldNames=false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ManhattanHeuristic extends DiagonalHeuristic {

    /**
     * the minimum cost.
     */
    private double linearCost = 1d;

    @Override
    protected double getDiagonalCost() {
        return 2 * linearCost;
    }

}
