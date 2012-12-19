package main;

import java.util.List;


public interface ParkingStrategy {
	public ParkingLot findCarPark(List<Component> park_list);
}
