//**************
// Author: Ryder Roth
// Description: This is the wall class that stores what walls have and can do.
//**************
public class Walls extends Reinforcables{
	private char orientation;
	
	public Walls(int floor, String location, char orientation) {
		this.floor = floor;
		this.location = location;
		this.orientation = orientation;
	}
	
	//N,E,S,W converts the orientation to a String
	@Override
	public String Orientation() {
		String side = "";
		switch(orientation) {
			case 'N':
				side += "North";
				break;
			case 'E':
				side += "East";
				break;
			case 'W':
				side += "West";
				break;
			case 'S':
				side += "South";
				break;
			default:
				break;
		}
		return side;
	}
	
	//cardinal directions based on the walls locations
	public void setOrientation(char side) {
		orientation = Character.toUpperCase(side);
	}
	
	//returns all of the information the wall stores to be output
	@Override
	public String toString() {
		String output = "floor " + floor + ", " + Orientation() + " side " + location;
		return output;
	}

}
