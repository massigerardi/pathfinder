package net.ambulando.pathfinder.heuristic;

import net.ambulando.pathfinder.nodes.Node;

public interface Heuristic<T extends Node> {

   Double calculateDistance(T start, T end);

}
