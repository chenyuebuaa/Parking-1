package test;

import org.junit.Before;
import org.junit.Test;

import main.Car;
import main.ParkingBoy;
import main.ParkingLot;
import main.ParkingManager;
import main.ParkingOnFirst;
import main.ParkingOnSmart;
import main.ParkingStrategy;
import main.Ticket;


public class ParkDirectTest {
	
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
        parkingboy1.add(cp1);
        parkingboy2.add(cp2);
        pm = new ParkingManager();
        pm.add(cp);
        pm.add(parkingboy1);
        pm.add(parkingboy2);
        ParkingLot.numberofcarpark=1;
        ParkingBoy.numberofparkingboy=1;		
	}
	@Test 
	public void test_pm_display()
	{
		pm.diplay(0);
	}
	@Test
	public void test_pb_display()
	{
		parkingboy1.diplay(0);
	}
	@Test
	public void test_pl_display()
	{
		cp.diplay(0);
	}
}
