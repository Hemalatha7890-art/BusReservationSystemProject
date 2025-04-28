package com;

public class Passenger {
	private String passengerid;
	private String passengername;
	private long mobilenumber;
	private static String ticketstatus;//booked,cancelled,waitinglist
	public Passenger(String passengername,long mobilenumber,String ticketstatus)
	{
		if(mobilenumber >6000000000l && mobilenumber<90000000000l)
		{
	          this.mobilenumber=mobilenumber;
	     }
		else
		{
			throw new IllegalArgumentException("Mobile number should be greater than 10 digits and starts with 6/7/8/9");
		}
		if(passengername.matches("[a-zA-z]{3,50}"))
		{
			this.passengername=passengername;
		}
		else
		{
			throw new IllegalArgumentException("Enter name in the form of characters only");
		}
		  this.ticketstatus=ticketstatus;
		  this.passengerid=getpassengerId(passengername);
		  
		
	}
	public  static String getpassengerId(String passengername)
	{
		String str=passengername.substring(0,3).toUpperCase();
		String str1=passengername.substring(passengername.length()-4,passengername.length());
		String str2= "";
		for(int i=0;i<=str1.length()-1;i++)
		{
			char ch=str1.charAt(i);
			int n=(int)ch;
			 str2=str2+(n%10);
			 
		}
		return str+""+str2;
		
	}
	 public  String getPassengerDetails()
	 {
		 return "  PassengerName:"+passengername+",PassengerId: "+passengerid+", MObilenum: "
	 +mobilenumber+", ticketstatus: "+ticketstatus;
	 }
	 @Override
	 public String toString() {
	     return "Passenger Name: " + passengername +
	            ", Passenger ID: " + passengerid +
	            ", Mobile Number: " + mobilenumber +
	            ", Ticket Status: " + ticketstatus;
	 }

	public String getPassengerid() {
		return passengerid;
	}
	
	public String getTicketstatus() {
		return ticketstatus;
	}
	public  void setTicketstatus(String ticketstatus) {
		this.ticketstatus = ticketstatus;
	}
	 


}
