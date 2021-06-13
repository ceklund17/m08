package com.olympic.cis143.m08.student.bikeshop;

import java.util.UUID;

public class ElectricBikeImpl extends Bike
{
	private static final int DEFAULTBATTERY = 500;
	private boolean isCustom;
	private int batterySize;
	public final UUID orderNumber = UUID.randomUUID();
	
	public ElectricBikeImpl(int gears, String brakes, double price, int batterySize, boolean isCustom)
	{
		super(gears, brakes, price);
		this.isCustom = isCustom;
		this.batterySize = isCustom ? batterySize : DEFAULTBATTERY;
	}

	public int getBatterySize()
	{
		return batterySize;
	}

	public boolean equals(ElectricBikeImpl bikeOrder) {
        return this.orderNumber.equals(bikeOrder.orderNumber);
    }
}
