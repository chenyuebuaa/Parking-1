package main;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends Component{
	private int totalnumber;	//总停车位数
	private int emptyspace;	//空余停车位数
	protected int name;//
	protected List<Component> park_list= new ArrayList<Component>(); 	
	
	public void add(Component a) {
		// TODO Auto-generated method stub
		this.park_list.add(a);
	}
	@Override
	public Ticket stopCar(Car car) {
		// TODO Auto-generated method stub		
		Ticket t1 = this.park_list.get(2).stopCar(car);
		return t1;	/////////////////	
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
			str+=" ";
		}
		for(int i=0;i<this.park_list.size();i++)
		{
			this.park_list.get(i).diplay(depth);
		}
		 System.out.println(str+"Total: 车位数"+this.getTotalnumber());
		 System.out.println(str+"Total: 空位数"+this.getEmptySpace());
	}
	
	public void remove(Component a) {
		// TODO Auto-generated method stub
		this.park_list.remove(a);
	}
	@Override
	public Car getCar(Ticket t) {
		// TODO Auto-generated method stub
		return null;
	}
}
