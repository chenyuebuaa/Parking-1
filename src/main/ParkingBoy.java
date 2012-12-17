package main;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy extends Component {

	protected List<Component> park_list= new ArrayList<Component>();

    private ParkingStrategy parkingstrategy;
	private int totalnumber;
	private int emptyspace;
	protected int name;
	public static int numberofparkingboy=1;

	public ParkingBoy(ParkingStrategy ps) {
		// TODO Auto-generated constructor stub
		this.parkingstrategy = ps;
		this.name = ParkingBoy.numberofparkingboy;
		ParkingBoy.numberofparkingboy++;
	}
	
	public void add(Component a) {
		// TODO Auto-generated method stub
		this.park_list.add((ParkingLot)a);
		}

	public void remove(Component a) {
		// TODO Auto-generated method stub
		this.park_list.remove(a);
	}
	
    @Override
    public Ticket stopCar(Car car)  throws NoPlaceException
    {
    	ParkingLot cp =parkingstrategy.findCarPark(this.park_list);
    	if(cp!=null)
    	{	Ticket t1 =cp.stopCar(car);
    		return t1;
    	}else 
    		throw new NoPlaceException();
    }
    
    @Override
	public Car getCar(Ticket t1) throws NoCarException 
	{
		// TODO Auto-generated method stub
    	ParkingLot cp=null;
    	for(int i =0;i<this.park_list.size();i++)
    	{
    		
    		cp = (ParkingLot)park_list.get(i);
    		if(t1.getCarpark_id()==cp.name)
    		{
    			return cp.getCar(t1);
    		}
    	}
    	return null;    	
	}	

	public void setParkingStrategy(ParkingStrategy ps) 
	{
		this.parkingstrategy = ps;
	}	
    @Override
	public int getTotalnumber()
    {
		int count = 0;
		for(int i=0;i<this.park_list.size();i++)
		{
			count+=this.park_list.get(i).getTotalnumber();
		}
		totalnumber = count;
		return totalnumber;
	}    
    @Override
	public int getEmptySpace() {
		int count = 0;
		for(int i=0;i<this.park_list.size();i++)
		{
			count+=this.park_list.get(i).getEmptySpace();
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
			System.out.println(str+"停车仔编号: "+this.name);
			str+="\t";
		}
	//	System.out.println(str+"停车仔编号: "+this.name);
		for(int i=0;i<this.park_list.size();i++)
		{
			this.park_list.get(i).diplay(depth+1);
		}
	    System.out.println(str+"Total车位数: "+this.getTotalnumber());
	    System.out.println(str+"Total空位数: "+this.getEmptySpace());
	}	
}
