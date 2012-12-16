package main;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot extends Component{
	private  int   totalnumber;	//��ͣ��λ��
	private int emptyspace;	//����ͣ��λ��
	private Map<Ticket,Car>  car_ticket_list= new HashMap<Ticket, Car>();	
	protected int name;//ͣ���������֣���ţ�
	public static int numberofcarpark=1;
	
	public ParkingLot(int totalnumber) {
		this.emptyspace = totalnumber;
		this.totalnumber = totalnumber;
		this.name = ParkingLot.numberofcarpark;
		ParkingLot.numberofcarpark++;
	}
	@Override
	public Ticket stopCar(Car car) throws NoPlaceException
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
	@Override
	public void diplay(int depth) {
		// TODO Auto-generated method stub
		String str="";
		for(int j=0;j<depth;j++)
		{
			str+=" ";
		}
		System.out.println(str+"ͣ������ţ�"+this.name);
		System.out.println(str+"    ��λ����"+this.getTotalnumber());
		System.out.println(str+"    ��λ����"+this.getEmptySpace());
	}
	@Override
	public int getTotalnumber() {
		// TODO Auto-generated method stub
		return totalnumber;
	}
	@Override
	public int getEmptySpace() {
		// TODO Auto-generated method stub
		return emptyspace;
	}	
	public void setEmptySpace(int emptyspace)
	{
		this.emptyspace = emptyspace;
	}	
}
 
