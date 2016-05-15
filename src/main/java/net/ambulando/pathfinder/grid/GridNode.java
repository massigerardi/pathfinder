package net.ambulando.pathfinder.grid;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import net.ambulando.pathfinder.nodes.ANode;

@Getter
@ToString(includeFieldNames=false, of= {"x", "y"}, doNotUseGetters = true, callSuper=false)
@EqualsAndHashCode(of= {"x", "y"}, callSuper=false)
@RequiredArgsConstructor
public class GridNode extends ANode {

    @NonNull
    private Integer x;
    @NonNull
    private Integer y;

}
