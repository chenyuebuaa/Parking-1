package main;
import java.util.List;


public class ParkingOnFirst implements ParkingStrategy{
	
	@Override
	public ParkingLot findCarPark(List<Component> parklist) {
		// TODO Auto-generated method stub
		for(int i=0;i<parklist.size();i++)
		{
			if(parklist.get(i).getEmptySpace()!=0)
			{
				
				return (ParkingLot) parklist.get(i);
			}			
		}
		return null;	
}
	
	
}
