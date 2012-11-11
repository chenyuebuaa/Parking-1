package main;

public class Ticket {
	private String car_id;
	private int ticket_id;
	
	public Ticket(String s ,int i)
	{
		this.car_id = s;
		this.ticket_id = i;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
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
