package com.olympic.cis143.m08.student.bikeshop;

import java.util.UUID;



public class RepairImpl
{
	//Set prices for repairs here.
    public enum Repairs {
        CHAIN (30.00,2),
        FLAT (10.00, 1),
        BRAKES (35.00, 2),
        BATTERY (75.00, 3);
    	
    	private final double price;
    	private final int time;  //in hours

		Repairs(double price, int time)
		{
			this.price = price;
			this.time = time;
		}

		public double getPrice()
		{
			return price;
		}

		public int getTime()
		{
			return time;
		}		
    }

    private Repairs repairs;
    public final UUID orderNumber = UUID.randomUUID();
    
    public RepairImpl(Repairs repairs) 
    {
        	this.repairs = repairs;
    }

    public boolean equals(RepairImpl repair) 
    {
        return this.orderNumber.equals(repair.orderNumber);
    }
}
