
import java.util.ArrayList;
import java.util.Random;


public class datorT�nkade {

	ArrayList<BraN�r> bn = new ArrayList<>();

	public EttDrag vadAttG�ra(spelPlan2 spKopia, DatorSpelare datorSpelare) {
//		if(bn.size() == 0){
			Random slump = new Random();
			int x = slump.nextInt(3) ;
			int y = slump.nextInt(3) ;
			System.out.println("datorn har gjort dragetn (" +x + ":" + y + ")   x = " + x + " Y = " + y + " seplaren �r " + datorSpelare.namn);
			return new EttDrag(x, y);
//		}
//		return null;
		
	}
	
	
}
