


public class DatorSpelare extends Spelare {
	
	datorT�nkade dt = new datorT�nkade();
	DatorSpelare denna = this;

	public DatorSpelare(String namn, int h�jd, int bred) {
		super(namn, h�jd, bred);
		// TODO Auto-generated constructor stub
	}

	
	public EttDrag g�rDrag(spelPlan2 sp) {
		spelPlan2 spKopia = sp.kopia();
		EttDrag tillf�lig = dt.vadAttG�ra(spKopia, denna);
		return new EttDrag(tillf�lig.getX(), tillf�lig.getY(),this);//dt.vadAttG�ra(spKopia, denna); //l�gg till r�tt vad som ska skickas med
	}

	public boolean avanceradG�rDrag(){
		return true;
	}

}
