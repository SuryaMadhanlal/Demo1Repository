package com.dao;

import java.util.List;
import java.util.Set;

import com.exception.IRCTCException;
import com.model.Passenger;

public interface DAOPassenger  {
	
	//CRUD
	
	public abstract Passenger createPassenger(Passenger passenger) throws IRCTCException;
	public abstract Passenger readPassengerPnrNo(int pnrNo) throws IRCTCException;
	public abstract Set<Passenger> passengerChart();
	
	public abstract Passenger updatePassenger(Passenger passenger) throws IRCTCException;
	public abstract Passenger deletePassengerPnrNo(int pnrNo) throws IRCTCException;
	
	
}
