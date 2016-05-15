package net.ambulando.pathfinder.grid;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.ambulando.pathfinder.nodes.Nodes;

@Getter
@ToString(includeFieldNames=false)
public class Grid extends Nodes<GridNode> {

    @NonNull
    Integer x0, y0;
    @NonNull
    Integer x1, y1;
    
    public Grid(Integer x0, Integer y0, Integer x1, Integer y1) {
        super();
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        for (int x = x0; x <= x1; x++) {
            for (int y = y0; y <= y1; y++) {
                add(new GridNode(x, y));
            }
        }
    }
    
    public boolean contains(Integer x, Integer y) {
        return x >= x0 && y >= y0 && x <= x1 && y <= y1;
    }

    @Override
    public boolean contains(GridNode node) {
        return contains(node.getX(), node.getY());
    }

    @Override
    public List<GridNode> neighbours(GridNode node) {
        List<GridNode> neighbours = new ArrayList<GridNode>();
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                if (x==0 && y==0) {
                    continue;
                }
//                if (x*y!=0) {
//                    continue;
//                }
                int dx = node.getX() + x;
                int dy = node.getY() + y;
                if (this.contains(dx, dy)) {
                    GridNode n = this.getNode(dx, dy);
                    neighbours.add(n);
                }
            }
        }
        return neighbours;
    }

    public GridNode getNode(int dx, int dy) {
        return getNodes().get(dx*11+dy);
    }

}
