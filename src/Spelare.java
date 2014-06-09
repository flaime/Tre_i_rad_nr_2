
public abstract class Spelare {
	
	static int antalSpelare = 0;
	String namn;
	String teken = "INGET TECKAN HA TILLDELATS";
	int höjd = 0;
	int bred = 0;
	
	public Spelare(String namn,int höjd, int bred){
		if(antalSpelare == 0){
			teken = "X";
		}else if (antalSpelare == 1)
			teken = "O";
		else
			teken = "P" + antalSpelare;
		antalSpelare++;
		
		this.namn = namn;
		
		this.höjd = höjd-1;
		this.bred = bred-1;
	}

	public String toString(){
		return teken; //var namn förut
	}
	
	public String getTecken(){
		return teken;
	}
	
	public abstract EttDrag görDrag(spelPlan2 sp);
}

