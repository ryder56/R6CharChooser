//**************
// CSE 205: #11333 - T,Th - 4:30-5:45
// Assignment: assignment #6
// Author: Ryder Roth - 1216790822
// Description: This is the chooser class that chooses the best operator types that should be chosen.
//**************
public class Chooser {
	Map currentMap;
	LinkedList<Integer> currentOperatorRoles = new LinkedList<Integer>();
	
	public Chooser(Map currentMap) {
		this.currentMap = currentMap;
	}
	
	public void setMap(Map newMap) {
		currentMap = newMap;
	}
	
	//adds a type that has already been chosen by the other teammates
	public void addOperatorAlreadyChosenType(int type) {
		currentOperatorRoles.add(type);
	}
	
	//returns a linked list of recommended operator types for attack
	private LinkedList<Integer> recommendedOperatorsForAttack(int siteIndex) {
		Sites currentSite = currentMap.getSite(siteIndex);
		LinkedList<Integer> currentRoles = new LinkedList<Integer>();
		for(int i = 0; i < currentOperatorRoles.size(); i++) {
			currentRoles.add(currentOperatorRoles.get(i));
		}
		LinkedList<Integer> neededRoles = new LinkedList<Integer>();
		for(int i = 0; i < 5; i++) {
			neededRoles.add(currentSite.getIdealAttackCharType(i));
		}
		while(currentRoles.size()>0) {
			boolean roleRemoved = false;
			for(int i = 0; i < neededRoles.size(); i++) {
				if(currentRoles.get(0) == neededRoles.get(i)) {
					neededRoles.remove(i);
					roleRemoved = true;
				}
			}
			if(roleRemoved == false) {
				currentRoles.remove(0);
			}
		}
		return neededRoles;
	}
	
	//returns a linked list of recommended operator types for defense
	private LinkedList<Integer> recommendedOperatorsForDefense(int siteIndex) {
		Sites currentSite = currentMap.getSite(siteIndex);
		LinkedList<Integer> currentRoles = new LinkedList<Integer>();
		for(int i = 0; i < currentOperatorRoles.size(); i++) {
			currentRoles.add(currentOperatorRoles.get(i));
		}
		LinkedList<Integer> neededRoles = new LinkedList<Integer>();
		for(int i = 0; i < 5; i++) {
			neededRoles.add(currentSite.getIdealDefenseCharType(i));
		}
		while(currentRoles.size()>0) {
			boolean roleRemoved = false;
			for(int i = 0; i < neededRoles.size(); i++) {
				if(currentRoles.get(0) == neededRoles.get(i)) {
					neededRoles.remove(i);
					roleRemoved = true;
				}
			}
			if(roleRemoved == false) {
				currentRoles.remove(0);
			}
		}
		return neededRoles;
	}

	//ouputs the recommended types for your team based on the site as well as whether the team is attacking or defending
	public String recommendedToString(LinkedList<Operators> operatorList, int siteIndex, boolean defense) {
		LinkedList<Integer> neededRoles = new LinkedList<Integer>();
		if(defense)
			neededRoles = recommendedOperatorsForDefense(siteIndex);
		else 
			neededRoles = recommendedOperatorsForAttack(siteIndex);
		String output = "";
		if(neededRoles.size() == 0) {
			output += "You have met all the needed Roles!";
			return output;
		}
		output += "The Recommended Operator Types In Order Are \n"
				+ "------------------------------\n";
		for(int i = 0; i < neededRoles.size(); i++) {
			output += "\nType " + typeToString(neededRoles.get(i)) + "\n"
					+ "------------------------------\n";
			for(int j = 0; j < operatorList.size(); j++) {
				Operators currentOperator = operatorList.get(j);
				if(neededRoles.get(i) == currentOperator.getType() && currentOperator.isDefenderOperator == defense) {
					output += currentOperator.toString() + "\n";
				}
			}
		}
		return output;
	}
	
	//condenses the switch statement for type to one method
	private String typeToString(int type) {
		String output = "";
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
	
	//returns the method from the Map class
	public String bestSiteToHold() {
		return currentMap.recommendedSite();
	}
	
	//returns the site information at the site at index 0
	public String bestSiteInformation() {
		String output = "The best Site is: "
				+ bestSiteToHold()
				+ "\n\nHatches To Barricade"
				+ "\n------------------------\n";
		output += currentMap.getBestSite().hatchesToBarricadeToString();
		output += "\nWalls To Reinforce \n"
				+ "------------------------\n";
		output += currentMap.getBestSite().wallsToBarricadeToString();
		output += "\nWalls To Electrify\n"
				+ "------------------------\n";
		output += currentMap.getBestSite().wallsToElectrifyToString();
		output += "\nWalls To Break For Rotation\n"
				+ "------------------------\n";
		output += currentMap.getBestSite().rotationWallsToBreakToString();
		return output;
	}
	
	//returns the site information at the site at any index
	public String currentSiteInformation(Sites aSite) {
		String output = "The Current Site is: "
				+ aSite.siteNamesToString()
				+ "\n\nHatches To Barricade"
				+ "\n------------------------\n";
		output += aSite.hatchesToBarricadeToString();
		output += "\nWalls To Reinforce \n"
				+ "------------------------\n";
		output += aSite.wallsToBarricadeToString();
		output += "\nWalls To Electrify\n"
				+ "------------------------\n";
		output += aSite.wallsToElectrifyToString();
		output += "\nWalls To Break For Rotation\n"
				+ "------------------------\n";
		output += aSite.rotationWallsToBreakToString();
		return output;
	}
}
