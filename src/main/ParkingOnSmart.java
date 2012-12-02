package main;
import java.util.List;



public class ParkingOnSmart implements ParkingStrategy {

	@Override
	public CarPark findCarPark(List<CarPark> parklist) {
		// TODO Auto-generated method stub		
		int max=0;
		int b=0;
		for(int i=0;i<parklist.size();i++)
		{
						
			if(parklist.get(i).getEmptySpace()>max)
			{
				max=parklist.get(i).getEmptySpace();
				b=i;
			}
		}
		if(max>0)
		{		
		 return parklist.get(b);				
		}
		else
		return null;	
		} 

}
