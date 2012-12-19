package test;

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
        ParkingLot.numberofcarpark=1;
    }
	 @Test     //测试普通停车仔停车
	 public void test_parkBoy_ShouldParkCar_inFirst()
	   {
           ps = new ParkingOnFirst();
           parkingboy.setParkingStrategy(ps);
		   parkingboy.add(cp);
		   parkingboy.stopCar(car);
		   Assert.assertEquals(9,cp.getEmptySpace());
	   }
	 @Test (expected = NoPlaceException.class)    //测试管理的所有停车场满时，停车仔停车
	 public void test_parking_when_three_full()
	   {
           ps = new ParkingOnFirst();
           parkingboy.setParkingStrategy(ps);
		   cp.setEmptySpace(0);
		   cp1.setEmptySpace(0);
           cp2.setEmptySpace(0);
		   parkingboy.stopCar(car);
	   }
	 @Test  //测试管理的停车场一满其他不满时，停车仔停车
	 public void test_parking_when_first_full_other_not_full()
	   {
           ps = new ParkingOnFirst();
           parkingboy.setParkingStrategy(ps);
           cp.setEmptySpace(0);
		   parkingboy.stopCar(car);
		   Assert.assertEquals(29,cp1.getEmptySpace());
	   }
    @Test      //测试停车仔取车
    public void test_parkingboy_getcar()
    {
        ps = new ParkingOnFirst();
        parkingboy.setParkingStrategy(ps);
        Ticket t1 = parkingboy.stopCar(car);
        Assert.assertEquals(car, parkingboy.getCar(t1));
    }

   	 @Test (expected = NoCarException.class)   //测试停车仔用错误的票取车
	public void test_parkingboy_getcar_wrong_ticket()
	   {
		   Ticket t1 = new Ticket(1,1);
		   parkingboy.getCar(t1);	     	   
	   }
    @Test (expected = NoCarException.class)         //测试停车场全空的时候，停车仔取车
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
	 @Test    //测试选择空位数最多的停车仔停车
	 public void test_parkingboy_better_stopcar()
	   {
		   ps = new ParkingOnSmart();
		   parkingboy.setParkingStrategy(ps);
		   Ticket t1=parkingboy.stopCar(car);
		   Assert.assertEquals(2,t1.getCarpark_id());
	   }
    @Test    //测试选择空置率最高的停车仔停车
    public void test_parkingboy_super_stopcar()
    {
        ps = new ParkingOnSuperSmart();
        parkingboy.setParkingStrategy(ps);
        Ticket t1=parkingboy.stopCar(car);
        Assert.assertEquals(3,t1.getCarpark_id());
    }
}
