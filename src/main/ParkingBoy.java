package main;

import java.util.List;
import java.util.ArrayList;

public class ParkingBoy  {

	protected List<CarPark> park_list= new ArrayList<CarPark>(); 
	private ParkingStrategy parkingstrategy;
	private int totalnumber;
	private int emptyspace;

	public ParkingBoy(ParkingStrategy ps) {
		// TODO Auto-generated constructor stub
		this.parkingstrategy = ps;
	}
	
	public void addCarPark(CarPark cp) {
		// TODO Auto-generated method stub
		this.park_list.add(cp);
		cp.setName(this.park_list.size());
	}
    
    public Ticket stopCar(Car car) throws NoPlaceException
    {
    	CarPark cp =parkingstrategy.findCarPark(this.park_list);
    	if(cp!=null)
    	{	Ticket t1 =cp.stopCar(car);
    		return t1;
    	}else 
    		throw new NoPlaceException();    	
    }
    
	public Car getCar(Ticket t1) throws NoCarException {
		// TODO Auto-generated method stub
		for(int i=0;i<this.park_list.size();i++)
		{
			if(t1.getCarpark_id()==park_list.get(i).getName())
				return park_list.get(i).getCar(t1);
		}
		throw new NoCarException();
	}	

	public void setParkingStrategy(ParkingStrategy ps) {
		this.parkingstrategy = ps;
	}
	
	public ParkingStrategy getParkingStrategy() {
		return parkingstrategy;
	}

	public int getTotalnumber() {
		int count = 0;
		for(int i=0;i<this.park_list.size();i++)
		{
			count+=this.park_list.get(i).getTotalnumber();
		}
		totalnumber = count;
		return totalnumber;
	}
	public int getEmptySpace() {
		int count = 0;
		for(int i=0;i<this.park_list.size();i++)
		{
			count+=this.park_list.get(i).getEmptySpace();
		}
		emptyspace = count;
		return emptyspace;
	}

	public void setEmptyspace(int emptyspace) {
		this.emptyspace = emptyspace;
	}

	public void setTotalnumber(int totalnumber) {
		this.totalnumber = totalnumber;
	}
}
