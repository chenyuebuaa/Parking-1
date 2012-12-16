package main;

public class Ticket {
	private int ticket_id;
	private int carpark_id;
	
	public Ticket(int i,int j)
	{
		this.ticket_id = i;
		this.carpark_id = j;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public int getCarpark_id() {
		return carpark_id;
	}
	public void setCarpark_id(int carpark_id) {
		this.carpark_id = carpark_id;
	}

}
