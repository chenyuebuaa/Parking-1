package test;

import junit.framework.TestCase;
import main.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ParkBoyTest {
	private ParkingLot cp;
	private ParkingLot cp1;
    private ParkingLot cp2;
	private Car car;
	private String id ="A";
	private ParkingBoy parkingboy;
	private ParkingStrategy ps;

    @Before
    public void init()
    {
        ParkingLot.numberofcarpark=1;
        cp = new ParkingLot(20);
        cp.setEmptySpace(10);
        cp1 = new ParkingLot(40);
        cp1.setEmptySpace(30);
        cp2= new ParkingLot(20);
        cp2.setEmptySpace(20);
        car = new Car(id);
        parkingboy = new ParkingBoy(ps);
        parkingboy.add(cp);
        parkingboy.add(cp1);
        parkingboy.add(cp2);
    }
	
	 @Test
	 public void test_parkBoy_ShouldParkCar_inFirst()
	   {
           ps = new ParkingOnFirst();
           parkingboy.setParkingStrategy(ps);
		   parkingboy.add(cp);
		   parkingboy.stopCar(car);
		   Assert.assertEquals(9,cp.getEmptySpace());
	   }
	 @Test (expected = NoPlaceException.class)
	 public void test_parking_when_three_full()
	   {
           ps = new ParkingOnFirst();
           parkingboy.setParkingStrategy(ps);
		   cp.setEmptySpace(0);
		   cp1.setEmptySpace(0);
           cp2.setEmptySpace(0);
		   parkingboy.stopCar(car);
	   }
	 @Test
	 public void test_parking_when_first_full_other_not_full()
	   {
           ps = new ParkingOnFirst();
           parkingboy.setParkingStrategy(ps);
           cp.setEmptySpace(0);
		   parkingboy.stopCar(car);
		   Assert.assertEquals(29,cp1.getEmptySpace());
	   }
    @Test
    public void test_parkingboy_getcar()
    {
        ps = new ParkingOnFirst();
        parkingboy.setParkingStrategy(ps);
        Ticket t1 = parkingboy.stopCar(car);
        Assert.assertEquals(car, parkingboy.getCar(t1));
    }
    @Test
	public void test_parkingboy_getcar_one_full_other_not_full()
	   {
           ps = new ParkingOnFirst();
           parkingboy.setParkingStrategy(ps);
		   cp.setEmptySpace(0);
		   Ticket t1 = parkingboy.stopCar(car);
		   Assert.assertEquals(car, parkingboy.getCar(t1));	     	   
	   }

	 @Test (expected = NoCarException.class)
	public void test_parkingboy_getcar_wrong_ticket()
	   {
		   Ticket t1 = new Ticket(1,1);
		   parkingboy.getCar(t1);	     	   
	   }
    @Test (expected = NoCarException.class)
    public void test_test_parkingboy_getcar_all_empty()
    {
        cp.setEmptySpace(20);
        cp1.setEmptySpace(40);
        cp2.setEmptySpace(20);
        ps = new ParkingOnFirst();
        parkingboy.setParkingStrategy(ps);
        Ticket t1 = new Ticket(1,1);
        parkingboy.getCar(t1);
    }
	 @Test
	 public void test_parkingboy_better_stopcar()
	   {
		   ps = new ParkingOnSmart();
		   parkingboy.setParkingStrategy(ps);
		   Ticket t1=parkingboy.stopCar(car);
		   Assert.assertEquals(2,t1.getCarpark_id());
	   }
    @Test
    public void test_parkingboy_super_stopcar()
    {
        ps = new ParkingOnSuperSmart();
        parkingboy.setParkingStrategy(ps);
        Ticket t1=parkingboy.stopCar(car);
        Assert.assertEquals(3,t1.getCarpark_id());
    }


}
