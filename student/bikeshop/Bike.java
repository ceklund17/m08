package com.olympic.cis143.m08.student.bikeshop;

/* M06 Inheritance.
 * The Bike class is an abstract parent class for Electric, Road, and Mountain bikes.
 * You cannot create a bike object by itself it must be of one of the child types.
 */

public abstract class Bike
{

	private int gears;
	private String brakes;
	private double price;
	
	public Bike()
	{
		this(10,"Pads",500.00);
	}
	
	public Bike(int gears, String brakes, double price)
	{
		this.gears = gears;
		this.brakes = brakes;
		this.price = price;
	}
	
	public int getGears()
	{
		return gears;
	}
	
	public String getBrakes()
	{
		return brakes;
	}
	
	public double getPrice()
	{
		return price;
	}
}
