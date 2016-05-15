/**
 * 
 */
package net.ambulando.pathfinder.nodes;


/**
 * @author massi
 * 
 */
public interface Node {

    Double getCost();
    
    void setCost(Double c);
    
    Double getEstimatedCost();
    
    void setEstimatedCost(Double c);
    
    void setPrevious(Node node);
    
    Node getPrevious();

}
