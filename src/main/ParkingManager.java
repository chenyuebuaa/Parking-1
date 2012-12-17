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
	public void remove(Component a) {
		// TODO Auto-generated method stub
		this.park_list.remove(a);
	}
	public ParkingBoy ask(ParkingBoy parkingboy) {
	    //To change body of created methods use File | Settings | File Templates.
	    return parkingboy;
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
	public Car getCar(Ticket t1) {
		// TODO Auto-generated method stub
		Car car = null;
        for(int i =0;i<this.park_list.size();i++)
        {       
        	if((car=this.park_list.get(i).getCar(t1))!=null)
        	{ 		
        		return car;
        	}          	
        }
        throw new NoCarException();
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
		for(int j=0;j<depth-1;j++)
		{
			str+="\t";
		}
		for(int i=0;i<this.park_list.size();i++)
		{			this.park_list.get(i).diplay(depth+1);
		}
		 System.out.println(str+"Total车位数 "+this.getTotalnumber());
		 System.out.println(str+"Total空位数 "+this.getEmptySpace());
	}	
}
