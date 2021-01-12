//**************
// Author: Ryder Roth
// Description: This is the hatch class that stores what hatches have and can do.
//**************
public class Hatches extends Reinforcables{
	private String orientation;
	
	public Hatches(int floor, String location, String orientation) {
		this.floor = floor;
		this.location = location;
		this.orientation = orientation;
	}
	
	@Override
	public String Orientation() {
		return orientation;
	}
	
	//string because hatches are on the floor and have precise spots
	public void setOrientation(String location) {
		orientation = location;
	}
	
	//returns all of the information the hatch stores to be output
	@Override
	public String toString() {
		String output ="floor " + floor + ", " + location + ", " + Orientation();
		return output;
	}
	
}
