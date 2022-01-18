package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
	
	public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
	
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		
		double distance  = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
		
	}
	
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinFare() {

		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {

		Ride[] rides = {new Ride(2.0, 5), 
						new Ride(0.1, 1)};
		double totalFare = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(30, totalFare, 0.0);
	}
}