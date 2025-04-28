package com;

import java.util.Scanner;

public class Bus {
	private String busid;
	private String busname;
	private String route;
	private int seatcapcity;
	private int availableseats;
	
	
	
	public Bus(String busname,String route, int seatcapacity)
	{
		if(busname==null || busname.length() <=5)
		{
			throw new IllegalArgumentException("Busname length should be greater than 5 characters ");
		}
		if(route==null || route.isEmpty())
		{
			throw new IllegalArgumentException(" route should not be empty");
		}
		if(seatcapacity<10)
		{
			 throw new IllegalArgumentException("seats should be greater than 10");
		}
		this.busname=busname;
		this.route=route;
	    this.seatcapcity=seatcapacity;
		this.availableseats=seatcapacity;
		this.busid=getBusId(busname);
	}
	
//	
	public static String getBusId(String busname)
	{
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter the Busname ");
		String bname=busname.toUpperCase();
		String str=bname.substring(0,3);
		String str1=bname.substring(bname.length()-3,bname.length());
		String str2="";
//		System.out.println(str1);
		for(int i=0;i<=str1.length()-1;i++)
		{
			char ch=str1.charAt(i);
			int n=(int)ch;
			str2=str2+n%10;
			
		}
		 return str+""+str2;
	}
	
	public void boookSeat() throws SeatunavilableException
	{
		if(availableseats <= 0)
		{
			throw new SeatunavilableException(" seats are not avilable");
			
		}
		else
		{
			availableseats--;
		}
	}
	public void cancelSeat()
	{
		if((availableseats)<( seatcapcity))
		{
			availableseats++;
		}
	}
	public String getBusDetails()
	{
		return " BUSID:"+busid+ ",BUSName:"+busname+",ROUTE:"+route+","
				+ "SEATCAPACITY:"+seatcapcity+",AVILABLESEAT:"+availableseats;
				
	}

	public String getBusid() {
		return busid;
	}

	public void setBusid(String busid) {
		this.busid = busid;
	}

	public int getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}
	

	



	

}