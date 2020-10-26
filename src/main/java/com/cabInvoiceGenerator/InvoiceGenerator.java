package com.cabInvoiceGenerator;

public class InvoiceGenerator {
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final double MINIMUM_FARE = 5;

	/**
	 * UseCase 1 : returns total fare for given distance and time
	 * 
	 * @param distance
	 * @param time
	 * @return
	 */
	public double calculateFare(double distance, int time) {
		double totalfare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		if (totalfare < MINIMUM_FARE) {
			return MINIMUM_FARE;
		}
		return totalfare;
	}
	
	/**
	 * UseCase 2 and 3 : calculates total fare of multiple rides and returning the invoice
	 * 
	 * @param rides
	 * @return
	 */
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		InvoiceSummary invoiceSummary = new InvoiceSummary(rides.length, totalFare);
		return invoiceSummary;
	}
}	