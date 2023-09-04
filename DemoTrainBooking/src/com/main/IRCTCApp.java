package com.main;

import java.util.Set;

import com.dao.DAOPassenger;
import com.dao.DAOPassengerImpl;
import com.exception.IRCTCException;
import com.model.Passenger;

public class IRCTCApp {

	public static void main(String[] args) {

		Passenger passenger = new Passenger(10, "KARTHI",25);
		Passenger passenger2 = new Passenger(30, "HARSHA", 25);
		DAOPassenger daoPassenger = new DAOPassengerImpl();
		try {
			Passenger dbPassenger = daoPassenger.createPassenger(passenger);
			daoPassenger.createPassenger(passenger2);
			if (dbPassenger != null) {
				System.out.println(dbPassenger.getPnrNo());
				System.out.println(dbPassenger.getpName());  
				System.out.println(dbPassenger.getpAge());

			}

		} catch (IRCTCException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			Passenger readfn = daoPassenger.readPassengerPnrNo(10);
			System.out.println(readfn.getPnrNo() + "Passenger Found with Provided PNR Number");
		} catch (IRCTCException e) {
			System.err.println(e.getMessage());
			
		}
		
		System.out.println("Display the chart");
		Set<Passenger> chartPassengerSet = daoPassenger.passengerChart();
		System.out.println("Total Passengers:  " + chartPassengerSet.size());
		for (Passenger passengerItr : chartPassengerSet) {
			System.out.println("PNR No: " + passengerItr.getPnrNo());
			System.out.println("NAME: " + passengerItr.getpName());

		}
		try {
			passenger2 = new Passenger(30, "HARSHA", 35);
			Passenger updatefn= daoPassenger.updatePassenger(passenger2);
			System.out.println(updatefn.getpAge() + " "+ "Age has been Updated Successfully" );
		} catch (IRCTCException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			Passenger deleteFn = daoPassenger.deletePassengerPnrNo(30);
			System.out.println(deleteFn.getpName()+ "has been deleted");
		} catch (IRCTCException e) {
			System.err.println(e.getMessage());
		}
		
		

	}

}
