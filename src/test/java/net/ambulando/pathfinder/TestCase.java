package net.ambulando.pathfinder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.ambulando.pathfinder.nodes.Node;

@Builder
@Getter
@ToString(of = {"start", "end"})
public class TestCase {

  private Node start;
  private Node end;
  private String expectedPath;

}
