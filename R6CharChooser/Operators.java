//**************
// Author: Ryder Roth
// Description: This is the operators class that stores what operators have and can return, the ranking isnt used in the current program, but I plan on expanding on this outside of this class so I wanted to build add it now. 
//**************

//TODO make type that the operator is a linked list, not a static single for multitypes

public class Operators {
	String name;
	boolean isDefenderOperator; //true for defense, false for offense
	int type; 
	/*
	 * Fragger: 1
	 * Utility: 2
	 * AntiElectric: 3
	 * SoftDestruction: 4
	 * HardBreach: 5
	 * Delay: 6
	 * UtilitySink: 7
	 * AntiUtility: 8
	 * AntiBreach: 9
	 * Cams: 10
	 * Roam: 11
	 * AntiRoam: 12
	 */
	double ranking; //this is set depending on their win delta and pick rate
	
	public Operators(String name, int type, boolean isDefense) {
		this.name = name;
		this.type = type;
		this.isDefenderOperator = isDefense;
	}
	
	public void setRanking(double rank) {
		ranking = rank;
	}
	
	public String getName() {
		return name;
	}
	
	public int getType() {
		return type;
	}
	
	public double getRanking() {
		return ranking;
	}
	
	public String position() {
		if(isDefenderOperator) {
			return "Defense";
		}
		return "Offense";
	}
	
	public String toString() {
		String output = name + " - " + position() + ", role: ";
		//Switch statement for role
		switch(type) {
			case 1:
				output += "Fragger";
				break;
			case 2:
				output += "Utility";
				break;
			case 3:
				output += "AntiElectric";
				break;
			case 4:
				output += "SoftDestruction";
				break;
			case 5:
				output += "HardBreach";
				break;
			case 6:
				output += "Delay";
				break;
			case 7:
				output += "UtilitySink";
				break;
			case 8:
				output += "AntiUtility";
				break;
			case 9:
				output += "AntiBreach";
				break;
			case 10:
				output += "Cams";
				break;
			case 11:
				output += "Roam";
				break;
			case 12:
				output += "AntiRoam";
				break;
			default:
				break;
		}
		return output;
	}
	
	
	
}
