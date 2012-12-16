package main;
import java.util.HashMap;
import java.util.Map;

public class CarPark {
	private  int   totalnumber;	//总停车位数
	private int emptyspace;	//空余停车位数
	private Map<Ticket,Car>  car_ticket_list= new HashMap<Ticket, Car>();	
	private int name;//停车场的名字（编号）
	
	public CarPark(int totalnumber) {
		super();
		this.emptyspace = totalnumber;
		this.totalnumber = totalnumber;
	}
	
	public Ticket stopCar(Car car) throws NoPlaceException
	{ 
		Ticket t = null;
		if(this.emptyspace==0)
			throw new NoPlaceException();
		else{		
			t = generateTicket(0);
			car_ticket_list.put(t, car);								
			this.emptyspace--;
			return t;
		} 		
	}	
	public Car getCar(Ticket t) throws NoCarException
	{
		if(car_ticket_list.containsKey(t))
		{ 
			Car car = car_ticket_list.get(t);
			this.emptyspace++;
			car_ticket_list.remove(t);
			return car;
		}		
		else throw new NoCarException();
	}
	private Ticket generateTicket(int i) {
		Ticket tk = new Ticket(i,this.name);
		return tk;
	}	
	public boolean isCarInMap(Car car)
	{
		if(car_ticket_list.containsValue(car))
			return true;
		else 
			return false;
	}	
	public int getTotalnumber() {
		return totalnumber;
	}
	public void setEmptyspace(int emptyspace) {
		this.emptyspace = emptyspace;
	}
	public int getEmptySpace() {
		return this.emptyspace;
	}	
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
}
 
