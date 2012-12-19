package main;

public abstract class Component {

	protected int name;
	protected int totalnumber;
	protected int emptyspace;
	
	public abstract Ticket stopCar(Car car) throws NoPlaceException;
	public abstract Car getCar(Ticket t) throws NoCarException;
	public abstract String diplay(int depth);
    public abstract int getTotalnumber() ;
    public abstract int getEmptySpace(); 
    
}
