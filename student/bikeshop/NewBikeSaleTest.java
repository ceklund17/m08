package com.olympic.cis143.m08.student.bikeshop;

import com.olympic.cis143.m08.student.bikeshop.queue.NewBikeSetImpl;
import com.olympic.cis143.m08.student.bikeshop.queue.RepairsQueueImpl;

public class NewBikeSaleTest
{

	public static void main(String[] args)
	{
		NewBikeSaleTest newBikeSaleTest = new NewBikeSaleTest();
		newBikeSaleTest.testHasNextSaleFalse(new NewBikeSetImpl());
		newBikeSaleTest.testCloseNextSale(new NewBikeSetImpl());
		newBikeSaleTest.testHasNextRepairFalse(new RepairsQueueImpl());
		newBikeSaleTest.testCloseNextRepair(new RepairsQueueImpl());
	}

	private void testCloseNextRepair(final Repair repairs)
	{
		RepairImpl firstRepair = new RepairImpl(RepairImpl.Repairs.BRAKES);
		RepairImpl secondRepair = new RepairImpl(RepairImpl.Repairs.CHAIN);
		
		repairs.createOrder(firstRepair);
		repairs.createOrder(secondRepair);
		
		RepairImpl shouldBeFirstRepair = repairs.finishRepair();
		if (repairs.howManyRepairs() != 1) {
			throw new RuntimeException(":( testCloseNextOrder Failed: orders should only have one order left");
		}
		if (firstRepair.equals(shouldBeFirstRepair)) {
            System.out.println(":) testCloseNextOrder passed");
        } else {
            throw new RuntimeException(":( testCloseNextOrder Failed: should be the first bike was first out.");
        }	
	}

	private void testHasNextRepairFalse(final Repair repairs)
	{
		RepairImpl firstRepair = new RepairImpl(RepairImpl.Repairs.BRAKES);
		
		repairs.createOrder(firstRepair);
        if (!repairs.moreRepairs()) {
            throw new RuntimeException(":( testHasNextFalse fail: Orders should have one order in them.");
        }
        RepairImpl repairedBike = repairs.finishRepair();
        if (repairedBike == null) {
            throw new RuntimeException(":( testHasNextFalse fail: closed taco should not be null.");
        }
        if (!repairedBike.equals(firstRepair)) {
            throw new RuntimeException(":( testHasNextFalse fail: This should truely never happen.");
        }
        if (repairs.moreRepairs()) {
            throw new RuntimeException(":( testHasNextFalse fail: Orders should be empty.");
        }
        System.out.println(":) testHasNextFalse passed");		
	}

	private void testCloseNextSale(final Sale sales)
	{
		MountainBikeImpl firstBike = new MountainBikeImpl(12, "Disc", 850.00, "Rear", true);
		MountainBikeImpl secondBike = new MountainBikeImpl(14, "Disc", 1200.00, "Rear", false);
		
		sales.createOrder(firstBike);
		sales.createOrder(secondBike);
		System.out.println(secondBike.getShocks());
		
		Bike shouldBeFirstBike = sales.sell();
		if (sales.howOrders() != 1) {
			throw new RuntimeException(":( testCloseNextOrder Failed: orders should only have one order left");
		}
		if (firstBike.equals(shouldBeFirstBike)) {
            System.out.println(":) testCloseNextOrder passed");
        } else {
            throw new RuntimeException(":( testCloseNextOrder Failed: should be the first bike was first out.");
        }
		
	}

	private void testHasNextSaleFalse(final Sale sales)
	{
		RoadBikeImpl firstBike = new RoadBikeImpl(12, "Disc", 850.00, 21, false);
		
		System.out.println(firstBike.getTireSize());

		sales.createOrder(firstBike);
        if (!sales.moreOrders()) {
            throw new RuntimeException(":( testHasNextFalse fail: Orders should have one order in them.");
        }
        Bike soldBike = sales.sell();
        if (soldBike == null) {
            throw new RuntimeException(":( testHasNextFalse fail: closed taco should not be null.");
        }
        if (!soldBike.equals(firstBike)) {
            throw new RuntimeException(":( testHasNextFalse fail: This should truely never happen.");
        }
        if (sales.moreOrders()) {
            throw new RuntimeException(":( testHasNextFalse fail: Orders should be empty.");
        }
        System.out.println(":) testHasNextFalse passed");
		
	}
	
	

}
