package com.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.exception.IRCTCException;
import com.model.Passenger;

public class DAOPassengerImpl implements DAOPassenger{
	
	static Set<Passenger> passengerSet = new HashSet();
	

	@Override
	public Passenger createPassenger(Passenger passenger) throws IRCTCException {
		if(passenger.getpAge()<8) {
			throw new IRCTCException("Age Limit Was less");
		}else {
				passengerSet.add(passenger);
		}
		return passenger;
	}

	@Override
	public Passenger readPassengerPnrNo(int pnrNo) throws IRCTCException {
		Passenger dummyPassenger = null;
		for (Passenger passenger : passengerSet) {
			if (passenger.getPnrNo()== pnrNo) {
				dummyPassenger = passenger;
			}
		}
      if(dummyPassenger == null) {
    	  throw new IRCTCException (pnrNo + "Passenger NOT Found");
      }return dummyPassenger;
	}

	@Override
	public Set<Passenger> passengerChart() {		
		return passengerSet;
	}

	@Override
	public Passenger updatePassenger(Passenger passenger) throws IRCTCException {
		Passenger temporaryPassenger = null;
	for (Passenger passenger2 : passengerSet) {
		if(passenger2.getPnrNo()== passenger.getPnrNo()) {
			passenger2 = passenger;
			temporaryPassenger = passenger2;			
		}

	} if(temporaryPassenger == null) {
  	  throw new IRCTCException ( "Passenger NOT Found");
  	  }
		return temporaryPassenger;
	}

	@Override
	public Passenger deletePassengerPnrNo(int pnrNo) throws IRCTCException {
		Passenger tempPassenger = null;
		for (Passenger passenger : passengerSet) {
			if(passenger.getPnrNo()==pnrNo) {
				passengerSet.remove(passenger);
				
			}else {
				throw new IRCTCException("Passenger NOT Found");
			}
		}
		return tempPassenger;
	}

}
