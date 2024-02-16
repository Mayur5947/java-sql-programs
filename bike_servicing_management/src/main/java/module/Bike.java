package module;

public class Bike {

	private int bike_id;
	private String make;
	private String model;
	private String color;
	private String numberPlate;
	private String year;
	public int getBike_id() {
		return bike_id;
	}
	public void setBike_id(int bike_id) {
		this.bike_id = bike_id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Bike [bike_id=" + bike_id + ", make=" + make + ", model=" + model + ", color=" + color
				+ ", numberPlate=" + numberPlate + ", year=" + year + "]";
	}
	
	
}
