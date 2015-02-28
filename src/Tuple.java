
public class Tuple<X,Y> {
	
	public final X x;
	public final Y y;
	
	public Tuple(X x, Y y){
		this.x = x;
		this.y = y; 
	}
	
	public X x(){
		return this.x;
	}
	
	public Y y(){
		return this.y; 
	}
	
	public String toString(){
		return this.x + " " + this.y;
	}
}
