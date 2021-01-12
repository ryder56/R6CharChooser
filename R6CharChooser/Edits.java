//**************
// Author: Ryder Roth
// Description: This is the edits class for creating edits to the current ops and etc.
//**************
import java.util.*;
import java.io.*;

public class Edits {
	File maps = new File("maps.txt");
	/*
	 * How the text files are setup
	 * 		maps.txt
	 * 			each name of the file that has the data for the map
	 * 		(mapname).txt
	 * 			line1 - mapName
	 * 			line2 - Site A Floor, Site A name, site B floor, site B name
	 * 			line3 - # of hatches to barricade, (for each hatch) floor, location(string), orientation(string)
	 * 			line4 - # of walls to electrify, (for each wall) floor, location(string), orientation(char)
	 * 			line5 - # of walls to barricade, (for each wall) floor, location(string), orientation(char)
	 * 			line6 - # of rotation walls to break, (for each wall) floor, location(string), orientation(char)
	 * 			line7 - ideal attack composition
	 * 			line8 - ideal defense composition
	 * 			(repeat lines 2-8 for the next 3 sites)
	 * 
	 */
	/*
	 * Take in an edit of type:
	 * 	a) new map
	 * 	b) map edit
	 * 		site edit
	 * 		site op edit
	 * 		site comp edit
	 * 		site hatch edit
	 * 		site ideals edit
	 * 		site ideal barricade (either type) edit
	 * 	c) add new character(s)
	 * 	d) edit operator
	 * 		add types
	 * 		remove types
	 * 		
	 */
	
	public void addNewMap(String mapName) throws FileNotFoundException{
		String fileName = mapName + ".txt";
		Scanner in = new Scanner(System.in);
		File newMap = new File(fileName);
		PrintWriter out = new PrintWriter(newMap);
		addToMapList(fileName); //adding name of file to mapList to be read on launch
		String mapDetails = "";
		for(int i = 0; i < 4; i++) {
			mapDetails += getSiteDetails(in) + "\n";
		}

		
		//repeat for all 4 sites
		
		//add to maps text file the name of the map file
		
		//make map file and write the string to the file
		
		in.close();
	}
	
	private void addToMapList(String fileName) throws FileNotFoundException {
		PrintWriter mapList = new PrintWriter(maps);
		mapList.print("\n" + fileName);
		mapList.close();
	}
	
	private String getSiteDetails(Scanner in) {
		String siteDetails = "";
		siteDetails += siteNamesAndFloor(in) + "\n";
		siteDetails += hatchesToBarricade(in) + "\n";
		siteDetails += wallsToElectrify(in) + "\n";
		siteDetails += wallsToBarricade(in) + "\n";
		
		
		//get rot walls
		//get ideal attack
		//get ideal defense
		
		//get site details
		return siteDetails;
	}
	
	private String siteNamesAndFloor(Scanner in) {
		System.out.println("Enter A Site Floor");
		int siteAFloor = in.nextInt();
		System.out.println("Enter A Site Name Without Spaces.");
		String siteAName = in.next();
		System.out.println("Enter B Site Floor");
		int siteBFloor = in.nextInt();
		System.out.println("Enter B Site Name Without Spaces.");
		String siteBName = in.next();
		String siteNamesAndFloor = siteAFloor + " " + siteAName + " " + siteBFloor + " " + siteBName;
		return siteNamesAndFloor;
	}
	
	private String hatchesToBarricade(Scanner in) {
		System.out.println("Enter the number of Hatches that should be barricaded.");
		int numberOfHatches = in.nextInt();
		String hatchesListAsString = numberOfHatches + " ";
		for(int i = 0; i<numberOfHatches; i++) {
			System.out.println("Enter the floor the hatch is on.");
			hatchesListAsString += in.nextInt() + " ";
			System.out.println("Enter the location of the hatch without spaces.");
			hatchesListAsString += in.next() + " ";
			System.out.println("Enter the side of the room the hatch is on and what it is next to without spaces.");
			hatchesListAsString += in.next() + " ";
		}
		return hatchesListAsString;
	}
	
	private String wallsToBarricade(Scanner in) {
		System.out.println("Enter the number of walls that should be barricaded.");
		int numberOfWalls = in.nextInt();
		String wallsListAsString = numberOfWalls + " ";
		for(int i = 0; i<numberOfWalls; i++) {
			System.out.println("Enter the floor the Wall is on.");
			wallsListAsString += in.nextInt() + " ";
			System.out.println("Enter the location of the Wall without spaces");
			wallsListAsString += in.next() + " ";
			System.out.println("Enter side of the room the wall is on.");
			wallsListAsString += in.next().charAt(0) + " ";
		}
		return wallsListAsString;
	}
	
	private String wallsToElectrify(Scanner in) {
		System.out.println("Enter the number of walls that should be Electrified.");
		int numberOfWalls = in.nextInt();
		String wallsListAsString = numberOfWalls + " ";
		for(int i = 0; i<numberOfWalls; i++) {
			System.out.println("Enter the floor the Wall is on.");
			wallsListAsString += in.nextInt() + " ";
			System.out.println("Enter the location of the Wall without spaces");
			wallsListAsString += in.next() + " ";
			System.out.println("Enter side of the room the wall is on.");
			wallsListAsString += in.next().charAt(0) + " ";
		}
		return wallsListAsString;
	}
	
	
	
	
	
	
	public void map() {
		//TODO mapEdit takes a char argument, then based off that char argument will call another method
		//TODO move this method to the main area, this is a holder.
	}
	
	public void site() {
		//TODO add ability to delete a site then add another in place of the deleted one that is the new site
	}
	
	public void siteDefenseOp() {
		//TODO add the ability to edit which DEFENSE operators are needed in the site
	}
	
	public void siteOfenseOp() {
		//TODO add the ability to edit which OFFENSE operators are needed in the site
	}
	
	public void addSiteHatch() {
		//TODO ability to edit what hatches need to be barricaded on that site
	}
	
	public void siteRotationWallsToBreak() {
		//TODO edit rotation walls to break
	}
	
	public void siteHatchesToBarricade() {
		//TODO edit hatches to barricade()
	}
	
	public void siteWallsToBarricade() {
		//TODO edit walls to barricade
	}
	
	public void siteWallsToElectrify() {
		//TODO edit walls to electrify
	}
}
