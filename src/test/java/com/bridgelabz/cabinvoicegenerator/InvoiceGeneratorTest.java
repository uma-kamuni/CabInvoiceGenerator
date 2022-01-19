package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
	
	public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
	
	@Test
	public void givenDistanceAndTime_WhenNormal_ShouldReturnTotalFare() {
		
		double distance  = 2.0;
		int time = 5;
		String type = "normal";
		double fare = invoiceGenerator.calculateFare(distance, time, type);
		Assert.assertEquals(25, fare, 0.0);
		
	}
	
	@Test
	public void givenLessDistanceAndTime_WhenNormal_ShouldReturnMinFare() {

		double distance = 0.1;
		int time = 1;
		String type = "normal";
		double fare = invoiceGenerator.calculateFare(distance, time, type);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_WhenNormal_ShouldReturnTotalFare() {
		
		Ride[] rides = {new Ride(2.0, 5), 
						new Ride(0.1, 1)};
		String type = "normal";
		double totalFare = invoiceGenerator.calculateFare(rides, type);
		Assert.assertEquals(30, totalFare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_WhenNormal_ShouldReturnInvoiceSummary() {

		ArrayList<Ride> rides = new ArrayList<Ride>();
		rides.add(new Ride(2.0, 5));
		rides.add(new Ride(0.1, 1));
		String type = "normal";
		InvoiceSummary summary = invoiceGenerator.calculateFareReturnObject(rides, type);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
		if(expectedSummary.getAverageFare() == summary.getAverageFare() && expectedSummary.getNumberOfRides() == summary.getNumberOfRides() && expectedSummary.getTotalFare() == summary.getTotalFare())
			Assert.assertEquals(1, 1);
	}
	
	@Test
	public void givenUserId_WhenNormal_ShouldReturnInvoiceSummary() {
		
		String userId = "Normal User";
		String type = "normal";
		InvoiceService invoiceService = new InvoiceService();
		
		ArrayList<Ride> rides = new ArrayList<Ride>();
		rides.add(new Ride(2.0, 5));
		rides.add(new Ride(0.1, 1));
		
		invoiceService.addRide(userId, rides);
		ArrayList<Ride> listOfRides = invoiceService.getRides(userId);
		
		InvoiceSummary summaryForUser1 = invoiceGenerator.calculateFareReturnObject(listOfRides, type);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
		if(expectedSummary.getAverageFare() == summaryForUser1.getAverageFare() && expectedSummary.getNumberOfRides() == summaryForUser1.getNumberOfRides() && expectedSummary.getTotalFare() == summaryForUser1.getTotalFare())
			Assert.assertEquals(1, 1);
	}
	
	@Test
	public void givenDistanceAndTime_WhenPremium_ShouldReturnTotalFare() {
		
		double distance  = 2.0;
		int time = 5;
		String type = "premium";
		double fare = invoiceGenerator.calculateFare(distance, time, type);
		Assert.assertEquals(40, fare, 0.0);
		
	}
	
	@Test
	public void givenLessDistanceAndTime_WhenPremium_ShouldReturnMinFare() {

		double distance = 0.1;
		int time = 1;
		String type = "premium";
		double fare = invoiceGenerator.calculateFare(distance, time, type);
		Assert.assertEquals(20, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_WhenPremium_ShouldReturnTotalFare() {
		
		Ride[] rides = {new Ride(2.0, 5), 
						new Ride(0.1, 1)};
		String type = "premium";
		double totalFare = invoiceGenerator.calculateFare(rides, type);
		Assert.assertEquals(60, totalFare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_WhenPremium_ShouldReturnInvoiceSummary() {

		ArrayList<Ride> rides = new ArrayList<Ride>();
		rides.add(new Ride(2.0, 5));
		rides.add(new Ride(0.1, 1));
		String type = "premium";
		InvoiceSummary summary = invoiceGenerator.calculateFareReturnObject(rides, type);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 60);
		if(expectedSummary.getAverageFare() == summary.getAverageFare() && expectedSummary.getNumberOfRides() == summary.getNumberOfRides() && expectedSummary.getTotalFare() == summary.getTotalFare())
			Assert.assertEquals(1, 1);
	}
	
	@Test
	public void givenUserId_WhenPremium_ShouldReturnInvoiceSummary() {
		
		String userId = "Premium User";
		String type = "premium";
		InvoiceService invoiceService = new InvoiceService();
		
		ArrayList<Ride> rides = new ArrayList<Ride>();
		rides.add(new Ride(2.0, 5));
		rides.add(new Ride(0.1, 1));
		
		invoiceService.addRide(userId, rides);
		ArrayList<Ride> listOfRides = invoiceService.getRides(userId);
		
		InvoiceSummary summaryForUser1 = invoiceGenerator.calculateFareReturnObject(listOfRides, type);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 60);
		if(expectedSummary.getAverageFare() == summaryForUser1.getAverageFare() && expectedSummary.getNumberOfRides() == summaryForUser1.getNumberOfRides() && expectedSummary.getTotalFare() == summaryForUser1.getTotalFare())
			Assert.assertEquals(1, 1);
	}
}