package main;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy extends Component {

	protected List<Component> park_list= new ArrayList<Component>();
    private ParkingStrategy parkingstrategy;    //停车策略
	private int totalnumber;                   //车位数
	private int emptyspace;                    //空车位
	protected int name;                         //编号
	public static int numberofparkingboy=1;    //对象计数器

	public ParkingBoy(ParkingStrategy ps) {
		this.parkingstrategy = ps;
		this.name = ParkingBoy.numberofparkingboy;
		ParkingBoy.numberofparkingboy++;
	}
    public void setParkingStrategy(ParkingStrategy ps)
    {
        this.parkingstrategy = ps;
    }
    public void add(Component a) {
		this.park_list.add((ParkingLot)a);
		}

	public void remove(Component a) {
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
    	ParkingLot cp=null;
    	for(int i =0;i<this.park_list.size();i++)
    	{
    		cp = (ParkingLot)park_list.get(i);
    		if(t1.getCarpark_id()==cp.name)
    			return cp.getCar(t1);
    	}
    	return null;    	
	}
    @Override
	public int getTotalnumber()
    {
		int count = 0;
		for(int i=0;i<this.park_list.size();i++)
			count+=this.park_list.get(i).getTotalnumber();
		totalnumber = count;
		return totalnumber;
	}    
    @Override
	public int getEmptySpace() {
		int count = 0;
		for(int i=0;i<this.park_list.size();i++)
			count+=this.park_list.get(i).getEmptySpace();
		emptyspace = count;
		return emptyspace;
	}
	@Override
	public String diplay(int depth) {
		String str="";
        String hole_table="";
		for(int j=0;j<depth;j++)
		{
            hole_table+= str+"停车仔编号: "+this.name+"\n";
			str+="\t";
		}
		for(int i=0;i<this.park_list.size();i++)
		{
            hole_table+=this.park_list.get(i).diplay(depth+1);
		}
            hole_table+=str+"Total车位数: "+this.getTotalnumber()+"\n"+
                    str+"Total空位数: "+this.getEmptySpace()+"\n";
        return hole_table;
	}	
}
