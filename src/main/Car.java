package main;

public class Car {
	
	private String car_id;
	
	public Car(String id)
	{
		this.car_id = id;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car_id == null) ? 0 : car_id.hashCode());
		return result;
	}

}
