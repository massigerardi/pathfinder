/**
 * 
 */
package net.ambulando.pathfinder.graph;

import net.ambulando.pathfinder.heuristic.Heuristic;

/**
 * @author massi
 *
 */
public class GraphHeuristic implements Heuristic<Vertex> {

    private final static Double MAX_DISTANCE = 10d;
    
    public Double calculateDistance(Vertex start, Vertex end) {        
        if (start.near(end)) {
            return 1d;
        }
        return MAX_DISTANCE;
    }

}
