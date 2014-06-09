
import java.util.ArrayList;
import java.util.Random;


public class datorTänkade {

	ArrayList<BraNär> bn = new ArrayList<>();

	public EttDrag vadAttGöra(spelPlan2 spKopia, DatorSpelare datorSpelare) {
//		if(bn.size() == 0){
			Random slump = new Random();
			int x = slump.nextInt(3) ;
			int y = slump.nextInt(3) ;
			System.out.println("datorn har gjort dragetn (" +x + ":" + y + ")   x = " + x + " Y = " + y + " seplaren är " + datorSpelare.namn);
			return new EttDrag(x, y);
//		}
//		return null;
		
	}
	
	
}
