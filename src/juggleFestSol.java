import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

//main class for running solution. To run, open cmd in bin folder and input java juggleFestSol input.txt
// output will appear in output.txt in the bin folder
public class juggleFestSol {
	
	public static void main (String[] args){
		
		String input = args[0];
		
		File here = new File("");
		
		String realPath = here.getAbsolutePath().substring(0,here.getAbsolutePath().indexOf("bin"));
		Path testPath = Paths.get(realPath, "src", input);
		
		preProcess prePro = new preProcess(testPath);
		prePro.preProcessCircuits();
		
		prePro.preProcessJugglers();
		prePro.setCircuitPref();
		
		match assign = new match(prePro.max);
		
		ArrayList<String> solution = assign.pairUp(prePro.circuits, prePro.jugglers);
		
		try {
			FileWriter writer = new FileWriter("output.txt");
			for (String s : solution){
				writer.write(s+"\n");
			}
			writer.close(); 
		} catch (IOException e) {
			System.out.println("File not found.");
		}
		
	}
}
