package com.olympic.cis143.m08.student.bikeshop;

import java.util.UUID;

public class RoadBikeImpl extends Bike
{
	private static final int DEFAULTTIRE = 32;
	private boolean isCustom;
	private int tireSize;
	public final UUID orderNumber = UUID.randomUUID();
	
	public RoadBikeImpl(int gears, String brakes, double price, int tireSize, boolean isCustom)
	{
		super(gears, brakes, price);
		this.isCustom = isCustom;
		this.tireSize = isCustom ? tireSize : DEFAULTTIRE;
	}
	
	public int getTireSize()
	{
		return tireSize;
	}

	public boolean equals(RoadBikeImpl bikeOrder) {
        return this.orderNumber.equals(bikeOrder.orderNumber);
    }
}
