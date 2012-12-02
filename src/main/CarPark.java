package main;
import java.util.HashMap;
import java.util.Map;

public class CarPark {
	private  int   totalnumber;	
	private int emptyspace;	
	private int[] flag_carpark;
	private Map<Ticket,Car>  car_ticket_list= new HashMap<Ticket, Car>();	
	private int name;
	
	public CarPark(int totalnumber) {
		super();
		this.emptyspace = totalnumber;
		this.totalnumber = totalnumber;
		this.flag_carpark = new int[totalnumber];
	}
	public int getEmptySpace() {
		return this.emptyspace;
	}	
	private Ticket generateTicket(int i) {
		Ticket tk = new Ticket(i,this.name);
		return tk;
	}	
	public Ticket stopCarMap(Car car)
	{ 
		Ticket t = null;
		if(this.emptyspace==0)
		return null;
		else{
			for(int i=0;i<totalnumber;i++)
				if(this.flag_carpark[i]==0){
					t = generateTicket(i);
					car_ticket_list.put(t, car);
					this.flag_carpark[i]=1;
					break;
				}					
			this.emptyspace--;
			return t;
		} 		
	}
	public Car getCarInstanceByTicket(Ticket t)
	{
		if(car_ticket_list.containsKey(t))
		return car_ticket_list.get(t);
		return null;
	}
	public Car getCarMap(Ticket t)
	{
		if(car_ticket_list.containsKey(t))
		{ 
			Car car = car_ticket_list.get(t);
			this.emptyspace++;
			this.flag_carpark[t.getTicket_id()]=0;
			car_ticket_list.remove(t);
			return car;
		}		
		return null;
	}
	public int getTotalnumber() {
		return totalnumber;
	}
	public boolean isCarInMap(Car car)
	{
		if(car_ticket_list.containsValue(car))
			return true;
		else 
			return false;
	}	
	public void setEmptyspace(int emptyspace) {
		this.emptyspace = emptyspace;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
}
 
