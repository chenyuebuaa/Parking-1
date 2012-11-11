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

	public int getEmptySpace() {
		// TODO Auto-generated method stub
		return this.emptyspace;
	}

	public boolean stopCar(Car car) {
		// TODO Auto-generated method stub
		if(this.emptyspace==0)
		return false;
		else{
			for(int i=0;i<totalnumber;i++)
				if(this.flag_carpark[i]==0){
					this.ticketlist.add(generateTicket(car.getCar_id(),i));
					this.flag_carpark[i]=1;
					break;
				}					
			//this.carlist.add(car);////////////////////
			this.emptyspace--;
			return true;
		} 
			
	}
	
	private Ticket generateTicket(String s,int i) {
		// TODO Auto-generated method stub
		Ticket tk = new Ticket(s,i);
		return tk;
	}

	public boolean getCar(Ticket tk) {
		// TODO Auto-generated method stub
		if(this.totalnumber!=this.emptyspace)
		{
			for(int i =0;i<this.ticketlist.size();i++)
			{
				if(tk.getTicket_id() == ticketlist.get(i).getTicket_id()&&tk.getCar_id()==ticketlist.get(i).getCar_id())
				{
					this.ticketlist.remove(i);
					this.emptyspace++;
					return true;
				}				
			}			
		}
				return false;
	}

	public Car getCarInstance(int i) {
		// TODO Auto-generated method stub
		
		return this.carlist.get(i);
	}
	
	public int getEmptyspace() {
		return emptyspace;
	}

	public void setEmptyspace(int emptyspace) {
		this.emptyspace = emptyspace;
	}
	public boolean isCarIn(Ticket tk){
		for(int i =0;i<this.ticketlist.size();i++){
		if(tk.getTicket_id() == ticketlist.get(i).getTicket_id()&&tk.getCar_id()==ticketlist.get(i).getCar_id())
			return true;			
		}
		return false; 
	}

}
