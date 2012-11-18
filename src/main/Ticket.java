package main;

public class Ticket {
	private Car car;
	private int ticket_id;
	
	public Ticket(Car c ,int i)
	{
		this.car = c;
		this.ticket_id = i;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
	

}
