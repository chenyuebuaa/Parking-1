package test;

import org.junit.Assert;
import org.junit.Test;

import main.Car;
import main.ParkingLot;
import main.NoCarException;
import main.NoPlaceException;
import main.ParkingBoy;
import main.ParkingOnFirst;
import main.ParkingOnSmart;
import main.ParkingStrategy;
import main.Ticket;
import junit.framework.TestCase;


public class ParkBoyTest extends TestCase{
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
		ParkingLot.numberofcarpark=1;
		cp = new ParkingLot(20);
		car = new Car(id);
		cp1 = new ParkingLot(20);
		ps = new ParkingOnFirst();
		parkingboy = new ParkingBoy(ps);
		parkingboy.add(cp);
		parkingboy.add(cp1);
		
	}
	
	  @Test
	   public void test_parkBoy_ShouldParkCar()
	   {
		   ParkingBoy parkingboy = new ParkingBoy(ps);
		   parkingboy.add(cp);
		   parkingboy.stopCar(car);
		   Assert.assertEquals(cp.getEmptySpace(), cp.getTotalnumber()-1);
	   }
	   @Test (expected = NoPlaceException.class)
	   public void test_parkcar_two_full()
	   {
		   cp.setEmptySpace(0);
		   cp1.setEmptySpace(0);
		   parkingboy.stopCar(car);
	   }
	   
	   @Test
	   public void test_parking_when_two_not_full()
	   { 	  
		   parkingboy.stopCar(car);
		   Assert.assertEquals(cp.getEmptySpace(),cp.getTotalnumber()-1); 
	   }
	   @Test
	   public void test_parking_when_one_full()
	   {
		   cp.setEmptySpace(0);
		   parkingboy.stopCar(car);
		   Assert.assertEquals(cp1.getEmptySpace(),cp1.getTotalnumber()-1);
	   }
	   @Test
	   public void test_parkingboy_getcar_one_full_one_notfull()
	   {
		   cp.setEmptySpace(0);
		   Ticket t1 = parkingboy.stopCar(car);
		   Assert.assertEquals(car, parkingboy.getCar(t1));	     	   
	   }
	   @Test (expected = NoCarException.class)
	   public void test_parkingboy_getcar_two_empty()
	   {   
		   Ticket t1 = new Ticket(1,1);
		   parkingboy.getCar(t1);	     	   
	   } 
	   @Test
	   public void test_parkingboy_getcar()
	   {  
		   Ticket t1 = parkingboy.stopCar(car);
		   Assert.assertEquals(car, parkingboy.getCar(t1));
	   }
	   @Test
	   public void test_parkingboy_better_shopcar()
	   {
		   ps = new ParkingOnSmart();
		   parkingboy.setParkingStrategy(ps);
		   cp.setEmptySpace(2);
		   cp1.setEmptySpace(4);
		   Ticket t1=parkingboy.stopCar(car);
		   Assert.assertEquals(2,t1.getCarpark_id());
	   }

}
