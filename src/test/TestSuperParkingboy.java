package test;

import org.junit.Assert;
import org.junit.Test;

import main.Car;
import main.CarPark;
import main.ParkingManagement;
import main.ParkingOnFirst;
import main.ParkingOnSmart;
import main.ParkingOnSuperSmart;
import main.ParkingStrategy;
import main.Ticket;
import junit.framework.TestCase;

public class TestSuperParkingboy extends TestCase{
	private CarPark cp;
	private CarPark cp1;
	private Car car;
	private String id ="A";
	private Ticket testt;
	private ParkingManagement parkingboy;
	private ParkingStrategy ps;
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		cp = new CarPark(100);
		car = new Car(id);
		cp1 = new CarPark(500);
		ps = new ParkingOnSuperSmart();
		parkingboy = new ParkingManagement(ps);
		parkingboy.addCarPark(cp);
		parkingboy.addCarPark(cp1);
		
	}
	
	@Test
	public void test_stop_when_two_full(){
		cp.setEmptyspace(0);
		cp1.setEmptyspace(0);
		Assert.assertEquals(null, parkingboy.parking(car));	
		
	}
	@Test
	public void test_stop_when_two_empty() {
		
		Ticket t =parkingboy.parking(car);		
		Assert.assertEquals(99,cp.getEmptySpace());
	}

	

}
