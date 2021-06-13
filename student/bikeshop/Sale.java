package com.olympic.cis143.m08.student.bikeshop;

/* M02 Interfaces. This interface is used to sell new bikes so it can be reused 
 * in other classes should someone want to reuse these methods with different business logic
 */

public interface Sale
{
	//Add bike order to queue
	public void createOrder(Bike bike);
	
	//Check if more bike orders remain True if yes
    public boolean moreOrders();
    
    //Remove bike order from front of queue
    public Bike sell();
    
    //Count bike orders in queue
    public int howOrders();
    
}
