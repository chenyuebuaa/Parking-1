package test;

import main.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkManagerTest {
	private Car car;
	private String id ="A";
    private ParkingManager pm;
	private ParkingLot cp,cp1,cp2;
	private ParkingBoy parkingboy1, parkingboy2;
	private ParkingStrategy ps;
    @Before
    public void init()
    {
        car = new Car(id);
        cp = new ParkingLot(20);
        cp1 = new ParkingLot(30);
        cp2 = new ParkingLot(40);
        ps = new ParkingOnFirst();
        parkingboy1 = new ParkingBoy(ps);
        ps = new ParkingOnSmart();
        parkingboy2 = new ParkingBoy(ps);
        parkingboy1.add(cp);
        parkingboy2.add(cp1);
        pm = new ParkingManager();
        pm.add(parkingboy1);
        pm.add(parkingboy2);
        pm.add(cp2);
        ParkingLot.numberofcarpark=1;
        ParkingBoy.numberofparkingboy=1;
    }
	@Test
    public void test_pm_ask_parkingboy_stopcar()
    {
        pm.ask(parkingboy1).stopCar(car);
        Assert.assertEquals(19,parkingboy1.getEmptySpace());
    }
    @Test (expected = NoPlaceException.class)
    public void test_pm_ask_parkingboy_stopcar_cp_full()
    {
        cp.setEmptySpace(0);
        pm.ask(parkingboy1).stopCar(car);
    }
    @Test
	public void test_pm_stopcar_himself()
	{
		pm.stopCar(car);
		Assert.assertEquals(89, pm.getEmptySpace());
	}
    @Test (expected = NoPlaceException.class)
    public void test_pm_stopcar_all_full_himself()
    {
        cp.setEmptySpace(0);
        cp1.setEmptySpace(0);
        cp2.setEmptySpace(0);
        pm.stopCar(car);
    }
	@Test
    public void test_pm_getcar()
    {
        Ticket t1=pm.stopCar(car);
        int emptynum=pm.getEmptySpace();
        pm.getCar(t1);
        Assert.assertEquals(emptynum+1,pm.getEmptySpace());
    }
    @Test(expected = NoCarException.class)
    public void test_pm_getcar_nocar()
    {
        Ticket t1=new Ticket(1,1);
        pm.getCar(t1);
    }

}
