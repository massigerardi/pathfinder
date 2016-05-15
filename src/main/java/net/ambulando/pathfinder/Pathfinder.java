/**
 * 
 */
package net.ambulando.pathfinder;

import net.ambulando.pathfinder.nodes.Node;

/**
 * @author massi
 *
 */
public interface Pathfinder<T extends Node> {

    Path findPath(T start, T end);

}