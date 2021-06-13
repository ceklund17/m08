package com.olympic.cis143.m08.student.bikeshop;

/* M02 Interfaces. This interface is used to repair bikes so it can be reused in other classes should someone want to reuse these methods with different business logic*/

public interface Repair
{
	//Add repair order to queue
	public void createOrder(RepairImpl repair);
	
	//Check if more repairs remain True if yes
    public boolean moreRepairs();
    
    //Remove repair from front of queue
    public RepairImpl finishRepair();
    
    //Count repairs in queue
    public int howManyRepairs();

}
