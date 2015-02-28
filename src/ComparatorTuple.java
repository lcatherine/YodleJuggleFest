import java.util.*;

public class ComparatorTuple implements Comparator{
	
	public int compare(Object a, Object b){
		Tuple t1 = (Tuple) a;
		Tuple t2 = (Tuple) b;
		
		if (t1.y() instanceof Integer && t2.y() instanceof Integer){
			if ((int)t1.y() > (int)t2.y()){
				return 1;
			}
			else if ((int)t1.y() < (int)t2.y()){
				return -1;
			}
			else{
				return 0; 
			}
		}
		else{
			throw new IllegalArgumentException("Cannot compare tuples with non-integer y.");
		}
	}
}
