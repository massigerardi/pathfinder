package net.ambulando.pathfinder;

import net.ambulando.pathfinder.heuristic.Heuristic;
import net.ambulando.pathfinder.nodes.Node;
import net.ambulando.pathfinder.nodes.Nodes;

import java.util.List;

public interface TestConfiguration {

  Nodes<? extends Node> getNodes();

  Heuristic<? extends Node> getHeuristic();

  List<TestCase> getCases();

}
