package test;

import org.junit.Assert;
import org.junit.Test;

import main.Car;
import main.CarPark;
import main.NoCarException;
import main.NoPlaceException;
import main.ParkingBoy;
import main.ParkingOnFirst;
import main.ParkingOnSmart;
import main.ParkingStrategy;
import main.Ticket;
import junit.framework.TestCase;


public class ParkBoyTest extends TestCase{
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
		cp = new CarPark(20);
		car = new Car(id);
		cp1 = new CarPark(20);
		ps = new ParkingOnFirst();
		parkingboy = new ParkingBoy(ps);
		parkingboy.addCarPark(cp);
		parkingboy.addCarPark(cp1);
		
	}
	
	  @Test
	   public void test_parkBoy_ShouldParkCar()
	   {
		   ParkingBoy parkingboy = new ParkingBoy(ps);
		   parkingboy.addCarPark(cp);
		   Ticket t1 = parkingboy.stopCar(car);
		   Assert.assertEquals(cp.getName(), t1.getCarpark_id());
	   }
	   @Test (expected = NoPlaceException.class)
	   public void test_parkcar_two_full()
	   {
		   cp.setEmptyspace(0);
		   cp1.setEmptyspace(0);
		   parkingboy.stopCar(car);
	   }
	   
	   @Test
	   public void test_parking_when_two_not_full()
	   { 	  
		   Ticket t1 = parkingboy.stopCar(car);
		   Assert.assertEquals(cp.getName(),t1.getCarpark_id()); 
	   }
	   @Test
	   public void test_parking_when_one_full()
	   {
		   cp.setEmptyspace(0);
		   Ticket t1 = parkingboy.stopCar(car);
		   Assert.assertEquals(cp1.getName(),t1.getCarpark_id()); 
	   }
	   @Test
	   public void test_parkingboy_getcar_one_full_one_notfull()
	   {
		   cp.setEmptyspace(0);
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
		   cp.setEmptyspace(2);
		   cp1.setEmptyspace(4);
		   Ticket t1=parkingboy.stopCar(car);
		   Assert.assertEquals(2,t1.getCarpark_id());
	   }

}
