package com.olympic.cis143.m08.student.bikeshop.queue;

import java.util.ArrayDeque;
import java.util.Deque;

import com.olympic.cis143.m08.student.bikeshop.Repair;
import com.olympic.cis143.m08.student.bikeshop.RepairImpl;

/* M02 Queues. This uses a queue to ensure FIFO for all bike repairs */

public class RepairsQueueImpl implements Repair
{
	private Deque<RepairImpl> repairQueue = new ArrayDeque<>();
	
	@Override
	public void createOrder(RepairImpl repair)
	{
		this.repairQueue.offer(repair);
	}

	@Override
	public boolean moreRepairs()
	{
		return !this.repairQueue.isEmpty();
	}

	/* M05 Exceptions. Throw exception if no more bikes are in the queue */
	
	@Override
	public RepairImpl finishRepair()
	{
        if (!moreRepairs()) {
        	throw new RuntimeException("No more bikes to repair");
        }
        return this.repairQueue.poll();
	}

	@Override
	public int howManyRepairs()
	{
		return this.repairQueue.size();
	}

}
