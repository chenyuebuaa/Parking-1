package test;



import main.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarParkTest {

	private ParkingLot cp;
	private Car car;
	private String id ="A";
	private Ticket testt;
	 

    @Before
    public void init() {
		cp = new ParkingLot(20);
        car = new Car(id);
	}

	@Test
	public void test_stop_car(){
		Ticket t = cp.stopCar(car);
		Assert.assertEquals("A",cp.getCar(t).getCar_id() );
	}
	@Test
	public void test_get_car(){
		Ticket t = cp.stopCar(car);
		Assert.assertEquals(car, cp.getCar(t));
		Assert.assertEquals(20, cp.getEmptySpace());		
	}
	@Test    (expected = NoPlaceException.class)
	public void test_stop_when_full() {
		cp.setEmptySpace(0);
		cp.stopCar(car);
	}
	@Test (expected = NoCarException.class)
	public void test_get_when_empty(){
		cp.setEmptySpace(300);
		 cp.getCar(testt);
	}
}
