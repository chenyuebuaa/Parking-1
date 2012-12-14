package test;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;
import main.Car;
import main.CarPark;
import main.NoPlaceException;
import main.ParkingBoy;
import main.ParkingManager;
import main.ParkingOnFirst;
import main.ParkingOnSmart;
import main.ParkingOnSuperSmart;
import main.ParkingStrategy;

public class ParkManagerTest extends TestCase{
	private CarPark cp;
	private CarPark cp1;
	private CarPark cp2;
	private Car car;
	private String id ="A";
	private ParkingBoy parkingboy;
	private ParkingBoy sparkingboy;
	private ParkingStrategy ps;
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		car = new Car(id);
		cp = new CarPark(100);
		cp1 = new CarPark(500);
		cp2 = new CarPark(100);
		ps = new ParkingOnFirst();
		parkingboy = new ParkingBoy(ps);
		ps = new ParkingOnSmart();
		sparkingboy = new ParkingBoy(ps);
		parkingboy.addCarPark(cp);
		sparkingboy.addCarPark(cp1);
	}
	@Test 
	public void test_stopcar_pm()
	{
		ParkingManager pm = new ParkingManager();
		pm.addPerson(parkingboy);
		pm.addPerson(sparkingboy);
		pm.addPlace(cp2);
		pm.stop1(car);
		Assert.assertEquals(pm.getTotalnumber()-1, pm.getEmptySpace());
	}
	@Test 
	public void test_stopcar_pm_parkboy()
	{
		ParkingManager pm = new ParkingManager();
		pm.addPerson(parkingboy);
		pm.addPerson(sparkingboy);
		pm.addPlace(cp2);
		pm.stop2(car);
		Assert.assertEquals(pm.getTotalnumber()-1, pm.getEmptySpace());
	}
	@Test (expected = NoPlaceException.class)
	public void test_stopcar_pm_noplace()
	{
		ParkingManager pm = new ParkingManager();
		cp1.setEmptyspace(0);
		cp.setEmptyspace(0);
		cp2.setEmptyspace(0);
		pm.addPerson(parkingboy);
		pm.addPerson(sparkingboy);
		pm.addPlace(cp2);
		pm.stop2(car);
		pm.stop1(car);
		Assert.assertEquals(0,pm.getEmptySpace());
		
	}

}
