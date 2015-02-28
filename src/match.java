import java.util.*;


public class match {
	
	private int max;
	public ArrayList<String> output = new ArrayList<String>();
	
	match(int m){
		this.max = m;
	}
	
	public ArrayList<String> pairUp(ArrayList<circuit> circuits, ArrayList<juggler> jugglers){
		
		ArrayList<juggler> working = jugglers; 
		
		while (working.size() > 0 ){
			
			juggler j = working.get(0);
			circuit c = j.popPref();
			
			//if the currently preferred circuit is not full of jugglers, add j
			if (c.getCurrentSize() < max){
				c.addMatch(j, c.getRating(j));
				c.setCurrentSize(c.getCurrentSize() + 1);
				working.remove(j);
			
			}
			else{ /*circuit full of jugglers already. swap the lowest ranked juggler
				with current juggler if ranking is lower than current juggler's ranking*/ 
				Integer jRating = c.getRating(j);
				Tuple<juggler, Integer> lowest = c.peekMatch();
				
				if (lowest.y() < jRating){
					juggler removing = c.pollMatch().x();
					working.add(removing);
					c.addMatch(j, jRating);
					working.remove(j);
				}
			}
		}
		
		//Puts output matchings into an arraylist for writing into text file. 
		for (circuit c : circuits){
			Iterator<Tuple<juggler, Integer>> matches = c.getMatches(); 
			String out = c.getName() + " "; 
			while(matches.hasNext()){
				Tuple<juggler, Integer> jMatch = matches.next(); 
				String s = jMatch.x().getName() + " ";
				
				Iterator<circuit> jPref = jMatch.x().getList("prefList");
				while(jPref.hasNext()){
					circuit cs = jPref.next(); 
					int rating = cs.getRating(jMatch.x());
					s += cs.getName() + ":"+ String.valueOf(rating) + " ";
				}
				out += " " + s.trim() + ","; 
			} 
			output.add(out.substring(0, out.length()-1)); 
		}
		return output; 
	}
	
}
