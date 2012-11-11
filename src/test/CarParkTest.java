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
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		cp = new CarPark();
		car = new Car(id);
	}
	@Test
	public void test_stop_car() {
		//String id = "A";
		//Car car = new Car(id);
		//CarPark cp = new CarPark();
		boolean b = cp.stopCar(car);
		Assert.assertEquals(299, cp.getEmptySpace());
		Assert.assertEquals("A", cp.getCarInstance(0).getCar_id());
	}
	@Test
	public void test_get_car(){
//		String id = "A";
//		Car car = new Car(id);
	//	CarPark cp = new CarPark();
		boolean b = cp.stopCar(car);
		boolean c = cp.getCar(id);
		Assert.assertEquals(300, cp.getEmptySpace());
	}
	@Test
	public void test_stop_when_full(){
//		String id = "A";
//		Car car = new Car(id);
		//CarPark cp = new CarPark();
		cp.setEmptyspace(0);
		Assert.assertEquals(false, cp.stopCar(car));	
		
	}
	
	@Test
	public void test_get_when_empty(){	
//		String id = "A";
//		Car car = new Car(id);
	//	CarPark cp = new CarPark();
		cp.setEmptyspace(300);
		Assert.assertEquals(false, cp.getCar(id));
	}
	@Test
	public void test_get_wrong_car(){
//		String id = "A";
//		Car car = new Car(id);
	//	CarPark cp = new CarPark();
		boolean b = cp.stopCar(car);
		boolean c = cp.getCar("B");
       Assert.assertEquals(false, c)	;	
	}
   @Test
   public void test_biantaitest()
   {
	   cp.stopCar(car);
	   Car carb = new Car("B");
	   Car carc = new Car("C");
	   Car card = new Car("D");
	   cp.stopCar(carb);
	   Assert.assertEquals(true,cp.isCarIn("B"));
	   Assert.assertEquals(false,cp.isCarIn("C"));
	   Assert.assertEquals(298, cp.getEmptySpace());
	   cp.getCar("A");
	   Assert.assertEquals(false,cp.isCarIn("A"));
	   cp.stopCar(card);
	   cp.stopCar(carc);
	   Assert.assertEquals(297, cp.getEmptySpace());
	   cp.getCar("D");
	   cp.getCar("B");
	   cp.getCar("C");
	   Assert.assertEquals(300, cp.getEmptySpace());
   }
   @Test
   public void test_generate_ticket()
   {
	   Ticket tk = new Ticket();
   }
}
