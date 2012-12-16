package test;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;
import main.Component;
import main.Car;
import main.ParkingLot;
import main.NoPlaceException;
import main.ParkingBoy;
import main.ParkingManager;
import main.ParkingOnFirst;
import main.ParkingOnSmart;
import main.ParkingOnSuperSmart;
import main.ParkingStrategy;

public class ParkManagerTest extends TestCase{
	private Car car;
	private String id ="A";
	private ParkingLot cp,cp1,cp2;
	private ParkingBoy parkingboy,sparkingboy;
	private ParkingStrategy ps;
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		ParkingLot.numberofcarpark=1;
		ParkingBoy.numberofparkingboy=1;
		car = new Car(id);
		cp = new ParkingLot(0);
		cp1 = new ParkingLot(10);
		cp2 = new ParkingLot(1000);
		ps = new ParkingOnFirst();
		parkingboy = new ParkingBoy(ps);
		ps = new ParkingOnSmart();
		sparkingboy = new ParkingBoy(ps);
		parkingboy.add(cp);
		sparkingboy.add(cp1);
	}
	@Test 
	public void test_stopcar_pm()
	{
		ParkingManager pm = new ParkingManager();
		pm.add(parkingboy);
		pm.add(sparkingboy);
		pm.add(cp2);
		pm.stopCar(car);
		Assert.assertEquals(pm.getTotalnumber()-1, pm.getEmptySpace());
	}
	@Test 
	public void test_stopcar_pm_parkboy()
	{
		ParkingManager pm = new ParkingManager();
		pm.add(parkingboy);
		pm.add(sparkingboy);
		pm.add(cp2);
		pm.stopCar(car);
		Assert.assertEquals(pm.getTotalnumber()-1, pm.getEmptySpace());
	}
	@Test (expected = NoPlaceException.class)
	public void test_stopcar_pm_noplace()
	{
		ParkingManager pm = new ParkingManager();
		cp1.setEmptySpace(0);
		cp.setEmptySpace(0);
		cp2.setEmptySpace(0);
		pm.add(parkingboy);
		pm.add(sparkingboy);
		pm.add(cp2);
		pm.stopCar(car);
		Assert.assertEquals(0,pm.getEmptySpace());
		
	}

}
