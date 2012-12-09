package test;

import org.junit.Assert;
import org.junit.Test;

import main.Car;
import main.CarPark;
import main.NoPlaceException;
import main.ParkingBoy;
import main.ParkingOnSuperSmart;
import main.ParkingStrategy;
import main.Ticket;
import junit.framework.TestCase;

public class SuperParkingboyTest extends TestCase{
	private CarPark cp;
	private CarPark cp1;
	private Car car;
	private String id ="A";
	private ParkingBoy parkingboy;
	private ParkingStrategy ps;
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		car = new Car(id);
		cp = new CarPark(100);
		cp1 = new CarPark(500);
		ps = new ParkingOnSuperSmart();
		parkingboy = new ParkingBoy(ps);
		parkingboy.addCarPark(cp);
		parkingboy.addCarPark(cp1);
		
	}
	
	@Test (expected = NoPlaceException.class)
	public void test_stop_when_two_full(){
		cp.setEmptyspace(0);
		cp1.setEmptyspace(0);
		parkingboy.stopCar(car);	
		
	}
	@Test
	public void test_stop_when_two_empty() {
		cp.setEmptyspace(99);
		parkingboy.stopCar(car);		
		Assert.assertEquals(499,cp1.getEmptySpace());
	}
	@Test
	public void test_stop_when_onefull()
	{
		cp.setEmptyspace(0);
		parkingboy.stopCar(car);
		Assert.assertEquals(499, cp1.getEmptySpace());
	}
	@Test
	public void test_stop_when_allnotfull()
	{
		cp.setEmptyspace(50);
		cp1.setEmptyspace(200);
		Ticket t = parkingboy.stopCar(car);
		Assert.assertEquals(t.getCarpark_id(), cp.getName());
	}
}
