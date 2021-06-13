package com.olympic.cis143.m08.student.bikeshop;

import java.util.UUID;

public class MountainBikeImpl extends Bike
{
	private static final String DEFAULTSHOCKS = "NONE";
	private boolean isCustom;
	private String shocks;
	public final UUID orderNumber = UUID.randomUUID();
	
	public MountainBikeImpl(int gears, String brakes, double price, String shocks, boolean isCustom)
	{
		super(gears, brakes, price);
		this.isCustom = isCustom;
		this.shocks = isCustom ? shocks : DEFAULTSHOCKS;
	}
	
	public String getShocks()
	{
		return shocks;
	}
	
    public boolean equals(MountainBikeImpl bikeOrder) {
        return this.orderNumber.equals(bikeOrder.orderNumber);
    }
}
