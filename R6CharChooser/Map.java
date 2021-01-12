//**************
// Author: Ryder Roth
// Description: This is the map class that stores what maps have and can do.
//**************
public class Map {
	private String name;
	private LinkedList<Sites> bombSites = new LinkedList<Sites>();
	
	public Map(String name) {
		this.name = name;
	}
	
	//add a site to the maps bombsite linked list.
	public void addSite(Sites aSite) {
		bombSites.add(aSite);
	}
	
	//get a site at an index
	public Sites getSite(int index) {
		return bombSites.get(index);
	}
	
	//get the site at index 0, since the list will be established in order of whats best to hold
	public String recommendedSite() {
		return bombSites.get(0).siteNamesToString();
	}
	
	//put the names of the sites on the map to a string
	public String sitesToString() {
		String sitesLeft = "";
		for(int i = 0; i<bombSites.size(); i++) {
			sitesLeft += i + " - " + bombSites.get(i).siteNamesToString() + "\n";
		}
		return sitesLeft;
	}
	
	//returns the name of the map
	public String getName() {
		return name;
	}
	
	//returns the best site(index 0) as a site
	public Sites getBestSite() {
		return bombSites.get(0);
	}
	
	
}
