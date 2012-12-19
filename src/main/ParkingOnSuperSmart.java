package main;

import java.util.List;

public class ParkingOnSuperSmart implements ParkingStrategy{

	@Override
	public ParkingLot findCarPark(List<Component> parklist) {
		// TODO Auto-generated method stub
		double maxparkingrate=0;
		int b=0;
		for(int i=0;i<parklist.size();i++)
		{						
			if(parklist.get(i).getTotalnumber()!=0)
			{
				double parkingrate = ((double)parklist.get(i).getEmptySpace()/parklist.get(i).getTotalnumber());
				if(parkingrate>maxparkingrate)
				{
					maxparkingrate=parkingrate;
					b=i;
				}
			}
		}
		if(maxparkingrate>0)
		     return (ParkingLot) parklist.get(b);
		else
		    return null;
}

}
