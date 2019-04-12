package net.ambulando.pathfinder.heuristic;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Massimiliano Gerardi
 *
 */
@Getter
@NoArgsConstructor
public class ChebyshevHeuristic extends DiagonalHeuristic {

    /**
     * the minimum cost.
     */
    private final double linearCost = 1d;

    /**
     * the minimum cost.
     */
    private final double diagonalCost = 1d;

}
