package test;


import junit.framework.TestCase;

import main.Car;
import main.CarPark;
import main.ParkingManagement;
import main.ParkingOnFirst;
import main.ParkingOnSmart;
import main.ParkingStrategy;
import main.Ticket;

import org.junit.Assert;
import org.junit.Test;

public class CarParkTest extends TestCase {

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
		cp = new CarPark(20);
		car = new Car(id);
		cp1 = new CarPark(20);
		ps = new ParkingOnFirst();
		parkingboy = new ParkingManagement(ps);
		parkingboy.addCarPark(cp);
		parkingboy.addCarPark(cp1);
		
	}
	@Test
	public void test_stop_car() {
		Ticket t = cp.stopCarMap(car);
		Assert.assertEquals("A",cp.getCarInstanceByTicket(t).getCar_id() );
		
	}
	@Test
	public void test_get_car(){
		Ticket t = cp.stopCarMap(car);
		 cp.getCarMap(t);
		Assert.assertEquals(20, cp.getEmptySpace());
	}
	@Test
	public void test_stop_when_full(){
		cp.setEmptyspace(0);
		Assert.assertEquals(null, cp.stopCarMap(car));	
		
	}
	
	@Test
	public void test_get_when_empty(){	
		cp.setEmptyspace(300);
		Assert.assertEquals(null, cp.getCarMap(testt));
	}
	
   @Test
   public void test_biantaitest_Map()
   {	  
	  Ticket t1 = cp.stopCarMap(car);
	  Assert.assertEquals(true, cp.isCarInMap(car));
	  Assert.assertEquals(true, cp.getCarMap(t1).equals(car));
	  Assert.assertEquals(false, cp.isCarInMap(car));	  
   }
   
   @Test
   public void test_hashmap_index()
   {
	   Ticket t1 = cp.stopCarMap(car);
	   Assert.assertEquals(car, cp.getCarMap(t1));
	   
   }
  
   
   @Test
   public void test_parkBoy_ShouldParkCar()
   {
	   ParkingManagement parkingboy = new ParkingManagement(ps);
	   parkingboy.addCarPark(cp);
	   Ticket t1 = parkingboy.parking(car);
	   Assert.assertEquals(cp.getName(), t1.getCarpark_id());
   }
   @Test
   public void test_parkcar_two_full()
   {
	   cp.setEmptyspace(0);
	   cp1.setEmptyspace(0);
	   Ticket t1 = parkingboy.parking(car);
	   Assert.assertEquals(null, t1);
   }
   
   @Test
   public void test_parking_when_two_not_full()
   { 	  
	   Ticket t1 = parkingboy.parking(car);
	   Assert.assertEquals(cp.getName(),t1.getCarpark_id()); 
   }
   @Test
   public void test_parking_when_one_full()
   {
	   cp.setEmptyspace(0);
	   Ticket t1 = parkingboy.parking(car);
	   Assert.assertEquals(cp1.getName(),t1.getCarpark_id()); 
   }
   @Test
   public void test_parkingboy_getcar_one_full_one_notfull()
   {
	   cp.setEmptyspace(0);
	   Ticket t1 = parkingboy.parking(car);
	   Assert.assertEquals(car, parkingboy.getCar(t1));	     	   
   }
   @Test
   public void test_parkingboy_getcar_two_empty()
   {   
	   Ticket t1 = new Ticket(1,1);
	   Assert.assertEquals(null, parkingboy.getCar(t1));	     	   
   } 
   @Test
   public void test_parkingboy_getcar()
   {  
	   Ticket t1 = parkingboy.parking(car);
	   Assert.assertEquals(car, parkingboy.getCar(t1));
   }
   @Test
   public void test_parkingboy_better_shopcar()
   {
	   ps = new ParkingOnSmart();
	   parkingboy.setPs(ps);
	   cp.setEmptyspace(2);
	   cp1.setEmptyspace(4);
	   Ticket t1=parkingboy.parking(car);
	   Assert.assertEquals(2,t1.getCarpark_id());
   }
  
}
