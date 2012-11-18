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
		cp = new CarPark(20);
		car = new Car(id);
	}
	@Test
	public void test_stop_car() {
		//String id = "A";
		//Car car = new Car(id);
		//CarPark cp = new CarPark();
		Ticket t = cp.stopCar(car);
		Assert.assertEquals("A", cp.getCarInstance(0).getCar_id());
		
	}
	@Test
	public void test_get_car(){
//		String id = "A";
//		Car car = new Car(id);
	//	CarPark cp = new CarPark();
		Ticket t = cp.stopCar(car);
		boolean c = cp.getCar(t);
		Assert.assertEquals(20, cp.getEmptySpace());
	}
	@Test
	public void test_stop_when_full(){
//		String id = "A";
//		Car car = new Car(id);
		//CarPark cp = new CarPark();
		cp.setEmptyspace(0);
		Assert.assertEquals(null, cp.stopCar(car));	
		
	}
	
	@Test
	public void test_get_when_empty(){	
//		String id = "A";
//		Car car = new Car(id);
	//	CarPark cp = new CarPark();
		cp.setEmptyspace(300);
		Assert.assertEquals(false, cp.getCar(car));
	}
	@Test
	public void test_get_wrong_car(){
//		String id = "A";
//		Car car = new Car(id);
	//	CarPark cp = new CarPark();
		Ticket t = cp.stopCar(car);
		Car carc = new Car("C");
		boolean c = cp.getCar(carc);
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
	   Assert.assertEquals(true,cp.isCarIn(carb));
	   Assert.assertEquals(false,cp.isCarIn(carc));
	   cp.getCar(car);
	   Assert.assertEquals(false,cp.isCarIn(card));
	   cp.stopCar(card);
	   cp.stopCar(carc);
	   cp.getCar(card);
	   cp.getCar(carb);
	   cp.getCar(carc);
   }
  
}
