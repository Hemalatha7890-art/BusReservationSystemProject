package com;

import java.util.ArrayList;

public class BusReservation {
	
	ArrayList<Bus>  b=new ArrayList<Bus>();
	ArrayList<Passenger> pass=new ArrayList<Passenger>();
	
	public void addBus(Bus bus)
	{
		b.add(bus);
	}
	public void addPassenger(Passenger passenger)
	{
		pass.add(passenger);
	}
	 public ArrayList<Bus> getBuses() {
	        return b;
	    }
	public void bookTicket(String passengerId,String busId) throws SeatunavilableException, InvalidBookingException
	{
		Bus bu=findBusId(busId);
		Passenger pa=findPassengerId(passengerId);
		if(bu!=null && pa!=null)
		{
			if(bu.getAvailableseats()<=0)
			{
				throw new SeatunavilableException("no seats are aavailable");
			}
			 bu.boookSeat();
			 pa.setTicketstatus("Booked");
			 
			 System.out.println("Ticket booked sucessfully");
		}
		else
		{
			throw new InvalidBookingException("bus or passenger not found");
		}
	}
	public void cancelTicket(String PassengerId) throws InvalidBookingException
	{
			Passenger p=findPassengerId(PassengerId);
		if(p==null || !"Booked".equalsIgnoreCase(p.getTicketstatus()))
		{
	
		    throw new  InvalidBookingException("Cannot cancel ticket , either passenger id does not exist or not booked");	
		}
		{
			for(Bus bus:b)
			{
				bus.cancelSeat();
				break;
			}
		}
		p.setTicketstatus("Cancelled");
	
		System.out.println("Tickete cancelled sucefuuly");
	}
	public void checkTicketSatus(String PassengerId)
	{
		Passenger p=findPassengerId(PassengerId);
		if(p!=null)
		{
			System.out.println("Ticked status for Passenger"+PassengerId+ " :" + p.getTicketstatus());
		}
		else
		{
			System.out.println("Passenger Not found");
		}
	}
	public Bus findBusId(String busId)
	{
		for( Bus bus:b)
		{
			if(bus.getBusid().equalsIgnoreCase(busId))
			{
				return bus;
			}
		}
		return null;
	}
	public Passenger findPassengerId(String PassengerId)
	{
		for(Passenger p:pass)
		{
			if(p.getPassengerid().equalsIgnoreCase(PassengerId))
			{
				return p;
			}
		}
		return null;
	}
	

}
