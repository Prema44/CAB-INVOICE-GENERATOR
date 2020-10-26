package com.cabInvoiceGenerator;

public class InvoiceService {
	private RideRepo rideRepository;

	public void setRideRepository(RideRepo rideRepository) {
		this.rideRepository = rideRepository;
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
			totalFare += ride.cabRide.calcCostOfCabRide(ride);
		}
		InvoiceSummary invoiceSummary = new InvoiceSummary(rides.length, totalFare);
		return invoiceSummary;
	}	
	
	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}
	
	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}
}	