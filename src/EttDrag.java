
public class EttDrag {

	private int x;
	private int y;
	private Spelare somVarD�rInnan = null;
	
	public EttDrag(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public EttDrag(int x, int y, Spelare SomVarD�rInnan){
		this.x = x;
		this.y = y;
		this.somVarD�rInnan = SomVarD�rInnan;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public Spelare getSpelare(){
		return somVarD�rInnan;
	}
	
	public String toString(){
		return "denreturnerar saker" ; //X = " + x + " Y = " + y + " spelare = " + somVarD�rInnan;
	}
}
