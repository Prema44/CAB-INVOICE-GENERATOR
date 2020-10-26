package com.cabInvoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepo {
	Map<String, ArrayList<Ride>> userRidesMap;

	public RideRepo() {
		userRidesMap = new HashMap<>();
	}
	
	public void addRides(String userId, Ride[] rides) {
		ArrayList<Ride> userRideList = userRidesMap.get(userId);
		if(userRideList == null)
			userRidesMap.put(userId, new ArrayList<>(Arrays.asList(rides)));
		else
			userRidesMap.get(userId).addAll(Arrays.asList(rides));
	}
	
	public Ride[] getRides(String userId) {
		return userRidesMap.get(userId).toArray(new Ride[0]);
	}
}
