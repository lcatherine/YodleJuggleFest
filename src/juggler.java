import java.util.*;

public class juggler {
	
	//fields
	private ArrayList<circuit> prefList = new ArrayList<circuit>();
	//processList stores all circuits with the preferred circuits first
	private ArrayList<circuit> processList = new ArrayList<circuit>();
	private int H;
	private int E;
	private int P; 
	private String name;
	
	//constructor
	public juggler(int Hand, int Endur, int Pizz, String n){
		this.setH(Hand);
		this.setE(Endur);
		this.setP(Pizz);
		this.setName(n); 
	}

	public int getH() {
		return H;
	}

	public void setH(int h) {
		H = h;
	}
	
	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}

	public int getP() {
		return P;
	}

	public void setP(int p) {
		P = p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addPref(circuit c){
		this.prefList.add(c);
		this.processList.add(c);
	}
	
	//Adds all other non-preferred circuits to the processList in case of no matches with preferred circuits.
	public void addNonPref(ArrayList<circuit> cs){
		for (circuit c : cs){
			if (!this.processList.contains(c)){
				this.processList.add(c);
			}
		}
	}
	
	//Returns an iterator for prefList or processList. Throws exception if illegal inputs.
	public Iterator<circuit> getList(String s){
		if (s == "prefList"){
			return this.prefList.iterator();
		}
		else if (s == "processList"){
			return this.processList.iterator();
		}
		else{
			throw new IllegalArgumentException("Input must be prefList or processList.");
		}
	}
	
	public circuit popPref(){
		return this.processList.remove(0);
	}
	
	
	
}
