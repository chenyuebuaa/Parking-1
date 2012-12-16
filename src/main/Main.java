package main;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Car car;
		 String id ="A";
		 ParkingLot cp,cp1,cp2,cp3;
	     ParkingBoy parkingboy, sparkingboy;
		 ParkingStrategy ps;
		
		ParkingLot.numberofcarpark=1;
		ParkingBoy.numberofparkingboy=1;
		car = new Car(id);
		cp = new ParkingLot(0);
		cp1 = new ParkingLot(10);
		cp2 = new ParkingLot(1000);
		cp3 = new ParkingLot(20);
		ps = new ParkingOnFirst();
		parkingboy = new ParkingBoy(ps);
		ps = new ParkingOnSmart();
		sparkingboy = new ParkingBoy(ps);
		parkingboy.add(cp);
		sparkingboy.add(cp1);
		sparkingboy.add(cp3);
		ParkingManager pm = new ParkingManager();
		pm.add(parkingboy);
		pm.add(sparkingboy);
		pm.add(cp2);
		
		//pm.print(0);
		sparkingboy.diplay(0);
			

	}

}
