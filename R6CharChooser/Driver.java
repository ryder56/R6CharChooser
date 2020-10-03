//**************
// CSE 205: #11333 - T,Th - 4:30-5:45
// Assignment: assignment #6
// Author: Ryder Roth - 1216790822
// Description: This is the driver class for the program
//**************
import java.io.FileNotFoundException;
import java.util.*;

public class Driver {
	public static void main(String [] arg) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		MapAndCharacterLoader currentMapsandChars = new MapAndCharacterLoader("maps.txt", "characters.txt");
		LinkedList<Operators> operatorList = new LinkedList<Operators>();
		operatorList = currentMapsandChars.loadOperatorList();
		LinkedList<Map> mapList = new LinkedList<Map>();
		operatorList = currentMapsandChars.loadOperatorList();
		mapList = currentMapsandChars.loadMapList();
		Chooser choiceDecider = new Chooser(mapList.get(0));
		Map currentMap = mapList.get(0);
		int currentSiteIndex = 0;
		printMenu();
		boolean attacking = false;
		boolean run = true;
		while(run) {
			switch(in.nextInt()) {
				case 1: //See Map Names and Their associated Number
					printMapNames(mapList);
					break;
				case 2: //Choose the Map you are on
					System.out.println("Enter the Number Associated with the map: ");
					currentMap = mapList.get(in.nextInt());
					choiceDecider.setMap(currentMap);
					printMenu();
					break;
				case 3: //Choose the Site you are attacking/defending
					System.out.println("The Sites and their associated number are\n ");
					printSiteNames(currentMap);
					System.out.println("\n input the number associated with your site");
					currentSiteIndex = in.nextInt();
					printMenu();
					break;
				case 4: //Choose whether you are attacking or defending
					System.out.println("Enter 1 for attacking, and two for defense");
					int temp = in.nextInt();
					if(temp == 1)
						attacking = true;
					else if(temp == 2)
						attacking = false;
					else
					System.out.println("\n + INVALID CHARACTER ENTERED! Try Again \n");
					printMenu();
					break;
				case 5: //Enter the Characters your team is currently playing
					System.out.println("Enter the number of characters already selected");
					int selectedChars = in.nextInt();
					System.out.println("The Characters and their numbers are\n");
					printOperators(operatorList, attacking);
					System.out.println("Enter the number for each of your teammates choices\n");
					for(int i = 0; i < selectedChars; i++) {
						choiceDecider.addOperatorAlreadyChosenType(operatorList.get(in.nextInt()).getType());
					}
					printMenu();
					break;
				case 6: //What Character should you play?"
					System.out.println("\n" + choiceDecider.recommendedToString(operatorList, currentSiteIndex, !attacking));
					System.out.println("\n Input any integer greater than 0 to reprint the menu");
					if(in.nextInt() > 0)
						printMenu();
					break;
				case 7: //which site is best?
					System.out.println(choiceDecider.bestSiteToHold());
					System.out.println("Would you like additional information about that site? (y for yes)");
					if(in.next().charAt(0) == 'y')
						System.out.println(choiceDecider.bestSiteInformation());
					System.out.println("\n Input any integer greater than 0 to reprint the menu");
					if(in.nextInt() > 0)
						printMenu();
					break;
				case 8: //additional Site information and recommendations
					System.out.println("\n" + choiceDecider.currentSiteInformation(currentMap.getSite(currentSiteIndex)) + "\n");
					System.out.println("\n Input any integer greater than 0 to reprint the menu");
					if(in.nextInt() > 0)
						printMenu();
					break;
				case 9: //Quit
					System.out.println("\n Exiting");
					run = false;
					in.close();
					break;
				default:
					System.out.println("\n + INVALID CHARACTER ENTERED! Try Again \n");
					printMenu();
					break;
			}
		}
		in.close();
	}
	
	//the print menu
	static void printMenu() {
		System.out.print(""
				+ "Options\n"
				+ "--------\n"
				+ "1) See Map Names and Their associated Number\n"
				+ "2) Choose the Map you are on\n"
				+ "3) Choose the Site you are attacking/defending\n"
				+ "4) Choose whether you are attacking or defending\n"
				+ "5) Enter the Characters your team is currently playing\n"
				+ "6) What Character should you play?\n"
				+ "7) What Site should you hold?\n"
				+ "8) additional Site information and recommendations\n"
				+ "9) Quit\n\n");
	}
	
	//prints the names of the maps and their index
	static void printMapNames(LinkedList<Map> mapList) {
		String output = "";
		for(int i = 0; i < mapList.size(); i++) 
			output += i + ": " + mapList.get(i).getName() + "\n";
		System.out.print(output);
	}
	
	//prints the site names for the current map and their index
	static void printSiteNames(Map currentMap) {
		System.out.print(currentMap.sitesToString());
	}
	
	//prints only the operators relevant to the users side and their index
	static void printOperators(LinkedList<Operators> operatorList, boolean attacking) {
		String position;
		if(attacking)
			position = "Offense";
		else
			position = "Defense";
		for(int i = 0; i < operatorList.size(); i++) {
			if(operatorList.get(i).position().equals(position))
				System.out.println(i + ": " + operatorList.get(i).toString());
		}
	}
	
}
