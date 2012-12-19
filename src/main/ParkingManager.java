package main;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends Component{

    protected List<Component> park_list= new ArrayList<Component>();
    private int totalnumber;	//  车位数
	private int emptyspace;	//   空位数
	protected int name;      //  编号
	
	public void add(Component a) {
		this.park_list.add(a);
	}
	public void remove(Component a) {
		this.park_list.remove(a);
	}
	public ParkingBoy ask(ParkingBoy parkingboy) {
	    return parkingboy;
	}	
	@Override
	public Ticket stopCar(Car car) throws NoPlaceException{
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
		Car car = null;
        for(int i =0;i<this.park_list.size();i++)
        {       
        	if((car=this.park_list.get(i).getCar(t1))!=null)
        		return car;
        }
        throw new NoCarException();
	}
	@Override
	public int getTotalnumber() {
		int count = 0;
		for(int i=0;i<park_list.size();i++)
			count+=park_list.get(i).getTotalnumber();
		totalnumber = count;
		return totalnumber;
	}
	@Override
	public int getEmptySpace() {
		int count = 0;
		for(int i=0;i<park_list.size();i++)
			count+=park_list.get(i).getEmptySpace();
		emptyspace = count;
		return emptyspace;
	}	
	@Override
	public String diplay(int depth) {
		String str="";
        String hole_table="";
		for(int j=0;j<depth;j++)
			str+="\t";
		for(int i=0;i<this.park_list.size();i++)
        {
             hole_table+=this.park_list.get(i).diplay(depth+1);
        }
        hole_table+= str+"Total车位数 "+this.getTotalnumber()+"\n"+
                str+"Total空位数 "+this.getEmptySpace();
        return hole_table;
	}	
}
