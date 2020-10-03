//**************
// CSE 205: #11333 - T,Th - 4:30-5:45
// Assignment: assignment #6
// Author: Ryder Roth - 1216790822
// Description: This is the sites class, it stores all the information a site has and only has setters and getters as a site can not do any action.
//**************
public class Sites {
	private LinkedList<Reinforcables> hatchesToBarricade = new LinkedList<Reinforcables>();
	private int siteAFloor;
	private int siteBFloor;
	private LinkedList<Reinforcables> wallsToBarricade = new LinkedList<Reinforcables>();
	private LinkedList<Reinforcables> wallsToElectrify = new LinkedList<Reinforcables>();
	private String siteAName;
	private String siteBName;
	private LinkedList<Reinforcables> rotationWallsToBreak = new LinkedList<Reinforcables>();
	private LinkedList<Integer> idealAttackComposition = new LinkedList<Integer>();
	private LinkedList<Integer> idealDefenseComposition = new LinkedList<Integer>();
	
	public Sites(int siteAFloor, String siteAName, int siteBFloor, String siteBName) {
		this.siteAFloor = siteAFloor;
		this.siteAName = siteAName;
		this.siteBFloor = siteBFloor;
		this.siteBName = siteBName;
	}
	
	public int getSiteAFloor() {
		return siteAFloor;
	}
	
	public int getSiteBFloor() {
		return siteBFloor;
	}
	
	public String getSiteAName() {
		return siteAName;
	}
	
	public String getSiteBName() {
		return siteBName;
	}
	
	public String outputSites() {
		String output = "A is on floor " + getSiteAFloor() + " - " + getSiteAName() + " and B is on floor " + getSiteBFloor() + " - " + getSiteBName();
		return output;
	}
	
	public void addHatchToBarricade(int floor, String location, String orientation) {
		Hatches newHatch = new Hatches(floor, location, orientation);
		hatchesToBarricade.add(newHatch);
	}
	
	public void addWallToBarricade(int floor, String location, char orientation) {
		Walls newWall = new Walls(floor, location, orientation);
		wallsToBarricade.add(newWall);
	}
	
	public void addWallToElectrify(int floor, String location, char orientation) {
		Walls newWall = new Walls(floor, location, orientation);
		wallsToElectrify.add(newWall);
	}
	
	public void addWallForRotation(int floor, String location, char orientation) {
		Walls newWall = new Walls(floor, location, orientation);
		rotationWallsToBreak.add(newWall);
	}
	
	public String siteNamesToString() {
		String output = "A: " + getSiteAFloor() + " floor - " + getSiteAName() + " B: " + getSiteBFloor() + " floor - " + getSiteBName();
		return output;
	}
	
	public String hatchesToBarricadeToString() {
		String output = "";
		for(int i = 0; i < hatchesToBarricade.size(); i++)
			output += hatchesToBarricade.get(i).toString() + "\n";
		return output;
	}
	
	public String wallsToBarricadeToString() {
		String output = "";
		for(int i = 0; i < wallsToBarricade.size(); i++) {
			output += wallsToBarricade.get(i).toString() + "\n";
		}
		return output;
	}
	
	public String wallsToElectrifyToString() {
		String output = "";
		for(int i = 0; i < wallsToElectrify.size(); i++) {
			output += wallsToElectrify.get(i).toString() + "\n";
		}
		return output;
	}
	
	public String rotationWallsToBreakToString() {
		String output = "";
		for(int i = 0; i < rotationWallsToBreak.size(); i++) {
			output += rotationWallsToBreak.get(i).toString() + "\n";
		}
		return output;
	}
	
	public void setIdealAttackComposition(int op1type, int op2type, int op3type, int op4type, int op5type) {
		idealAttackComposition.add(op1type);
		idealAttackComposition.add(op2type);
		idealAttackComposition.add(op3type);
		idealAttackComposition.add(op4type);
		idealAttackComposition.add(op5type);
	}
	
	public void setIdealDefenseComposition(int op1type, int op2type, int op3type, int op4type, int op5type) {
		idealDefenseComposition.add(op1type);
		idealDefenseComposition.add(op2type);
		idealDefenseComposition.add(op3type);
		idealDefenseComposition.add(op4type);
		idealDefenseComposition.add(op5type);
	}

	//in order of importance as the list will be established
	public int getIdealAttackCharType(int rankingIndex) {
		return idealAttackComposition.get(rankingIndex);
	}
	
	//in order of importance again
	public int getIdealDefenseCharType(int rankingIndex) {
		return idealDefenseComposition.get(rankingIndex);
	}

}
