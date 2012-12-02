package main;

import java.util.List;
import java.util.ArrayList;

public class ParkingManagement  {

	protected List<CarPark> park_list= new ArrayList<CarPark>(); 
	private ParkingStrategy ps;

	

	public void setPs(ParkingStrategy ps) {
		this.ps = ps;
	}
	
	public ParkingStrategy getPs() {
		return ps;
	}

	public ParkingManagement(ParkingStrategy ps) {
		// TODO Auto-generated constructor stub
		this.ps = ps;
	}
    
    public Ticket parking(Car car)
    {
    	CarPark cp =ps.findCarPark(this.park_list);
    	if(cp!=null)
    	{	Ticket t1 =cp.stopCarMap(car);
    		return t1;
    	}else return null;
    	
    }

	public int getsize() {
		// TODO Auto-generated method stub
		return this.park_list.size();
	}


	public void addCarPark(CarPark cp) {
		// TODO Auto-generated method stub
		this.park_list.add(cp);
		cp.setName(this.park_list.size());
	}


	public Car getCar(Ticket t1) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.park_list.size();i++)
		{
			if(t1.getCarpark_id()==park_list.get(i).getName())
				return park_list.get(i).getCarMap(t1);
		}
		return null;
	}	

}
