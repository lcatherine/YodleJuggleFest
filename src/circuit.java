import java.util.*;

public class circuit{
	
	//fields
	private ComparatorTuple cmp = new ComparatorTuple(); 
	private ArrayList<Integer> prefList = new ArrayList<Integer>();
	private PriorityQueue<Tuple<juggler, Integer>> matching = new PriorityQueue<Tuple<juggler, Integer>>(10, cmp); 
	
	//currentSize tracks the total number of matches made. It cannot be bigger than the max. 
	private int currentSize = 0; 
	private int H;
	private int E;
	private int P;
	private String name;
	
	//constructor
	public circuit(int Hand, int Endur, int Pizz, String n){
		setH(Hand);
		setE(Endur);
		setP(Pizz);
		setName(n); 
	}
	
	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
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
	
	//Adds the dot product for the corresponding juggler to preference list
	public void addPref(juggler j, Integer dp){
		int index = Integer.parseInt(j.getName().substring(1));
		this.prefList.add(index, dp);
	}
	
	//Gets the dot product for the associated juggler
	public int getRating(juggler n){
		int index = Integer.parseInt(n.getName().substring(1));
		return this.prefList.get(index);
	}
	
	public Tuple<juggler, Integer> peekMatch(){
		return matching.peek();
	}
	
	public Tuple<juggler, Integer> pollMatch(){
		return matching.poll();
	}
	
	public void addMatch(juggler j, int i){
		Tuple<juggler, Integer> newMatch = new Tuple<juggler, Integer>(j, i);
		matching.add(newMatch);
	}
	
	public Iterator<Tuple<juggler, Integer>> getMatches(){
		return this.matching.iterator();
	}
	
}
