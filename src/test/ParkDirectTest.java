package test;

import main.*;
import org.junit.Before;
import org.junit.Test;


public class ParkDirectTest {
	
	private Car car;
	private String id ="A";
    private ParkingManager pm;
	private ParkingLot cp,cp1,cp2,cp3,cp4;
	private ParkingBoy parkingboy1, parkingboy2,parkingboy3;
	private ParkingStrategy ps;
    private ParkingDirector pd;


    @Before
	public void init()
	{
		car = new Car(id);
        cp = new ParkingLot(20);
        cp1 = new ParkingLot(30);
        cp2 = new ParkingLot(40);
        cp3 = new ParkingLot(50);
        cp4 = new ParkingLot(15);

        ps = new ParkingOnFirst();
        parkingboy1 = new ParkingBoy(ps);
        ps = new ParkingOnSmart();
        parkingboy2 = new ParkingBoy(ps);
        ps = new ParkingOnSuperSmart();
        parkingboy3 = new ParkingBoy(ps);
        parkingboy1.add(cp1);
        parkingboy2.add(cp2);
        parkingboy3.add(cp3);

        pm = new ParkingManager();
        pm.add(cp);
        pm.add(parkingboy1);
        pm.add(parkingboy2);
        pm.add(parkingboy3);
        pd = new ParkingDirector();
        ParkingBoy.numberofparkingboy=1;
        ParkingLot.numberofcarpark=1;
	}
    @Test       //打印单个停车场报表
    public void test_pl_display()
    {
        pd.report(cp);
    }
	@Test      //打印停车仔报表
	public void test_pb_display()
	{
        parkingboy1.add(cp4);
		pd.report(parkingboy1);
	}
    @Test      //打印PM报表
    public void test_pm_display()
    {
        pd.report(pm);
    }
}
