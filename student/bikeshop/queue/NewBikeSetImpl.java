package com.olympic.cis143.m08.student.bikeshop.queue;

import java.util.LinkedHashSet;
import java.util.Set;

import com.olympic.cis143.m08.student.bikeshop.Bike;
import com.olympic.cis143.m08.student.bikeshop.Sale;

public class NewBikeSetImpl implements Sale
{
	
	/* M05 Sets. Using Sets to manage
	 * the queue for creating and selling bikes
	 */
	private Set<Bike> bikeSet = new LinkedHashSet<>();
	
	/*Use the checkStock private helper method once hooked up to a database to make sure
	 * inventory is available before selling. Method returns true by default for now.
	 */

	@Override
	public void createOrder(Bike bike)
	{
		if (!checkStock())
		{
			throw new RuntimeException("No more bikes of this type to sell");
		}
		this.bikeSet.add(bike);		
	}

	@Override
	public boolean moreOrders()
	{
        return !this.bikeSet.isEmpty();
	}
	
	/*M01 arrays. Need to convert the set to an array to in order to sell them on a FIFO basis */

	@Override
	public Bike sell()
	{
        Bike bike = (Bike)(this.bikeSet.toArray())[0];
        this.bikeSet.remove(bike);
        return bike;
	}

	/*M05 Annotations. @Override used because we are overriding the howOrders() method from the Sale interface*/
	
	@Override
	public int howOrders()
	{
		return this.bikeSet.size();
	}
	
	private boolean checkStock()
	{
		return true;
	}
}
