package com;

import java.util.Scanner;

public class MainClass {
	 public static  void clearscreen() {
		for(int i=0;i<50;i++)
		{
			System.out.println();
		}

	 }
	public static void main(String[] args) throws SeatunavilableException, InvalidBookingException {
		BusReservation busreservation=new BusReservation();
		Scanner sc= new Scanner(System.in);
		System.out.println("=======Welcome to Bus Reservation System====");
		System.out.println("How many Buses do you want add");
		int numbus=sc.nextInt();
		sc.nextLine();
		
		for(int i=1;i<=numbus;i++)
		{
			System.out.println("Enter the details of buses: "+  i);
			System.out.println("Enter the Bus name(min 5 characters)");
			String busname=sc.nextLine();
			System.out.println("Enter the route");
			String route=sc.nextLine();
			System.out.println("Enter the seat capacity(min 10)");
			 int seatcapacity=sc.nextInt();
			 sc.nextLine();
			try
			{
				 Bus bus=new Bus(busname,route,seatcapacity);
				 busreservation.addBus(bus);
				 System.out.println("Bus Added Sucessfully");
			}
			catch (IllegalArgumentException e){
				System.out.println("Error occured" );
				i--;
				
			}
		}
	
		while(true)
		{
//			
			System.out.println("======================");
			System.out.println("Bus reservation System");
			System.out.println("======================");
			System.out.println("1.avilable buses");
			System.out.println("2.Register a passenger");
			System.out.println("3.Book Ticket");
			System.out.println("4.cancel ticket");
			System.out.println("5.check ticket status");
			System.out.println("6.exit");
			System.out.println("======================");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:System.out.println("Availabuses🚌🚌🚌");
			for(Bus bus:busreservation.getBuses())
			{
				System.out.println(bus.getBusDetails());
			}
			break;
			
					
		
			case 2:
			{
				System.out.println("Enter the passenger details");
				System.out.println("Enter the Passenger name");
				String passengername=sc.next();
				System.out.println("Enter the mobile number");
				long mobilenumber=sc.nextLong();
				Passenger p=new Passenger(passengername ,mobilenumber, "waitlist");
				busreservation.addPassenger(p);
				System.out.println("passennger registered sucessfully");
				System.out.println("Passenger id"+p.getPassengerid());
				break;
			}
			case 3:
			{
				System.out.println("Enter the passenger id");
				String passengerid=sc.next();
//				System.out.println("Passenger id"+Passenger.getPassengerid());
				System.out.println("Enter the busid");
				String busid=sc.next();
				busreservation.bookTicket(passengerid, busid);
				break;
			}
			case 4:
			{
				System.out.println("ENter the passeger id");
//				System.out.println(Passenger.getpassengerId);
				String cancelid=sc.next();
				busreservation.cancelTicket(cancelid);
				break;
			}
			case 5:
			{
				System.out.println("ENter the passenger id to check ticket status");
				String checkid=sc.next();
				busreservation.checkTicketSatus(checkid);
				break;
			}
			default:
				System.out.println("Invalid number");
		
		
		}
		
	}
}
}
	



