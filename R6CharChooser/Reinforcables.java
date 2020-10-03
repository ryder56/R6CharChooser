//**************
// CSE 205: #11333 - T,Th - 4:30-5:45
// Assignment: assignment #6
// Author: Ryder Roth - 1216790822
// Description: This is the reinforcable abstract class that stores what reinforcables have and must do.
//**************
public abstract class Reinforcables {
	protected String location;
	protected int floor;
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public int getFloor() {
		return floor;
	}
	
	public String getLocation(){
		return location;
	}
	
	public abstract String Orientation();
	
	public abstract String toString();
}
