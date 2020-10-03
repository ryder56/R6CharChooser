//**************
// CSE 205: #11333 - T,Th - 4:30-5:45
// Assignment: assignment #6
// Author: Ryder Roth - 1216790822
// Description: This is the program that loads the map given the name of the file that contains the name of the map files and the file that contains all of the operators.
//**************
import java.util.*;
import java.io.*;

public class MapAndCharacterLoader {
	private File maps;
	private File characters;
	
	public MapAndCharacterLoader(String mapFile, String characterFile) {
		maps = new File(mapFile);
		characters = new File(characterFile);
	}
	
	//makes a linked list of all of the operators
	public LinkedList<Operators> loadOperatorList() throws FileNotFoundException {
		LinkedList<Operators> operatorList = new LinkedList<Operators>();
		Scanner in = new Scanner(characters);
		while(in.hasNextLine()) {
			String name = in.next();
			int type = in.nextInt();
			boolean isDefense = true;
			if(in.nextInt() == 0) 
				isDefense = false;
			double ranking = in.nextDouble();
			Operators newOperator = new Operators(name, type, isDefense);
			newOperator.setRanking(ranking);
			operatorList.add(newOperator);
			if(in.hasNextLine())
				in.nextLine();
		}
		in.close();
		return operatorList;
	}
	
	//makes a linked list of maps
	public LinkedList<Map> loadMapList() throws FileNotFoundException {
		Scanner in = new Scanner(maps);
		LinkedList<Map> mapList = new LinkedList<Map>();
		while(in.hasNextLine()) {
			String mapName = in.next();
			mapList.add(loadMap(mapName));
		}
		in.close();
		return mapList;
	}
	
	//loads the map given a filename
	public Map loadMap(String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileName));
		String mapName = in.next();
		in.nextLine();
		Map newMap = new Map(mapName);
		while(in.hasNextLine()) { //Establishes the each site for each map, only beefy because I wanted to make it obvious where variables come from for easier debugging
			int siteAFloor = in.nextInt();
			String siteAName = in.next();
			int siteBFloor = in.nextInt();
			String siteBName = in.next();
			Sites newSite = new Sites(siteAFloor, siteAName, siteBFloor, siteBName);
			in.nextLine();
			addHatchesToBarricade(in.nextInt(), in, newSite);
			in.nextLine();
			addWallsToElectrify(in.nextInt(), in, newSite);
			in.nextLine();
			addWallsToBarricade(in.nextInt(), in, newSite);
			in.nextLine();
			addRotationWallsToBreak(in.nextInt(), in, newSite);
			newSite.setIdealAttackComposition(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
			in.nextLine();
			newSite.setIdealDefenseComposition(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
			newMap.addSite(newSite);
		}
		in.close();
		return newMap;
	}
	
	//adds hatches to barricade to the site
	private void addHatchesToBarricade(int counter, Scanner in, Sites aSite) {
		for(int i = counter; i>0; i--) {
			int floor = in.nextInt();
			String location = in.next();
			String orientation = in.next();
			aSite.addHatchToBarricade(floor, location, orientation);
		}
	}
	
	//adds walls to barricade to the site
	private void addWallsToBarricade(int counter, Scanner in, Sites aSite) {
		for(int i = counter; i>0; i--) {
			int floor = in.nextInt();
			String location = in.next();
			char orientation = in.next().charAt(0);
			aSite.addWallToBarricade(floor, location, orientation);
		}
	}
	
	//adds walls to break for rotation to the site
	private void addRotationWallsToBreak(int counter, Scanner in, Sites aSite) {
		for(int i = counter; i>0; i--) {
			int floor = in.nextInt();
			String location = in.next();
			char orientation = in.next().charAt(0);
			aSite.addWallForRotation(floor, location, orientation);
		}
	}
	
	//adds walls that should be electrified to the site
	private void addWallsToElectrify(int counter, Scanner in, Sites aSite) {
		for(int i = counter; i>0; i--) {
			int floor = in.nextInt();
			String location = in.next();
			char orientation = in.next().charAt(0);
			aSite.addWallToElectrify(floor, location, orientation);
		}
	}
	
}
