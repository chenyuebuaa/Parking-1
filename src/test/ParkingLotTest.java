package test;



import main.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {

	private ParkingLot cp;
	private Car car;
	private String id ="A";
	private Ticket testt;

    @Before
    public void init() {
		cp = new ParkingLot(20);
        car = new Car(id);
        testt = new Ticket(0,0);
	}
	@Test       //测试停车
	public void test_stop_car(){
		Ticket t = cp.stopCar(car);
		Assert.assertEquals(19,cp.getEmptySpace());
	}
	@Test      //测试取车
	public void test_get_car(){
		Ticket t = cp.stopCar(car);
		Assert.assertEquals(car, cp.getCar(t));
		Assert.assertEquals(20, cp.getEmptySpace());		
	}
	@Test (expected = NoPlaceException.class)      //测试停车场满时停车
	public void test_stop_when_full() {
		cp.setEmptySpace(0);
		cp.stopCar(car);
	}
	@Test (expected = NoCarException.class)   //测试停车场空时取车
	public void test_get_car_when_empty(){
		cp.setEmptySpace(20);
		cp.getCar(testt);
	}
    @Test (expected = NoCarException.class)       //测试凭错误的票取车
    public void test_get_car_by_wrong_ticket(){
        Ticket t = cp.stopCar(car);
        t.setTicket_id(4);
        System.out.println(cp.getCar(t).getCar_id());
    }
    @Test
    public void test_show_number_of_empty_space()         //测试打印空车位
    {
        cp.setEmptySpace(14);
        System.out.println("剩余空车位："+cp.getEmptySpace());
        Assert.assertEquals(14,cp.getEmptySpace());
    }


}
