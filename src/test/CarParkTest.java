package test;


import junit.framework.TestCase;

import main.Car;
import main.ParkingLot;
import main.NoCarException;
import main.NoPlaceException;
import main.Ticket;

import org.junit.Assert;
import org.junit.Test;

public class CarParkTest extends TestCase {

	private ParkingLot cp;
	private Car car;
	private String id ="A";
	private Ticket testt;
	 
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		cp = new ParkingLot(20);
		car = new Car(id);
	}
	@Test
	public void test_stop_car() {
		Ticket t = cp.stopCar(car);
		Assert.assertEquals("A",cp.getCar(t).getCar_id() );
		
	}
	@Test
	public void test_get_car(){
		Ticket t = cp.stopCar(car);
		Assert.assertEquals(car, cp.getCar(t));
		Assert.assertEquals(20, cp.getEmptySpace());		
	}
	@Test (expected = NoPlaceException.class)
	public void test_stop_when_full() {
		cp.setEmptySpace(0);
		cp.stopCar(car);
	}
	
	@Test (expected = NoCarException.class)
	public void test_get_when_empty() {	
		cp.setEmptySpace(300);
		 cp.getCar(testt);
	}
}
