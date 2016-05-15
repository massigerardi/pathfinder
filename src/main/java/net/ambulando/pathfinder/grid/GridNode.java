package net.ambulando.pathfinder.grid;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ambulando.pathfinder.nodes.ANode;

@Getter
@EqualsAndHashCode(of= {"x", "y"}, callSuper=false)
@RequiredArgsConstructor
public class GridNode extends ANode {

    @NonNull
    private final Integer x;
    @NonNull
    private final Integer y;

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
