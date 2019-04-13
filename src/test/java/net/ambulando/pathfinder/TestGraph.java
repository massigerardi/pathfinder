package net.ambulando.pathfinder;

import lombok.Getter;
import net.ambulando.pathfinder.graph.Graph;
import net.ambulando.pathfinder.graph.GraphHeuristic;
import net.ambulando.pathfinder.graph.Vertex;
import net.ambulando.pathfinder.heuristic.Heuristic;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Getter
public class TestGraph implements TestConfiguration {

  private Graph nodes = new Graph();

  private Heuristic<Vertex> heuristic = new GraphHeuristic();

  private List<TestCase> cases = newArrayList();

  /*
        d   i
        |
    a - b - c - f - h
        |   |
        g --+
        |
        e
   */

  public TestGraph() {
    Vertex A = new Vertex("a");
    Vertex B = new Vertex("b");
    Vertex C = new Vertex("c");
    Vertex D = new Vertex("d");
    Vertex E = new Vertex("e");
    Vertex F = new Vertex("f");
    Vertex G = new Vertex("g");
    Vertex H = new Vertex("h");
    Vertex I = new Vertex("i");
    nodes.add(I);
    nodes.addEdge(A, B);
    nodes.addEdge(B, C);
    nodes.addEdge(B, G);
    nodes.addEdge(B, D);
    nodes.addEdge(C, F);
    nodes.addEdge(C, G);
    nodes.addEdge(E, G);
    nodes.addEdge(F, H);
    cases.add(TestCase.builder().start(A).end(B).expectedPath("[ab]").build());
    cases.add(TestCase.builder().start(A).end(C).expectedPath("[abc]").build());
    cases.add(TestCase.builder().start(A).end(I).expectedPath("[]").build());
    cases.add(TestCase.builder().start(A).end(H).expectedPath("[abcfh]").build());
  }

}
