package main;

import java.util.ArrayList;
import java.util.List;


public class ParkingManager {
	private int totalnumber;	//总停车位数
	private int emptyspace;	//空余停车位数
	private String name;//
	private List<ParkingBoy> list = new ArrayList<ParkingBoy>();
	private List<CarPark> clist = new ArrayList<CarPark>();
	
	public void addPerson(ParkingBoy parkingboy) {
		// TODO Auto-generated method stub
		this.list.add(parkingboy);
	}
	public void addPlace(CarPark cp) {
		// TODO Auto-generated method stub
		this.clist.add(cp);
	}
	public Ticket stop1(Car car) {
		// TODO Auto-generated method stub
		Ticket t1 = this.clist.get(0).stopCar(car);
		return t1;
		
	}
	public Ticket stop2(Car car)
	{
		Ticket t1 = this.list.get(0).stopCar(car);
		return t1;
	}
	public int getTotalnumber() {
		int count = 0;
		for(int i=0;i<list.size();i++)
		{
			count+=list.get(i).getTotalnumber();
		}
		for(int i=0;i<this.clist.size();i++)
		{
			count+=clist.get(i).getTotalnumber();
		}
		totalnumber = count;
		return totalnumber;
	}
	public void setTotalnumber(int totalnumber) {
		this.totalnumber = totalnumber;
	}
	public void setEmptySpace(int emptyspace) {
		this.emptyspace = emptyspace;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmptySpace() {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i=0;i<list.size();i++)
		{
			count+=list.get(i).getEmptySpace();
		}
		for(int i=0;i<this.clist.size();i++)
		{
			count+=clist.get(i).getEmptySpace();
		}
		emptyspace = count;
		return emptyspace;
	}
	

}
