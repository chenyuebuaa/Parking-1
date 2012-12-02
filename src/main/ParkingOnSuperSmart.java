package main;

import java.util.List;

public class ParkingOnSuperSmart implements ParkingStrategy{

	@Override
	public CarPark findCarPark(List<CarPark> parklist) {
		// TODO Auto-generated method stub
		double maxparkingrate=0;
		int b=0;
		for(int i=0;i<parklist.size();i++)
		{
						
			if(parklist.get(i).getTotalnumber()!=0)
			{
				double parkingrate = (parklist.get(i).getEmptySpace()/parklist.get(i).getTotalnumber());
				if(parkingrate>maxparkingrate){
					maxparkingrate=parkingrate;
					b=i;
				}
			}
		}
		if(maxparkingrate>0)
		{		
		 return parklist.get(b);				
		}
		else
		return null;	
}

}
