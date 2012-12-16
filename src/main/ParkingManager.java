package main;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends Component{
	private int totalnumber;	//
	private int emptyspace;	//
	protected int name;//
	protected List<Component> park_list= new ArrayList<Component>(); 	
	
	public void add(Component a) {
		// TODO Auto-generated method stub
		this.park_list.add(a);
	}
	@Override
	public Ticket stopCar(Car car) throws NoPlaceException{
		// TODO Auto-generated method stub
        for(int i=0;i<this.park_list.size();i++)
        {
            if(this.park_list.get(i).getEmptySpace()!=0)
            {
                Ticket t1 =this.park_list.get(i).stopCar(car);
                return t1;
            }
        }
        throw new NoPlaceException();
	}	
	@Override
	public int getTotalnumber() {
		int count = 0;
		for(int i=0;i<park_list.size();i++)
		{
			count+=park_list.get(i).getTotalnumber();
		}
		totalnumber = count;
		return totalnumber;
	}
	@Override
	public int getEmptySpace() {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i=0;i<park_list.size();i++)
		{
			count+=park_list.get(i).getEmptySpace();
		}
		emptyspace = count;
		return emptyspace;
	}
	@Override
	public void diplay(int depth) {
		// TODO Auto-generated method stub
		String str="";
		for(int j=0;j<depth;j++)
		{
			str+="\t";
		}
		for(int i=0;i<this.park_list.size();i++)
		{
			this.park_list.get(i).diplay(depth);
		}
		 System.out.println(str+"Total停车位: "+this.getTotalnumber());
		 System.out.println(str+"Total空车位: "+this.getEmptySpace());
	}
	
	public void remove(Component a) {
		// TODO Auto-generated method stub
		this.park_list.remove(a);
	}
	@Override
	public Car getCar(Ticket t1) {
		// TODO Auto-generated method stub
        for(int i =0;i<this.park_list.size();i++)
        {
           return this.park_list.get(i).getCar(t1);
        }
        throw new NoCarException();
	}

    public ParkingBoy ask(ParkingBoy parkingboy) {
        //To change body of created methods use File | Settings | File Templates.
        return parkingboy;
    }


}
