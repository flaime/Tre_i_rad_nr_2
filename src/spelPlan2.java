
import java.util.ArrayList;


public class spelPlan2 {

	Spelare [][] spelplan;
	/*
	 * [0,0][0,1][0,2]
	 * [1,0][1,1][1,2]
	 * [2,0][2,1][2,2]
	 * 
	 */ //den är ju vänd fe!
	int höjd;
	int bred;
	
	//lista för att komma ihåg senaste dragen
		ArrayList<EttDrag> dragen = new ArrayList<>();
	
	public spelPlan2(int x, int y) {
		spelplan = new Spelare[x][y];
		höjd = y;
		bred = x;
	}
	
	public boolean setDrag(int x, int y, Spelare s){
		dragen.add(new EttDrag(x, y, s));
		spelplan[x][y] = s;
		return true;
	}
	
	public boolean taBortDrag(int x, int y){
		dragen.add(new EttDrag(x, y, null));
		spelplan[x][y] = null;
		return true;
	}

	public Spelare getPlatts(int x, int y){  //getPlatts
		//if(spelplan[x][y] != null)
			return spelplan[x][y];
	}
	
	public boolean omintegöraDrag(){
		if(dragen.size()> 0){
			spelplan[dragen.get(dragen.size()).getX()][dragen.get(dragen.size()).getY()] = dragen.get(dragen.size()).getSpelare();
			dragen.remove(dragen.size());
			return true;
		}else
			return false;
	}

	public int getHöjd(){
		return höjd;
	}
	
	public int getbred(){
		return bred;
	}
	
	public spelPlan2(spelPlan2 another) { //en kalss för att jag ska kunna kopera denna klass
	    this.spelplan = another.spelplan;
	    this.höjd = another.höjd;
	    this.bred = another.bred;
	  }

	public int getLängd(){
		return spelplan.length;
	}
	
	@Override
	public boolean equals(Object other) {
	    if (!(other instanceof spelPlan2)) {
	        return false;
	    }

	    spelPlan2 that = (spelPlan2) other;

	    // Custom equality check here.
	    return this.spelplan.equals(that.spelplan)
	        && this.höjd == that.höjd && this.bred == that.bred;
	}

	public boolean setDrag(EttDrag ettDrag) {
		System.out.println(ettDrag.toString());
		
		if(spelplan[ettDrag.getX()][ettDrag.getY()] == null){
		dragen.add(ettDrag);
		spelplan[ettDrag.getX()][ettDrag.getY()] = ettDrag.getSpelare();
		return true;
		}else{
			return false;
		}
		
	}
	
	public spelPlan2 kopia(){  //getPlatts
		spelPlan2 sp2 = new spelPlan2(bred, höjd);
		
		for (int i = 0; i < (bred); i++) {
			for (int j = 0; j < (höjd); j++) {
				//System.out.println(" J = " + j + " I = "+ i + " bred = " + bred + " höjd = " + höjd);
				sp2.setDrag(i, j, spelplan[i][j]);
			}
			
		}
		
			return sp2;
	}
}

//vekca 22 
//tisdag onsdag högvakt
//torsdag fredal lördag ledig
//söndag mondag jobb
//vecka 23
//tisdag onsdag torsdag ledig
//fredag långdag
//drottningholm lördag söndag samt mondag vecka 24
//typ semester efter det
//modag vecka 25 jobbar sen semester
