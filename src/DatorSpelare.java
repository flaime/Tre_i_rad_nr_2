


public class DatorSpelare extends Spelare {
	
	datorTänkade dt = new datorTänkade();
	DatorSpelare denna = this;

	public DatorSpelare(String namn, int höjd, int bred) {
		super(namn, höjd, bred);
		// TODO Auto-generated constructor stub
	}

	
	public EttDrag görDrag(spelPlan2 sp) {
		spelPlan2 spKopia = sp.kopia();
		EttDrag tillfälig = dt.vadAttGöra(spKopia, denna);
		return new EttDrag(tillfälig.getX(), tillfälig.getY(),this);//dt.vadAttGöra(spKopia, denna); //lägg till rätt vad som ska skickas med
	}

	public boolean avanceradGörDrag(){
		return true;
	}

}
