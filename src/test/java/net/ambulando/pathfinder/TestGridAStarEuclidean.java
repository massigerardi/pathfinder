package net.ambulando.pathfinder;

import lombok.Getter;
import net.ambulando.pathfinder.grid.Grid;
import net.ambulando.pathfinder.grid.GridNode;
import net.ambulando.pathfinder.heuristic.EuclideanHeuristic;
import net.ambulando.pathfinder.heuristic.Heuristic;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Getter
public class TestGridAStarEuclidean implements TestConfiguration {

  /*
      10 - . . . . . . . . . . .
         - . . . . . . . E . . .
       8 - . . . . . . . . . . .
         - . . . . . . . . . . .
       6 - . . . . . . E . . . .
         - . . . E E . . . . . .
       4 - . . . . . . . . . . .
         - . . . . . . . . . . .
       2 - . . . . . . . . . . .
         - . . . . . . . . . . .
       0 - S . . . . . . . . . .
           | | | | | | | | | | |
           0   2   4   6   8   10

   */
  private Grid nodes = new Grid(0,0,10,10);

  private Heuristic<GridNode> heuristic = new EuclideanHeuristic();

  private List<TestCase> cases = newArrayList();

  public TestGridAStarEuclidean() {
    cases.add(TestCase.builder().start(nodes.getNode(0, 0)).end(nodes.getNode(3, 5)).expectedPath("[(0,0)(1,1)(1,2)(1,3)(2,4)(3,5)]").build());
    cases.add(TestCase.builder().start(nodes.getNode(0, 0)).end(nodes.getNode(4, 5)).expectedPath("[(0,0)(1,1)(2,2)(2,3)(3,4)(4,5)]").build());
    cases.add(TestCase.builder().start(nodes.getNode(0, 0)).end(nodes.getNode(6, 6)).expectedPath("[(0,0)(1,1)(2,2)(3,3)(4,4)(5,5)(6,6)]").build());
    cases.add(TestCase.builder().start(nodes.getNode(0, 0)).end(nodes.getNode(7, 9)).expectedPath("[(0,0)(0,1)(0,2)(1,3)(2,4)(3,5)(4,6)(5,7)(6,8)(7,9)]").build());
  }

}
