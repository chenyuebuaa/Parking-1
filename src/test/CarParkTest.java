package test;


import junit.framework.TestCase;

import main.Car;
import main.CarPark;
import main.Ticket;

import org.junit.Assert;
import org.junit.Test;

public class CarParkTest extends TestCase {

	private CarPark cp;
	private Car car;
	private String id ="A";
	private Ticket testt;
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		cp = new CarPark(20);
		car = new Car(id);
		testt = new Ticket(1);
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
	//@Test
//	public void test_get_wrong_car(){
//		Ticket t = cp.stopCarMap(car);
//		Ticket t2 = cp.stopCarMap(new Car("C"));
//       Assert.assertEquals(null, cp.getCarMap(t2))	;	
//	}
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
  
}
