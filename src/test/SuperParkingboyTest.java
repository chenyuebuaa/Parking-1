package test;

import org.junit.Assert;
import org.junit.Test;

import main.Car;
import main.ParkingLot;
import main.NoPlaceException;
import main.ParkingBoy;
import main.ParkingOnSuperSmart;
import main.ParkingStrategy;
import main.Ticket;
import junit.framework.TestCase;

public class SuperParkingboyTest extends TestCase{
	private ParkingLot cp;
	private ParkingLot cp1;
	private Car car;
	private String id ="A";
	private ParkingBoy parkingboy;
	private ParkingStrategy ps;
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		car = new Car(id);
		cp = new ParkingLot(100);
		cp1 = new ParkingLot(500);
		ps = new ParkingOnSuperSmart();
		parkingboy = new ParkingBoy(ps);
		parkingboy.add(cp);
		parkingboy.add(cp1);
		
	}
	
	@Test (expected = NoPlaceException.class)
	public void test_stop_when_two_full(){
		cp.setEmptySpace(0);
		cp1.setEmptySpace(0);
		parkingboy.stopCar(car);	
		
	}
	@Test
	public void test_stop_when_two_empty() {
		cp.setEmptySpace(99);
		parkingboy.stopCar(car);		
		Assert.assertEquals(499,cp1.getEmptySpace());
	}
	@Test
	public void test_stop_when_onefull()
	{
		cp.setEmptySpace(0);
		parkingboy.stopCar(car);
		Assert.assertEquals(499, cp1.getEmptySpace());
	}
	@Test
	public void test_stop_when_allnotfull()
	{
		cp.setEmptySpace(50);
		cp1.setEmptySpace(200);
		Ticket t = parkingboy.stopCar(car);
		Assert.assertEquals(49,cp.getEmptySpace());
	}
}
