package net.ambulando.pathfinder.nodes;


/**
 * @author massi
 * 
 */
public interface Node extends Comparable<Node> {

    String getName();

    double getCost();
    
    void setCost(double c);
    
    double getEstimatedCost();
    
    void setEstimatedCost(double c);
    
    void setPrevious(Node node);
    
    Node getPrevious();

}
