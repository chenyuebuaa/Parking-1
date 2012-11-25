package main;

import java.util.List;
import java.util.ArrayList;

public class ParkingManagement {

	private List<CarPark> park_list= new ArrayList<CarPark>(); 	

	public ParkingManagement() {
		// TODO Auto-generated constructor stub
	}


	public Ticket parking(Car car) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.park_list.size();i++)
		{
						if(this.park_list.get(i).getEmptySpace()!=0)
			{
				Ticket t1 = this.park_list.get(i).stopCarMap(car);
				return t1;
			}
			
			
		}
		return null;
	}
	public Ticket parkingbetter(Car car) {
		// TODO Auto-generated method stub
		int max=0;
		int b=0;
		for(int i=0;i<this.park_list.size();i++)
		{
						
			if(this.park_list.get(i).getEmptySpace()>max)
			{
				max=this.park_list.get(i).getEmptySpace();
				b=i;
			}
		}
		if(max>0)
		{
			
				Ticket t1 = this.park_list.get(b).stopCarMap(car);
				return t1;
		}
		else
		return null;
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
