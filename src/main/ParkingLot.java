package main;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot extends Component{

    private Map<Ticket,Car>  car_ticket_list= new HashMap<Ticket, Car>();
	private  int   totalnumber;	               //  车位数
	private int emptyspace;	                  //      空位数
	protected int name;                        //  编号
	public static int numberofcarpark=1;    //对象计数器
	
	public ParkingLot(int totalnumber) {
		this.emptyspace = totalnumber;
		this.totalnumber = totalnumber;
		this.name = ParkingLot.numberofcarpark;
		ParkingLot.numberofcarpark++;
	}
	@Override
	public Ticket stopCar(Car car)
	{ 
		if(this.emptyspace==0)
			throw new NoPlaceException();
		else{		
			Ticket t = generateTicket(0);
			car_ticket_list.put(t, car);								
			this.emptyspace--;
			return t;
		} 		
	}	
	@Override
	public Car getCar(Ticket t)
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
	@Override
	public String diplay(int depth) {
		String str="";
        String hole_table="";
		for(int j=0;j<depth-1;j++)
		{
			str+="\t";
		}
        hole_table+=str+"停车场编号: "+this.name+"\n"+str+"\t车位数: "+this.getTotalnumber()
                +"\n"+ str+"\t空位数: "+this.getEmptySpace()+"\n";
        return hole_table;
	}
	@Override
	public int getTotalnumber() {
		return totalnumber;
	}
	@Override
	public int getEmptySpace() {
		return emptyspace;
	}	
	public void setEmptySpace(int emptyspace){
		this.emptyspace = emptyspace;
	}	
}
 
