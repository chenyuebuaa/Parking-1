package main;

import java.util.ArrayList;

public class CarPark {
	private final int   totalnumber=300;
	private int emptyspace;
	
	//private ArrayList <Car>  carlist = new ArrayList<Car>();
	private ArrayList <Ticket>  ticketlist = new ArrayList<Ticket>();
	private int[] flag_carpark = new int[totalnumber];
	
	public CarPark(){
		this.emptyspace=totalnumber;
	}	

	public CarPark(int emptyspace) {
		super();
		this.emptyspace = emptyspace;
	}

	public int getEmptySpace() {
		// TODO Auto-generated method stub
		return this.emptyspace;
	}

	public Ticket stopCar(Car car) {
		// TODO Auto-generated method stub
		if(this.emptyspace==0)
		return null;
		else{
			for(int i=0;i<totalnumber;i++)
				if(this.flag_carpark[i]==0){
					this.ticketlist.add(generateTicket(car,i));
					this.flag_carpark[i]=1;
					break;
				}					
			//this.carlist.add(car);////////////////////
			this.emptyspace--;
			return this.ticketlist.get(ticketlist.size()-1);
		} 
			
	}
	
	private Ticket generateTicket(Car c,int i) {
		// TODO Auto-generated method stub
		Ticket tk = new Ticket(c,i);
		return tk;
	}

	public boolean getCar(Ticket tk) {
		// TODO Auto-generated method stub
		if(this.totalnumber!=this.emptyspace)
		{
			for(int i =0;i<this.ticketlist.size();i++)
			{
				if(tk.getTicket_id() == ticketlist.get(i).getTicket_id())//没判断车号
				{
					this.ticketlist.remove(i);
					this.emptyspace++;
					this.flag_carpark[i]=0;
					return true;
				}				
			}			
		}
				return false;
	}
	public boolean getCar(Car car)
	{
		if(this.totalnumber!=this.emptyspace)
		{
			for(int i =0;i<this.ticketlist.size();i++)
			{
				if(this.ticketlist.get(i).getCar().getCar_id()==car.getCar_id())//没判断车号
				{
					this.ticketlist.remove(i);
					this.emptyspace++;
					this.flag_carpark[i]=0;
					return true;
				}				
			}			
		}		
		return false;
	}

	public Car getCarInstance(int i) {
		// TODO Auto-generated method stub
		
		return this.ticketlist.get(i).getCar();
	}
	
	public int getEmptyspace() {
		return emptyspace;
	}

	public void setEmptyspace(int emptyspace) {
		this.emptyspace = emptyspace;
	}
	public boolean isCarIn(Ticket tk){
		for(int i =0;i<this.ticketlist.size();i++){
		if(tk.getTicket_id() == ticketlist.get(i).getTicket_id())
			return true;			
		}
		return false; 
	}
	public boolean isCarIn(Car car){
		for(int i =0;i<this.ticketlist.size();i++){
		if(car.getCar_id() == ticketlist.get(i).getCar().getCar_id())
			return true;			
		}
		return false; 
	}

}
