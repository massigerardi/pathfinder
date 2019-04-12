package net.ambulando.pathfinder.heuristic;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Massimiliano Gerardi
 *
 */
@Getter
@NoArgsConstructor
public class OctileHeuristic extends DiagonalHeuristic {

    /**
     * the minimum cost.
     */
    private final double linearCost = 1d;

    /**
     * the minimum cost.
     */
    private final double diagonalCost = Math.sqrt(2);

}
