import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class preProcess {
	
	public List<String> fileArray;
	public int cutoff = -1;
	public ArrayList<juggler> jugglers = new ArrayList<juggler>();
	public ArrayList<circuit> circuits = new ArrayList<circuit>();
	public int max = -1; 
	
	public preProcess(Path p){
		try {
			fileArray = Files.readAllLines(p,StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("File not found.");
		}
	}
	
	public ArrayList<circuit> preProcessCircuits(){
		
		for(int i = 0; i < fileArray.size(); i++ ){
			if (fileArray.get(i).isEmpty()){
				//cutoff indicates where the start of jugglers is
				cutoff = i+1;
				//max is the maximum number of jugglers per circuit
				max = (fileArray.size()-cutoff)/(cutoff-1);
				break;
			}
			else{
				String[] splitted = fileArray.get(i).split("\\s+");
				int h = Integer.parseInt(splitted[2].substring(2));
				int e = Integer.parseInt(splitted[3].substring(2));
				int p = Integer.parseInt(splitted[4].substring(2));
				circuit C = new circuit(h, e, p, splitted[1]);
				circuits.add(C); 
			}
		}
		return circuits; 
	}
	
	public ArrayList<juggler> preProcessJugglers(){
		if(this.cutoff == -1){
			System.out.println("You must process circuits first.");
		}
		else{
			
			for(int j = this.cutoff; j < fileArray.size(); j++ ){
				String[] splitted = fileArray.get(j).split("\\s+");
				
				int h = Integer.parseInt(splitted[2].substring(2));
				int e = Integer.parseInt(splitted[3].substring(2));
				int p = Integer.parseInt(splitted[4].substring(2));
				juggler jug = new juggler(h, e, p, splitted[1]);
				
				String[] circuitsPref = splitted[5].split(",");
				for (int k = 0; k < circuitsPref.length; k++){
					String cIndex = circuitsPref[k].substring(circuitsPref[k].indexOf("C")+1);
					circuit c = circuits.get(Integer.parseInt(cIndex));
					jug.addPref(c);
				}
				jug.addNonPref(circuits);
				jugglers.add(jug);
			}
		}
		return jugglers; 
	}
	
	private int dotProduct(int h1, int e1, int p1, int h2, int e2, int p2){
		return e1*e2 + h1*h2 + p1*p2;
	}

	public void setCircuitPref(){
		for (circuit c : circuits){
			for (juggler j : jugglers){
				int dp = this.dotProduct(c.getH(), c.getE(), c.getP(), j.getH(), j.getE(), j.getP());
				c.addPref(j, dp);
				
			}
		}
	
	}
}
