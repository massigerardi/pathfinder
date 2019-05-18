# pathfinder

A simple implementation of main search algorithms.

it allow to test different nodes structures and heuristic algorithm.

Data structure are not immutable. 

## Dijkstra

see [Dijkstra's algorithm](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)

```
find_path(start, end, space, heuristic) {
    if (start == end) return start;
    
    space.setUniversalCost(0);
    
    visited = []
    queue = new priority_queue()
    queue.add(start)
    
    mainloop:
    while (not queue.empty) {
        current = queue.poll()
        for (neighbour in current.neighbours) {
            if (visited.contains(neighbour) continue;
            cost = current.cost + heuristic.distance(current, neighbour);
            if (neighbour.cost == 0 || cost < neighbour.cost) {
                neighbour.cost = cost;
                queue.add(neighbour);
                neighbour.previous = current;
                if (neighbour == end)) {
                    break mainloop;
                }
            }
        }
    }
    return path(start, end)
}
```


## A* 

see [A* search algorithm](https://en.wikipedia.org/wiki/A*_search_algorithm)

```
    public Path findPath(final T start, final T end, Nodes<T> nodes, Heuristic<T> heuristic) {
        List<T> visited = newArrayList();
        PriorityQueue<T> visiting = new PriorityQueue<>((n1, n2) -> Double.compare(n1.getEstimatedCost(), n2.getEstimatedCost()));
        start.setCost(0d);
        start.setEstimatedCost(heuristic.calculateDistance(start, end));

        visiting.add(start);

        while (!visiting.isEmpty()) {
            T current = visiting.poll();
            if (current == end) {
                return Path.getPath(start, end);
            }
            visited.add(current);
            for (T n : nodes.neighbours(current)) {
                if (visited.contains(n)) {
                    continue;
                }
                double cost = current.getCost()+heuristic.calculateDistance(current, n);
                if (!visiting.contains(n)) {
                    visiting.add(n);
                } else if (cost > n.getCost()) {
                    continue;
                }
                n.setPrevious(current);
                n.setCost(cost);
                n.setEstimatedCost(n.getCost() + heuristic.calculateDistance(n, end));
            }
        }

        return Path.getPath(start, end);
    }
```
