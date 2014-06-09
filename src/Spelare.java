
public abstract class Spelare {
	
	static int antalSpelare = 0;
	String namn;
	String teken = "INGET TECKAN HA TILLDELATS";
	int h�jd = 0;
	int bred = 0;
	
	public Spelare(String namn,int h�jd, int bred){
		if(antalSpelare == 0){
			teken = "X";
		}else if (antalSpelare == 1)
			teken = "O";
		else
			teken = "P" + antalSpelare;
		antalSpelare++;
		
		this.namn = namn;
		
		this.h�jd = h�jd-1;
		this.bred = bred-1;
	}

	public String toString(){
		return teken; //var namn f�rut
	}
	
	public String getTecken(){
		return teken;
	}
	
	public abstract EttDrag g�rDrag(spelPlan2 sp);
}

