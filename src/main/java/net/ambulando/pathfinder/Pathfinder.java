package net.ambulando.pathfinder;

import net.ambulando.pathfinder.heuristic.Heuristic;
import net.ambulando.pathfinder.nodes.Node;
import net.ambulando.pathfinder.nodes.Nodes;

/**
 * @author massi
 *
 */
public interface Pathfinder<T extends Node> {

    Path findPath(T start, T end, Nodes<T> nodes, Heuristic<T> heuristic);

    String getName();

}